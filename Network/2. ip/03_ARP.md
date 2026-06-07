# ARP (Address Resolution Protocol)

## ARP란?

ARP(Address Resolution Protocol)는

IP Address를 이용하여 MAC Address를 알아내는 프로토콜이다.

같은 네트워크(LAN)에서 통신할 때 사용된다.

> ARP는 "전화번호(IP)는 아는데 집 주소(MAC)는 모르는 상황"에서 집 주소를 알아내는 과정이라고 생각하면 된다.

---

## ARP는 누가 수행할까?

ARP는 MAC Address가 필요한 네트워크 장비가 수행한다.

대표적으로

- PC
- Server
- Router(공유기)
- L3 Switch

등이 ARP를 사용할 수 있다.

즉,

```text
ARP = PC, Server, Router 등 통신하려는 장비가 수행

L2 Switch = ARP를 생성하지 않고 전달만 수행
```

이다.

예)

```text
PC A
192.168.0.10

↓

PC B
192.168.0.20
```

PC A가 데이터를 보내려면 PC B의 MAC Address를 알아야 한다.

이때 PC A가 직접 ARP Request를 전송한다.

---

## 왜 ARP가 필요할까?

우리는 보통 상대방의 IP Address만 알고 있다.

예)

```text
내 PC
192.168.0.10

상대 PC
192.168.0.20
```

하지만 실제 데이터를 전송하려면

Data Link Layer의 MAC Address가 필요하다.

즉,

```text
IP Address는 알고 있지만

MAC Address는 모르는 상황
```

이 발생한다.

이때 ARP가 동작하여 상대방의 MAC Address를 알아낸다.

---

## ARP의 역할

```text
IP Address
↓
MAC Address 변환
```

예)

```text
192.168.0.20

↓

AA-AA-AA-AA-AA-AA
```

---

## ARP는 언제 사용될까?

같은 네트워크에 있는 장비와 통신할 때 사용된다.

예)

```text
PC A

192.168.0.10
```

↓

```text
PC B

192.168.0.20
```

PC A는

```text
192.168.0.20
```

이라는 IP는 알고 있지만

MAC Address는 모른다.

따라서 ARP를 사용하여 MAC Address를 조회한다.

---

# ARP 동작 과정

상황

```text
PC A

IP : 192.168.0.10
MAC : AA-AA-AA-AA-AA-AA
```

↓

```text
PC B

IP : 192.168.0.20
MAC : BB-BB-BB-BB-BB-BB
```

---

### 1단계

PC A가

```text
192.168.0.20
```

으로 데이터를 보내려고 한다.

---

### 2단계

ARP Cache Table을 확인한다.

```text
192.168.0.20 → ?

MAC 주소가 저장되어 있는가?
```

---

### 3단계

저장된 정보가 없다면

ARP Request를 전송한다.

```text
192.168.0.20 누구야?

MAC 주소 알려줘!
```

이 요청은 Broadcast 방식으로 전송된다.

---

### 4단계

같은 네트워크의 모든 장비가 요청을 받는다.

```text
192.168.0.20 누구야?
```

---

### 5단계

IP가 일치하는 PC B만 응답한다.

```text
내가 192.168.0.20 이야.

내 MAC 주소는

BB-BB-BB-BB-BB-BB
```

이 응답은 Unicast 방식으로 전송된다.

---

### 6단계

PC A는 전달받은 MAC Address를

ARP Cache Table에 저장한다.

```text
192.168.0.20

↓

BB-BB-BB-BB-BB-BB
```

---

### 7단계

이제 실제 통신을 시작한다.

```text
IP : 192.168.0.20
MAC : BB-BB-BB-BB-BB-BB
```

정보를 이용하여 Frame을 생성하고 전송한다.

---

## ARP Cache Table

ARP를 통해 알아낸 정보를 저장하는 공간이다.

왜 저장할까?

매번 Broadcast를 수행하면 네트워크 트래픽이 증가하기 때문이다.

따라서 한 번 알아낸 MAC Address는 일정 시간 동안 저장해두고 재사용한다.

### ARP Cache Table에는 무엇이 저장될까?

ARP Cache Table은

```text
IP Address ↔ MAC Address
```

의 대응 관계를 저장한다.

예)

```text
192.168.0.20 → BB-BB-BB-BB-BB-BB
```

즉,

```text
이 IP의 MAC 주소는 무엇인가?
```

를 기억하는 테이블이다.

---

## ARP와 Broadcast

ARP Request

