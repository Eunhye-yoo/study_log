# Trunk

## Trunk란?

Trunk는 여러 VLAN의 트래픽을 하나의 포트로 동시에 전달하는 기술이다.

VLAN을 하나의 Switch에서만 사용한다면 Access Port만 있어도 된다.

하지만 실제 네트워크에서는 여러 Switch를 연결해야 한다.

예)

```text
VLAN10 PC

↓

SW0

↓

SW1

↓

VLAN10 PC
```

이 경우 Switch끼리 VLAN 정보를 전달해야 한다.

만약 Switch끼리를 Access Port로 연결하면 하나의 VLAN만 전달할 수 있다.

여러 VLAN을 동시에 전달하려면 Trunk가 필요하다.

---

## 왜 Trunk가 필요할까?

VLAN10이 SW0에 있고, 같은 VLAN10 PC가 SW1에 있다고 가정하자.

```text
PC0(VLAN10)

↓

SW0

↓

SW1

↓

PC1(VLAN10)
```

이때 SW0는 SW1에게 데이터를 보내야 한다.

하지만 데이터만 보내면 SW1은 이 데이터가 VLAN10인지 VLAN20인지 알 수 없다.

그래서 Switch는 Trunk 통신 시 VLAN Tag를 추가한다.

```text
SW0

Hello + VLAN10 Tag

↓

SW1

↓

VLAN10 데이터라고 판단

↓

VLAN10 포트로 전달
```

즉, Trunk는 여러 VLAN 정보를 잃어버리지 않고 Switch끼리 전달하기 위한 기술이다.

---

## Access Port와 Trunk Port 차이

### Access Port

하나의 VLAN만 통신 가능

주로 PC, Printer, Server 연결

```text
PC

↓

Access Port

↓

Switch
```

### Trunk Port

여러 VLAN 동시 통신 가능

주로 Switch, Router, L3 Switch 연결

```text
Switch

↓

Trunk Port

↓

Switch
```

---

## Trunk는 어떻게 VLAN을 구분할까?

Switch는 Frame에 VLAN 번호를 추가한다.

이것을

```text
VLAN Tag
```

라고 한다.

예)

```text
PC 데이터

↓

VLAN10 Tag 추가

↓

Trunk 전송
```

상대방 Switch는 Tag를 보고

```text
아 VLAN10 데이터구나
```

라고 판단한다.

---

## VLAN Tagging

Trunk는 VLAN 정보를 구분하기 위해 VLAN Tag를 사용한다.

현재 대부분

```text
IEEE 802.1Q
(Dot1Q)
```

방식을 사용한다.

동작 과정

```text
PC 데이터 생성

↓

Switch가 VLAN Tag 추가

↓

Trunk 전송

↓

상대 Switch가 VLAN 확인

↓

목적지 전달
```

---

## Trunk 설정

### 기본 Trunk 설정

```bash
Switch(config)# interface fastethernet 0/24
Switch(config-if)# switchport mode trunk
```

의미

```text
Fa0/24 포트를 Trunk Port로 설정
```

### 허용 VLAN 지정

```bash
Switch(config-if)# switchport trunk allowed vlan 10,20
```

의미

```text
VLAN10, VLAN20만 Trunk 통과 허용
```

### 모든 VLAN 허용

```bash
Switch(config-if)# switchport trunk allowed vlan all
```

의미

```text
모든 VLAN 통과 허용
```

### Trunk 해제

```bash
Switch(config-if)# switchport mode access
```

의미

```text
Access Port로 변경
```

---

## Allowed VLAN

Trunk는 기본적으로 모든 VLAN을 전달할 수 있다.

하지만 특정 VLAN만 허용할 수도 있다.

예)

```bash
Switch(config-if)# switchport trunk allowed vlan 10,20
```

의 의미

```text
VLAN10 통과

VLAN20 통과

VLAN30 차단

VLAN40 차단
```

실무에서는 보안과 트래픽 관리를 위해 필요한 VLAN만 허용하는 경우가 많다.

---

## Native VLAN

802.1Q에서는 기본적으로 Tag를 붙이지 않는 VLAN이 존재한다.

이를 Native VLAN이라고 한다.

기본값은

```text
VLAN 1
```

이다.

예)

```text
Native VLAN

↓

Tag 없이 전송
```

```text
기타 VLAN

↓

Tag 추가 후 전송
```

Trunk 양쪽 장비의 Native VLAN이 서로 다르면 통신 문제가 발생할 수 있다.

---

## DTP (Dynamic Trunking Protocol)

