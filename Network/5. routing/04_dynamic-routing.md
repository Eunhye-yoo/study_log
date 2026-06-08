# Dynamic Routing (동적 라우팅)

## Dynamic Routing이란?

Dynamic Routing(동적 라우팅)은 Router가 자신이 알고 있는 네트워크 정보를 다른 Router와 자동으로 교환하여 Routing Table을 생성하는 방식이다.

Static Routing처럼 관리자가 모든 경로를 직접 입력하지 않아도 되며, Router끼리 정보를 광고(Advertisement)하고 학습하여 경로를 자동으로 관리한다.

```text
Router0
   ↕
Router1
   ↕
Router2
```

각 Router는 자신이 알고 있는 네트워크를 광고하고, 다른 Router의 광고를 받아 Routing Table에 등록한다.

---

## 왜 Dynamic Routing을 사용할까?

Static Routing은 Router 수가 적을 때는 간단하지만 네트워크 규모가 커질수록 관리가 어려워진다.

예를 들어 Router가 2~3대라면 수동 설정이 가능하지만, 수십 대 이상이 되면 수백 개의 경로를 직접 관리해야 한다.

Dynamic Routing은 Router끼리 자동으로 정보를 교환하기 때문에 대규모 네트워크에서 효율적이다.

---

## Dynamic Routing 동작 과정

Router는 자신이 직접 연결된 네트워크 정보를 주기적으로 광고한다.

예)

```text
Router0
192.168.53.0/24 보유

↓

Router1에게 광고

↓

Router1 Routing Table 등록

↓

다른 Router에게 재광고
```

이 과정을 반복하면서 모든 Router가 네트워크 정보를 학습하게 된다.

---

## Dynamic Routing의 특징

### 자동 경로 학습

Router끼리 정보를 교환하여 Routing Table을 자동으로 생성한다.

### 자동 경로 변경

기존 경로에 문제가 발생하면 새로운 경로를 계산하여 사용한다.

### 대규모 네트워크에 적합

Router 수가 많아도 관리가 쉽다.

### 자원 사용

CPU, 메모리, 네트워크 대역폭을 사용한다.

---

## Dynamic Routing Protocol

대표적인 동적 라우팅 프로토콜

| 프로토콜 | 경로 선택 기준 | 특징 |
|----------|----------|----------|
| RIP | Hop Count | 설정 단순 |
| OSPF | Cost(대역폭) | 기업 환경에서 많이 사용 |
| EIGRP | 복합 Metric | Cisco 전용 |
| BGP | 정책 기반 | 인터넷 라우팅 |

---

## Routing Table에서 확인

명령어

```bash
show ip route
```

Routing Table에서 사용하는 코드

| 코드 | 의미 |
|--------|--------|
| C | Connected |
| S | Static |
| R | RIP |
| O | OSPF |
| D | EIGRP |

예)

```text
R 192.168.54.0/24
```

→ RIP가 학습한 경로

```text
O 192.168.54.0/24
```

→ OSPF가 학습한 경로

---

## Static / Default / Dynamic Routing 비교

| 구분 | Static | Default | Dynamic |
|--------|--------|--------|--------|
| 설정 방식 | 수동 | 수동 | 자동 |
| 경로 수 | 목적지마다 입력 | 1개만 입력 | 자동 생성 |
| 관리 편의성 | 낮음 | 높음 | 매우 높음 |
| 대규모 환경 | 비효율 | 부적합 | 적합 |
| 장애 대응 | 불가능 | 불가능 | 가능 |
| 대표 명령어 | ip route | ip route 0.0.0.0 0.0.0.0 | RIP, OSPF |

---

## 언제 사용할까?

### Static Routing

```text
소규모 네트워크
Router 수가 적은 환경
```

### Default Routing

```text
Stub Network
(말단 네트워크)
```

### Dynamic Routing

```text
중대형 네트워크
기업 환경
```

---

## 암기 포인트

```text
Dynamic Routing

Router끼리 자동 학습
```

```text
Advertisement

라우팅 정보 광고
```

```text
RIP = Hop Count
```

```text
OSPF = Cost(대역폭)
```

```text
장애 발생 시 자동 우회 가능
```

---

## 정리

- Dynamic Routing은 Router끼리 자동으로 네트워크 정보를 교환하는 방식이다.
- Router는 광고(Advertisement)를 통해 경로를 학습한다.
- 네트워크 규모가 커질수록 Dynamic Routing이 유리하다.
- 장애 발생 시 새로운 경로를 자동으로 계산할 수 있다.
- 대표 프로토콜은 RIP, OSPF, EIGRP, BGP가 있다.

## 한 줄 요약

Dynamic Routing은 Router끼리 네트워크 정보를 자동으로 교환하여 Routing Table을 생성하고 관리하는 방식이다.
