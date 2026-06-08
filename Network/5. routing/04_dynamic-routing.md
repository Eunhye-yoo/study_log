# Dynamic Routing (동적 라우팅)

## Dynamic Routing이란?

Dynamic Routing(동적 라우팅)은 Router가 자신이 알고 있는 네트워크 정보를 다른 Router와 자동으로 교환하여 Routing Table을 만드는 방식이다.

Static Routing은 관리자가 직접 경로를 입력하지만,

Dynamic Routing은 Router끼리 서로 정보를 주고받으며 경로를 학습한다.

```text
Router A
     ↕
Router B
     ↕
Router C
```

각 Router는 자신이 알고 있는 네트워크를 광고(Advertisement)하고,

다른 Router의 광고를 받아 Routing Table을 자동으로 갱신한다.

---

## 왜 Dynamic Routing을 사용할까?

Static Routing은 Router가 많아질수록 관리가 어려워진다.

예)

```text
Router 2대
→ 설정 몇 줄
```

```text
Router 50대
→ 수백 개의 경로 입력
```

네트워크 규모가 커질수록 관리가 힘들어진다.

Dynamic Routing은 Router끼리 자동으로 정보를 교환하므로 대규모 네트워크에서 효율적이다.

---

## Dynamic Routing 동작 방식

Router는 주기적으로 자신이 알고 있는 네트워크를 광고한다.

예)

```text
Router0

192.168.53.0/24 보유
```

↓

```text
Router1에게 광고
```

↓

```text
Router1 Routing Table 등록
```

↓

```text
다른 Router에게 재광고
```

결과적으로 모든 Router가 서로의 네트워크를 학습하게 된다.

---

## Dynamic Routing의 장점

### 자동 경로 학습

관리자가 일일이 경로를 등록하지 않아도 된다.

### 장애 대응 가능

기존 경로에 문제가 발생하면 새로운 경로를 자동으로 찾는다.

### 대규모 네트워크에 적합

Router 수가 많아도 관리가 쉽다.

---

## Dynamic Routing의 단점

### 설정이 복잡하다

Static Routing보다 설정이 어렵다.

### 자원 사용

CPU와 메모리를 사용한다.

### 네트워크 트래픽 발생

Router끼리 주기적으로 정보를 교환한다.

---

## Dynamic Routing Protocol

대표적인 동적 라우팅 프로토콜

```text
RIP
```

```text
OSPF
```

```text
EIGRP
```

```text
BGP
```

---

### RIP

```text
거리(Hop Count) 기준
```

경로 선택

```text
최대 15 Hop
```

지원

```text
소규모 네트워크
```

에 적합

---

### OSPF

```text
대역폭(Cost) 기준
```

경로 선택

```text
빠른 수렴
```

특징

```text
기업 네트워크에서 가장 많이 사용
```

---

### EIGRP

Cisco 전용 프로토콜

```text
대역폭 + 지연시간
```

등을 함께 고려

---

### BGP

인터넷에서 사용하는 라우팅 프로토콜

```text
AS(Autonomous System)
```

간 라우팅 수행

---

## Routing Table에서 확인

명령어

```bash
show ip route
```

예)

```text
R 192.168.54.0/24
```

```text
R = RIP
```

---

```text
O 192.168.54.0/24
```

```text
O = OSPF
```

---

```text
D 192.168.54.0/24
```

```text
D = EIGRP
```

---

## Dynamic Routing과 Static Routing 비교

| 구분 | Static Routing | Dynamic Routing |
|--------|--------|--------|
| 설정 | 수동 | 자동 |
| 관리 | 어려움 | 쉬움 |
| CPU 사용 | 적음 | 많음 |
| 장애 대응 | 불가능 | 가능 |
| 대규모 환경 | 비효율 | 적합 |

---

## 암기 포인트

```text
Dynamic Routing

Router끼리 자동 학습
```

```text
광고(Advertisement)
```

```text
자동 Routing Table 생성
```

```text
장애 발생 시 자동 우회
```

```text
RIP = Hop Count
```

```text
OSPF = Cost(대역폭)
```

---

## 정리

- Dynamic Routing은 Router끼리 네트워크 정보를 자동으로 교환하는 방식이다.
- Router는 광고(Advertisement)를 통해 경로를 학습한다.
- 대규모 네트워크에서 주로 사용된다.
- 장애 발생 시 새로운 경로를 자동으로 찾을 수 있다.
- 대표 프로토콜은 RIP, OSPF, EIGRP, BGP가 있다.

## 한 줄 요약

Dynamic Routing은 Router끼리 네트워크 정보를 자동으로 교환하여 Routing Table을 생성하고 관리하는 방식이다.