```text
192.168.0.20 누구야?
```

↓

Broadcast

---

ARP Reply

```text
내가 192.168.0.20이야.
```

↓

Unicast

---

## ARP와 Switch의 관계

Switch는 ARP를 수행하지 않는다.

ARP Request가 Broadcast로 전송되면

Switch는 요청을 받은 포트를 제외한 모든 포트로 전달한다.

```text
ARP Request
↓
Switch
↓
모든 Port로 전달
```

이 과정에서 Switch는 MAC Address를 학습(Learning)하여 MAC Address Table을 생성한다.

---

### ARP Cache Table과 MAC Address Table의 차이

둘 다 MAC Address를 저장하지만 목적이 다르다.

#### ARP Cache Table (PC, Server, Router)

```text
IP Address ↔ MAC Address
```

예)

```text
192.168.0.20 → BB-BB-BB-BB-BB-BB
```

즉,

```text
상대방의 MAC 주소를 기억하기 위한 테이블
```

이다.

---

#### MAC Address Table (Switch)

```text
MAC Address ↔ Port 번호
```

예)

```text
BB-BB-BB-BB-BB-BB → Port2
```

즉,

```text
해당 MAC 주소가 어느 Port에 연결되어 있는지
기억하기 위한 테이블
```

이다.

---

정리하면

```text
ARP Cache Table

IP Address ↔ MAC Address 저장

(PC, Server, Router)
```

```text
MAC Address Table

MAC Address ↔ Port 저장

(Switch)
```

---

## 집에 Switch가 없는데 ARP는 어떻게 동작할까?

대부분의 가정용 공유기에는

- Router 기능
- Switch 기능
- 무선 AP 기능

이 함께 들어있다.

예)

```text
PC
 │
공유기
 │
인터넷
```

PC가

```text
192.168.0.1 누구야?
```

라고 ARP Request를 보내면

공유기가

```text
내 MAC 주소는
AA-BB-CC-DD-EE-FF
```

라고 응답한다.

따라서 별도의 Switch가 없어도 ARP는 정상 동작한다.

---

## Ping과 ARP의 관계

많은 사람들이

```text
ping을 보내면 바로 통신한다고 생각한다.
```

하지만 실제로는 아니다.

상황

```text
PC A

192.168.0.10
```

↓

```text
PC B

192.168.0.20
```

Ping을 보내기 전

ARP Cache Table에 정보가 없다면

먼저 ARP가 동작한다.

```text
ARP
↓
MAC 주소 획득
↓
ARP Cache Table 저장
↓
ICMP(Ping) 동작
```

즉

```text
ARP가 먼저

ICMP는 나중
```

이다.

---

## ARP Cache Table 확인 방법

Windows 명령 프롬프트(cmd)에서 아래 명령어를 입력한다.

```cmd
arp -a
```

예)

```text
인터넷 주소      물리 주소

192.168.0.1    00-11-22-33-44-55
192.168.0.20   AA-BB-CC-DD-EE-FF
```

위 결과는

```text
IP Address ↔ MAC Address
```

의 대응 관계를 보여준다.

즉,

컴퓨터가 ARP를 통해 알아낸 MAC Address 목록을 확인할 수 있다.

---

## 암기 포인트

```text
ARP = Address Resolution Protocol

역할
IP Address → MAC Address 변환

ARP Request = Broadcast

ARP Reply = Unicast

ARP Cache Table
= IP Address ↔ MAC Address

MAC Address Table
= MAC Address ↔ Port

ARP 수행 주체
= PC, Server, Router 등 통신 장비

Switch
= 전달 및 MAC 학습

확인 명령어

arp -a
```

---

## 정리

- ARP는 IP Address에 대응되는 MAC Address를 알아내는 프로토콜이다.
- 같은 네트워크(LAN)에서 통신할 때 사용된다.
- ARP Request는 Broadcast 방식으로 전송된다.
- ARP Reply는 Unicast 방식으로 전송된다.
- ARP Cache Table은 IP Address와 MAC Address의 대응 관계를 저장한다.
- MAC Address Table은 MAC Address와 Port 번호의 대응 관계를 저장한다.
- Ping 통신 시 ARP가 먼저 동작한 후 ICMP가 동작한다.
- L2 Switch는 ARP를 생성하지 않고 전달 및 MAC 학습만 수행한다.

## 한 줄 요약

ARP는 "IP 주소는 아는데 MAC 주소를 모를 때" 상대방의 MAC Address를 알아내기 위해 사용하는 프로토콜이다.
