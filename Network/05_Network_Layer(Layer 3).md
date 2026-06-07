# Network Layer (Layer 3)

## 개요

Network Layer는 OSI 7계층의 3계층으로, 서로 다른 네트워크 간 통신을 담당하는 계층이다.

Data Link Layer(Layer 2)가 같은 네트워크(LAN) 내 통신을 담당했다면,

Network Layer는 다른 네트워크에 있는 장비를 찾아 데이터를 전달하는 역할을 수행한다.

쉽게 말해,

- Layer 2 : 같은 동네에서 길 찾기
- Layer 3 : 다른 도시까지 길 찾기

라고 생각하면 된다.

---

## 왜 필요한가?

예를 들어

```text
PC-A : 192.168.1.10

↓

공유기(라우터)

↓

인터넷

↓

Google 서버
```

PC-A와 Google 서버는 서로 다른 네트워크에 존재한다.

이 경우 MAC Address만으로는 목적지를 찾을 수 없다.

왜냐하면 MAC Address는 같은 네트워크 안에서만 의미가 있기 때문이다.

따라서

"목적지가 어느 네트워크에 있는가?"

를 판단할 수 있는 계층이 필요하며,

그 역할을 Network Layer가 담당한다.

---

## 주요 역할

### 1. IP Address 사용

Network Layer는 IP Address를 사용한다.

IP Address는 인터넷 상에서 장비의 위치를 나타내는 논리적 주소이다.

예)

```text
192.168.0.10
```

MAC Address가

"누구인가?"

를 나타낸다면,

IP Address는

"어디에 있는가?"

를 나타낸다.

---

### 2. Routing (라우팅)

목적지까지 데이터를 전달하기 위한 경로를 결정하는 과정이다.

예)

```text
내 PC
 ↓
공유기
 ↓
통신사
 ↓
인터넷
 ↓
목적지 서버
```

목적지까지 도달하기 위해 어떤 길을 사용할지 결정하는 것을 라우팅이라고 한다.

---

### 3. Packet 전달

Network Layer는 데이터를 Packet 단위로 처리한다.

상위 계층에서 받은 데이터에 IP Header를 추가하여 Packet을 생성한다.

---

## PDU (Protocol Data Unit)

Network Layer의 PDU는 Packet이다.

### PDU 변화 과정

```text
Application Layer
↓
Data

Transport Layer
↓
Segment

Network Layer
↓
Packet

Data Link Layer
↓
Frame

Physical Layer
↓
Bit
```

### Packet이란?

Packet은

```text
IP Header
+
Data
```

로 구성된 데이터 단위이다.

쉽게 말하면

목적지 IP 주소가 적힌 택배 상자라고 생각하면 된다.

※ Packet은 "어느 네트워크로 가야 하는가?"를 나타내는 정보이며,

실제 장비 간 전달을 위한 MAC Address 정보는 Data Link Layer의 Frame에 포함된다.

---

## 주요 프로토콜

### IP (Internet Protocol)

Network Layer의 대표 프로토콜이다.

장비를 식별하고 목적지를 찾기 위해 사용한다.

종류

- IPv4
- IPv6
  
(*자세한 내용은 IP_Address.md에서 다룬다.)

---

### ARP (Address Resolution Protocol)

IP Address를 MAC Address로 변환하는 프로토콜이다.

같은 네트워크에서 통신할 때 사용된다.

(*자세한 내용은 ARP.md에서 다룬다.)

---

### ICMP (Internet Control Message Protocol)

네트워크 상태를 확인하기 위한 프로토콜이다.

대표적으로 Ping 명령어가 ICMP를 사용한다.

(*자세한 내용은 ICMP.md에서 다룬다.)

---

## Network Layer 장비

### Router

Network Layer를 대표하는 장비이다.

서로 다른 네트워크를 연결한다.

예)

```text
집 네트워크
↓
공유기(라우터)
↓
인터넷
```

우리가 인터넷을 사용할 수 있는 이유는 라우터가 네트워크 간 통신을 가능하게 해주기 때문이다.

---

### L3 Switch

Layer 3 기능을 지원하는 스위치이다.

일반 스위치(Layer 2 Switch)의 기능과 라우팅 기능을 함께 제공한다.

주로 기업 네트워크에서 사용된다.

---

## Layer 2와 Layer 3의 차이

| 구분 | Layer 2 | Layer 3 |
|--------|--------|--------|
| 주소 | MAC Address | IP Address |
| PDU | Frame | Packet |
| 장비 | Switch | Router |
| 역할 | 같은 네트워크 통신 | 다른 네트워크 통신 |

---

### Switch와 Router의 차이

Switch

```text
같은 네트워크 안에서 전달
```

Router

```text
다른 네트워크로 전달
```

예)

```text
192.168.0.x
↓
Switch
↓
192.168.0.x
```

같은 네트워크

---

```text
192.168.0.x
↓
Router
↓
8.8.8.8
```

다른 네트워크

---

## 정리

- Layer 3은 서로 다른 네트워크 간 통신을 담당한다.
- IP Address를 사용하여 목적지의 위치를 찾는다.
- Routing을 통해 데이터를 전달할 경로를 결정한다.
- PDU는 Packet이다.
- 대표 장비는 Router이다.
- ARP는 IP를 MAC으로 변환한다.
- ICMP는 네트워크 상태를 확인한다.

## 한 줄 요약

Layer 2가 "누구에게 보낼까?"를 담당한다면,

Layer 3은 "어디로 보내야 할까?"를 담당한다.
