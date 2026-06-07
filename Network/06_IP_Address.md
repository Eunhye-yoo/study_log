# IP Address

## IP Address란?

IP(Internet Protocol) Address는 네트워크 상에서 장비를 식별하기 위한 논리적 주소(Logical Address)이다.

쉽게 말하면 인터넷에서 사용하는 "집 주소"와 같다.

예)

```text
192.168.0.10
```

데이터를 전송할 때 목적지 장비를 찾기 위해 사용된다.

### 특징

- 논리적 주소(Logical Address)
- 변경 가능
- Layer 3(Network Layer)에서 사용
- Router가 참조하는 주소

---

## IPv4

현재 가장 널리 사용되는 IP 주소 체계이다.

### 특징

- 총 32bit
- 4Byte
- 10진수 표기
- 4개의 Octet으로 구성

예)

```text
192.168.0.10
```

컴퓨터 내부에서는 다음과 같이 이진수로 저장된다.

```text
11000000.10101000.00000000.00001010
```

### IPv4 주소 개수

IPv4는 32bit를 사용한다.

```text
2³²
=
4,294,967,296개
```

약 43억 개의 주소를 만들 수 있다.

인터넷 사용량 증가로 인해 IPv4 주소 부족 문제가 발생하였다.

---

## Octet

IPv4는 총 32bit로 구성된다.

이를 8bit씩 4개로 나눈 단위를 Octet이라고 한다.

```text
192 . 168 . 0 . 10
 ↑     ↑    ↑    ↑
Octet Octet Octet Octet
```

### 왜 0 ~ 255일까?

8bit가 표현할 수 있는 경우의 수는

```text
2⁸ = 256
```

이다.

따라서

```text
00000000 = 0
11111111 = 255
```

가 되어 각 Octet의 범위는

```text
0 ~ 255
```

이다.

---

## 공인 IP (Public IP)

인터넷에서 사용되는 고유한 IP 주소이다.

### 특징

- 전 세계에서 중복 불가
- 인터넷 통신 가능
- ISP가 관리

예)

```text
8.8.8.8
```

Google DNS 서버

공인 IP는 인터넷 상에서 장비를 식별하기 위한 주소이다.

---

## ISP

ISP(Internet Service Provider)는 인터넷 서비스를 제공하는 회사이다.

쉽게 말하면 인터넷 회선을 사용자에게 제공하는 업체이다.

대표적인 ISP

- KT
- SK Broadband
- LG U+

예)

```text
내 PC
↓
공유기
↓
KT(ISP)
↓
인터넷
```

ISP는 사용자에게 공인 IP를 할당하고 인터넷에 연결해준다.

---

## 사설 IP (Private IP)

내부 네트워크(LAN)에서 사용하는 IP 주소이다.

예)

```text
192.168.0.10
```

### 특징

- 같은 네트워크 내에서만 유일
- 인터넷에서 직접 사용 불가
- 가정, 회사, 학교 등에서 사용

### 사설 IP 범위

Class A

```text
10.0.0.0 ~ 10.255.255.255
```

Class B

```text
172.16.0.0 ~ 172.31.255.255
```

Class C

```text
192.168.0.0 ~ 192.168.255.255
```

---

## NAT

NAT(Network Address Translation)는 사설 IP를 공인 IP로 변환하는 기술이다.

주로 공유기에서 수행한다.

예)

```text
PC
192.168.0.10
↓
공유기(NAT)
↓
121.123.123.123
↓
인터넷
```

외부 인터넷에서는 사설 IP가 보이지 않고 공유기의 공인 IP만 보인다.

### NAT를 사용하는 이유

- IPv4 주소 부족 문제 해결
- 공인 IP 절약
- 내부 네트워크 보호

---

## IP Class

초기 IPv4에서는 네트워크 크기에 따라 Class를 구분하였다.

### Class A

```text
1 ~ 126
```

기본 Subnet Mask

```text
255.0.0.0
```

---

### Class B

```text
128 ~ 191
```

기본 Subnet Mask

```text
255.255.0.0
```

---

### Class C

```text
192 ~ 223
```

기본 Subnet Mask

```text
255.255.255.0
```

---

### 현재는?

현재는 Class 방식 대신 CIDR(Classless Inter-Domain Routing)을 사용한다.

Classless란

"Class 구분 없이 필요한 만큼 네트워크를 나누는 방식"

을 의미한다.

예)

```text
192.168.0.0/24
192.168.0.0/26
192.168.0.0/28
```

(*Subnetting.md 에서 자세히 다룬다.)

---

## IPv6

IPv4 주소 부족 문제를 해결하기 위해 만들어졌다.

### 특징

- 총 128bit
- 16Byte
- 16진수 사용

예)

```text
2001:0db8:85a3:0000:0000:8a2e:0370:7334
```

### IPv4 vs IPv6

| 구분 | IPv4 | IPv6 |
|--------|--------|--------|
| 길이 | 32bit | 128bit |
| 표기 | 10진수 | 16진수 |
| 주소 수 | 약 43억 개 | 사실상 무한대 |

---

## Bogon IP

Bogon IP는 일반 인터넷 통신에 사용되지 않도록 예약된 특수 목적의 IP 주소이다.

대표 예시

```text
127.0.0.1
```

Loopback Address

자기 자신을 의미한다.

예)

```text
ping 127.0.0.1
```

현재 PC의 네트워크 기능이 정상 동작하는지 확인할 수 있다.

※ 현재 단계에서는 "특수 목적으로 예약된 IP" 정도로 이해하면 충분하다.

---

## Subnet Mask

IP 주소에서

- Network 부분
- Host 부분

을 구분하기 위한 값이다.

예)

```text
IP Address

192.168.0.10

Subnet Mask

255.255.255.0
```

### 왜 필요한가?

컴퓨터는

```text
192.168.0.20
```

이

- 같은 네트워크인지
- 다른 네트워크인지

판단해야 한다.

Subnet Mask가 그 기준을 제공한다.

### 기본 Subnet Mask

Class A

```text
255.0.0.0
```

Class B

```text
255.255.0.0
```

Class C

```text
255.255.255.0
```

---

## IP Header

Network Layer는 데이터를 Packet으로 만들어 전송한다.

Packet은

```text
IP Header
+
Data
```

로 구성된다.

### Header에 포함되는 대표 정보

- Source IP Address
- Destination IP Address
- TTL
- Protocol

Router는 Header를 확인하여 목적지까지 데이터를 전달한다.

---

## 암기 포인트

```text
IPv4 = 32bit

IPv6 = 128bit

1 Byte = 8bit

1 Octet = 8bit

Layer 3 Address = IP Address

Layer 3 PDU = Packet

Layer 3 Device = Router
```

---

## 정리

- IP Address는 네트워크 상에서 장비를 식별하기 위한 논리적 주소이다.
- IPv4는 32bit, IPv6는 128bit를 사용한다.
- 공인 IP는 인터넷에서 사용된다.
- 사설 IP는 내부 네트워크에서 사용된다.
- NAT는 사설 IP를 공인 IP로 변환한다.
- 현재는 CIDR(Classless) 방식을 사용한다.
- Subnet Mask는 Network와 Host를 구분한다.
- Router는 IP Address를 보고 목적지까지 데이터를 전달한다.

## 한 줄 요약

IP Address는 인터넷에서 장비의 위치를 나타내는 주소이며, Router는 이 주소를 이용해 목적지까지 데이터를 전달한다.