Cisco 장비는 서로 Port Mode를 자동 협상할 수 있다.

이를 DTP(Dynamic Trunking Protocol)라고 한다.

실무에서는 자동 협상보다 직접 Trunk 또는 Access를 지정하는 경우가 많다.

### DTP 모드

| 모드 | 설명 |
|--------|--------|
| Access | 항상 Access |
| Trunk | 항상 Trunk |
| Dynamic Auto | 상대방이 Trunk를 원하면 Trunk |
| Dynamic Desirable | 먼저 Trunk 요청 |

### DTP 협상 결과

| 내 포트 | 상대 포트 | 결과 |
|----------|----------|----------|
| Access | Access | Access |
| Auto | Auto | Access |
| Auto | Desirable | Trunk |
| Auto | Trunk | Trunk |
| Desirable | Desirable | Trunk |
| Desirable | Trunk | Trunk |
| Trunk | Trunk | Trunk |

암기

```text
Auto + Auto = Access

Auto + Desirable = Trunk
```

---

## Trunk 확인 명령어

### Trunk 상태 확인

```bash
show interfaces trunk
```

확인 내용

```text
Trunk 포트 확인

허용 VLAN 확인

Native VLAN 확인
```

### VLAN 확인

```bash
show vlan brief
```

확인 내용

```text
VLAN 목록

각 포트의 VLAN 소속 확인
```

---

## 실습 1 - Trunk 기본 설정

### 사용 장비

- Switch 2대
- PC 4대

### 토폴로지

```text
PC0(VLAN10)            PC1(VLAN10)
     |                      |
    SW0 ===== Trunk ===== SW1
     |                      |
PC2(VLAN20)            PC3(VLAN20)
```

### IP 설정

```text
VLAN10

PC0
192.168.10.10

PC1
192.168.10.20
```

```text
VLAN20

PC2
192.168.20.10

PC3
192.168.20.20
```

### 목표

- VLAN10 생성
- VLAN20 생성
- Access Port 설정
- Trunk 설정
- VLAN10 통신 확인
- VLAN20 통신 확인

### 캡처

```md
![Trunk Topology](../images/switching/trunk-topology.png)

(토폴로지 전체)

![Trunk Config](../images/switching/trunk-config.png)

(SW0, SW1의 Fa0/24를 Trunk로 설정한 CLI 화면)

![Show Trunk](../images/switching/show-trunk.png)

(show interfaces trunk 결과)

확인 내용

Fa0/24 = trunk

Allowed VLAN = 10,20

Native VLAN = 1

![VLAN10 Ping](../images/switching/vlan10-ping.png)

(PC0 → PC1 Ping 성공)

![VLAN20 Ping](../images/switching/vlan20-ping.png)

(PC2 → PC3 Ping 성공)
```

---

## 실습 2 - Allowed VLAN 확인

### 목표

Trunk에서 특정 VLAN만 허용되는지 확인

### 설정

```bash
Switch(config-if)# switchport trunk allowed vlan 10,20
```

### 확인 내용

```text
VLAN10 통신 가능

VLAN20 통신 가능

VLAN30 통신 불가
```

### 캡처

```md
![Allowed VLAN](../images/switching/trunk-allowed-vlan.png)

(allowed vlan 설정 화면)

![VLAN30 Fail](../images/switching/vlan30-fail.png)

(VLAN30 Ping 실패)
```

---

## 암기 포인트

```text
Trunk = 여러 VLAN 전달

Access = 하나의 VLAN 전달

802.1Q = VLAN Tagging

Allowed VLAN = 허용 VLAN 제한

Native VLAN = 기본 VLAN 1

Auto + Auto = Access

Auto + Desirable = Trunk

show interfaces trunk
```

---

## 정리

- Trunk는 여러 VLAN의 트래픽을 하나의 포트로 전달하는 기술이다.
- 주로 Switch 간 연결에 사용된다.
- VLAN 정보를 구분하기 위해 802.1Q Tag를 사용한다.
- Allowed VLAN을 통해 특정 VLAN만 전달할 수 있다.
- Native VLAN은 기본적으로 Tag 없이 전달된다.
- DTP를 이용하면 Cisco 장비끼리 Trunk를 자동 협상할 수 있다.
- Trunk가 없으면 여러 Switch에서 동일 VLAN을 사용할 수 없다.

## 한 줄 요약

Trunk는 여러 VLAN의 트래픽을 하나의 링크로 전달하기 위해 VLAN Tag(802.1Q)를 사용하는 Switch 간 연결 기술이다.
