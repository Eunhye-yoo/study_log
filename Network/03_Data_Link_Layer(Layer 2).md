# Data Link Layer (Layer 2)

## 개요

Data Link Layer는 같은 네트워크(LAN) 안에서 장비 간 통신을 담당하는 계층이다.

Physical Layer가 단순히 신호를 전달하는 역할이라면,

Data Link Layer는

"누구에게 보내야 하는가?"

를 판단하여 데이터를 전달한다.

- PDU : Frame
### Frame이란?

Frame은 Data Link Layer에서 사용하는 PDU로,
출발지 MAC Address와 목적지 MAC Address 등의 정보를 포함한 데이터 단위이다.

쉽게 말해 데이터를 MAC 주소 정보와 함께 포장한 "봉투"라고 생각하면 된다.
---

## MAC Address

### MAC Address란?

MAC(Media Access Control) Address는 네트워크 장비를 식별하기 위한 물리적 주소이다.

사람에게 주민등록번호가 있듯이,

네트워크 장비에게는 MAC Address가 있다.

모든 랜카드(NIC)는 제조 시 고유한 MAC Address를 부여받는다.

---

### 특징

- 48bit 주소
- 16진수로 표기
- 제조사마다 고유하게 부여됨

예)

00:1A:2B:3C:4D:5E

---

### 왜 필요한가?

같은 네트워크 안에서

"누구에게 데이터를 보내야 하는지"

구분하기 위해 사용한다.

예)

PC-A → PC-B

통신 시 실제로는 MAC Address를 이용하여 데이터를 전달한다.

---

## Ethernet Protocol

### Ethernet이란?

LAN 환경에서 가장 널리 사용되는 통신 규약(Protocol)이다.

쉽게 말하면

같은 네트워크 안의 장비들이 데이터를 주고받기 위한 규칙이다.

---

### 특징

- IEEE 802.3 표준 사용
- MAC Address 기반 통신
- PDU : Frame

---

### Ethernet 종류

| 종류 | 속도 |
|--------|--------|
| Standard Ethernet | 10 Mbps |
| Fast Ethernet | 100 Mbps |
| Gigabit Ethernet | 1000 Mbps (1Gbps) |
| 10 Gigabit Ethernet | 10Gbps |

---

## Switch

### 왜 필요한가?

Hub는 목적지를 구분하지 못하고

모든 포트로 데이터를 전송했다.

따라서

- 불필요한 트래픽 발생
- Collision 발생
- 성능 저하

문제가 있었다.

Switch는 이러한 문제를 해결하기 위해 등장하였다.

---

## MAC Address Table

Switch는

"어떤 MAC Address가 어느 포트에 연결되어 있는지"

기억하는 표를 가지고 있다.

이를

MAC Address Table

이라고 한다.

예)

MAC Address | Port
------------|------
AA-AA-AA | Fa0/1
BB-BB-BB | Fa0/2
CC-CC-CC | Fa0/3

---

## Switch의 5가지 기능

### 1. Flooding

목적지 MAC Address를 모를 때

수신한 포트를 제외한 모든 포트로 데이터를 전송한다.

처음 통신이 시작될 때 발생한다.

예)

A → B 통신 시

Switch가 B의 위치를 모름

↓

모든 포트로 전송

---

### 2. Learning

Switch는 수신된 Frame의 출발지 MAC Address를 학습한다.

학습한 MAC Address는 MAC Address Table에 저장된다.

예)

A의 Frame 수신

↓

"A는 Port 1에 연결되어 있구나"

↓

MAC Table 저장

---

### 3. Forwarding

목적지 MAC Address를 알고 있다면

해당 포트로만 데이터를 전송한다.

예)

A → B

↓

B가 Port2에 있다는 것을 알고 있음

↓

Port2로만 전송

---

### 4. Filtering

목적지와 관계없는 포트에는 데이터를 보내지 않는다.

불필요한 트래픽을 줄여준다.

---

### 5. Aging

오랫동안 사용되지 않은 MAC Address 정보를 삭제한다.

장비 위치가 바뀌었을 수 있기 때문이다.

---

## Flooding → Learning → Forwarding 흐름

처음 통신

A → B

↓

Switch가 B를 모름

↓

Flooding

↓

A의 MAC 주소 학습

↓

B의 응답 수신

↓

B의 MAC 주소 학습

↓

다음 통신부터는

Forwarding

---

## CSMA/CD

Carrier Sense Multiple Access with Collision Detection

Hub 환경에서 발생하는 Collision 문제를 해결하기 위한 기술이다.

동작 방식

1. 통신하기 전에 선로 사용 여부 확인
2. 사용 중이면 대기
3. 비어 있으면 전송
4. Collision 발생 시 랜덤 시간 대기 후 재전송

---

## CSMA/CA

Carrier Sense Multiple Access with Collision Avoidance

무선(Wi-Fi) 환경에서 사용하는 방식이다.

무선은 Collision을 감지하기 어렵기 때문에

충돌이 발생하기 전에 최대한 회피하도록 설계되었다.

---

## 정리

- Layer 2는 같은 네트워크 내 장비 간 통신을 담당한다.
- MAC Address를 사용하여 장비를 식별한다.
- Ethernet은 LAN 환경에서 사용하는 대표 프로토콜이다.
- PDU는 Frame이다.
- Switch는 MAC Address Table을 이용하여 목적지로만 데이터를 전달한다.
- Switch의 핵심 동작 순서는 Flooding → Learning → Forwarding이다.
- Hub의 Collision 문제를 개선하기 위해 Switch가 등장하였다.
