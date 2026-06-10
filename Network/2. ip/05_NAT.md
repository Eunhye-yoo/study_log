# NAT (Network Address Translation)

## NAT란?

NAT(Network Address Translation)는

```text
IP 주소 변환 기술
```

이다.

주로

```text
사설 IP

↓

공인 IP
```

로 변환하는 작업을 말한다.

인터넷에서는 공인 IP만 사용할 수 있기 때문에 내부 PC가 인터넷에 접속하려면 Router가 대신 주소를 바꿔줘야 한다.

---

## 왜 NAT가 필요할까?

IPv4 주소는 약 43억 개밖에 존재하지 않는다.

하지만

```text
PC

노트북

스마트폰

태블릿

IoT
```

등 인터넷 장비 수는 훨씬 많다.

만약 모든 장비가 공인 IP를 하나씩 사용한다면 IP가 부족해진다.

그래서 실제 네트워크는

```text
내부

↓

사설 IP 사용

↓

인터넷 접속 시

↓

공인 IP 변환
```

방식을 사용한다.

---

## 공인 IP와 사설 IP

### 공인 IP (Public IP)

인터넷에서 직접 사용 가능한 주소

전 세계에서 유일해야 한다.

예)

```text
8.8.8.8

1.1.1.1
```

---

### 사설 IP (Private IP)

내부 네트워크 전용 주소

인터넷에서는 직접 사용할 수 없다.

범위

```text
10.0.0.0 ~ 10.255.255.255

172.16.0.0 ~ 172.31.255.255

192.168.0.0 ~ 192.168.255.255
```
---
## SNAT와 DNAT

NAT는 어떤 IP를 변경하느냐에 따라 SNAT와 DNAT로 나뉜다.

### SNAT (Source NAT)

출발지 IP를 변경하는 NAT

주로 내부 사용자가 인터넷에 접속할 때 사용한다.

예)

192.168.53.10

↓

100.1.1.1

Google 입장에서는

192.168.53.10이 아니라

100.1.1.1이 접속한 것으로 보인다.

대부분의 NAT 실습은 SNAT이다.

---

### DNAT (Destination NAT)

목적지 IP를 변경하는 NAT

주로 외부 사용자가 내부 서버에 접속할 때 사용한다.

예)

외부 사용자

↓

100.1.1.100

↓

DNAT

↓

192.168.53.10

즉 공인 IP로 접속하면 실제 내부 서버로 연결해주는 기술이다.

웹 서버, 게임 서버, CCTV 등에 사용된다.
---

## NAT는 실제로 무엇을 바꿀까?

NAT는

```text
출발지 IP(Source IP)
```

또는

```text
목적지 IP(Destination IP)
```

를 변경한다.

실무에서 가장 많이 보는 것은

```text
SNAT

(Source NAT)
```

이다.

---

예)

```text
PC

192.168.53.10

↓

Google 접속 요청

↓

Router(NAT)

↓

100.1.1.1

↓

Google
```

Router는

```text
192.168.53.10
```

을

```text
100.1.1.1
```

로 바꿔서 전송한다.

---

## NAT 동작 원리

예)

```text
PC

192.168.53.10

↓

Google 접속
```

패킷 생성

```text
Source IP

192.168.53.10

Destination IP

8.8.8.8
```

---

Router 도착

```text
192.168.53.10

↓

100.1.1.1
```

변환

---

NAT Table 생성

```text
192.168.53.10

↔

100.1.1.1
```

기록

---

Google 응답

```text
8.8.8.8

↓

100.1.1.1
```

도착

---

Router

```text
NAT Table 조회

↓

192.168.53.10 확인

↓

PC 전달
```

---

즉 NAT의 핵심은

```text
주소 변환

+

변환 기록 저장
```

이다.

---

## Inside / Outside

NAT 설정 전 반드시 구분해야 하는 개념

### Inside

내부 네트워크

보통 사설 IP

```text
PC

사내망

집 Wi-Fi
```

---

### Outside

외부 네트워크

보통 인터넷

```text
Google

Naver

YouTube
```

---

설정

```bash
interface f0/0
 ip nat inside

interface f0/1
 ip nat outside
```

의 의미

```text
f0/0

↓

내부

f0/1

↓

외부
```

---

## NAT 발전 과정

### 1단계

Static NAT

```text
1 : 1
```

---

### 2단계

Dynamic NAT

```text
n : m
```

---

### 3단계

PAT

```text
n : 1
```

현재 대부분 사용

---

## Static NAT

사설 IP와 공인 IP를 고정 연결

예)

```text
192.168.53.10

↓

100.1.1.100
```

---

특징

```text
항상 같은 공인 IP 사용
```

---

장점

```text
서버 운영 가능

주소 고정
```

---

단점

```text
공인 IP 많이 필요
```

---

설정

```bash
ip nat inside source static 192.168.53.10 100.1.1.100
```

---

Static NAT는

```text
누가 변환될지

명령어에 이미 적혀 있음
```

그래서 ACL이 필요 없다.

---

## Dynamic NAT

Static NAT의 공인 IP 낭비를 줄이기 위해 등장

---

예)

공인 IP Pool

```text
100.1.1.100

100.1.1.101

100.1.1.102
```

보유

---

동작

```text
PC1 접속

↓

100.1.1.100 사용

PC2 접속

↓

100.1.1.101 사용

PC3 접속

↓

100.1.1.102 사용
```

---

사용이 끝나면

```text
Pool 반환
```

한다.

---

장점

```text
공인 IP 절약
```

---

단점

```text
Pool 부족 시

추가 접속 불가
```

---

## ACL은 왜 사용할까?

Dynamic NAT에서 등장하는 이유

Router는

```text
누구를 NAT 해야 하지?
```

를 모른다.

그래서 ACL을 사용한다.

---

예)

```bash
access-list 1 permit 192.168.53.0 0.0.0.255
```

의 의미

```text
192.168.53.x

대역만 NAT 대상
```

---

NAT에서 ACL은

```text
보안

X

NAT 대상자 목록

O
```

라고 이해하는 것이 좋다.

---

## Dynamic NAT 설정 순서

① Pool 생성

```bash
ip nat pool KEDU 100.1.1.100 100.1.1.105 netmask 255.255.255.0
```

↓

② ACL 생성

```bash
access-list 1 permit 192.168.53.0 0.0.0.255
```

↓

③ NAT 연결

```bash
ip nat inside source list 1 pool KEDU
```

---

## Secondary IP란?

하나의 인터페이스에

```text
IP 여러 개
```

를 설정하는 기능

---

예)

```bash
interface f0/1

ip address 100.1.1.1 255.255.255.0

ip address 100.1.1.100 255.255.255.0 secondary

ip address 100.1.1.101 255.255.255.0 secondary
```

---

실무 용도

```text
IP 이전 작업

서브넷 추가

임시 네트워크 구성
```

---

NAT 실습에서 사용하는 이유

```text
Pool 주소를

Router가 실제 보유하게 하기 위해
```

서이다.

---

중요

```text
Dynamic NAT

=

Secondary IP 필수

X
```

---

필요한 것은

```text
공인 IP Pool
```

이다.

Secondary IP는 실습 환경에서 Pool을 구성하는 방법 중 하나일 뿐이다.

---

## PAT (Port Address Translation)

현재 실무에서 가장 많이 사용하는 NAT

---

기존 NAT

```text
사설IP 1개

↓

공인IP 1개
```

---

PAT

```text
사설IP 여러 개

↓

공인IP 1개
```

---

구분 방법

```text
Port 번호
```

사용

---

예)

```text
192.168.53.10

↓

100.1.1.1:10001

192.168.53.20

↓

100.1.1.1:10002

192.168.53.30

↓

100.1.1.1:10003
```

---

장점

```text
공인 IP 1개만 필요
```

---

실무 사용

```text
집

회사

학교

카페 Wi-Fi
```

거의 전부 PAT

---

설정

```bash
access-list 1 permit 192.168.53.0 0.0.0.255

ip nat inside source list 1 interface f0/1 overload
```

---

여기서

```text
overload
```

는

```text
PAT 사용
```

의 의미이다.

---

## NAT 확인 명령어

### NAT 테이블

```bash
show ip nat translations
```

---

### NAT 통계

```bash
show ip nat statistics
```

---

## Static NAT / Dynamic NAT / PAT 비교

| 구분 | Static NAT | Dynamic NAT | PAT |
|--------|--------|--------|--------|
| 변환 | 1:1 | n:m | n:1 |
| 공인IP 사용 | 많음 | 중간 | 적음 |
| ACL 필요 | X | O | O |
| 서버 운영 | 가능 | 어려움 | 어려움 |
| 실무 사용 | 일부 | 거의 없음 | 매우 많음 |

---

## 암기 포인트

```text
NAT

주소 변환 기술
```

```text
Source NAT

출발지 IP 변경
```

```text
Inside

내부 네트워크
```

```text
Outside

외부 네트워크
```

```text
Static NAT

1:1
```

```text
Dynamic NAT

n:m
```

```text
PAT

n:1
```

```text
ACL

NAT 대상 지정
```

```text
overload

PAT 활성화
```

```text
show ip nat translations
```

---

## 정리

- NAT는 사설 IP를 공인 IP로 변환하는 기술이다.
- 인터넷에서는 공인 IP만 사용할 수 있기 때문에 Router가 주소를 변환해준다.
- NAT의 핵심은 주소 변환과 NAT Table 관리이다.
- Inside는 내부 네트워크, Outside는 외부 네트워크를 의미한다.
- SNAT는 출발지 IP를 변경하고, DNAT는 목적지 IP를 변경한다.
- Static NAT는 사설 IP와 공인 IP를 1:1로 고정 연결한다.
- Dynamic NAT는 공인 IP Pool을 사용하여 필요할 때 공인 IP를 할당한다.
- Dynamic NAT에서는 ACL을 사용해 NAT 대상을 지정한다.
- ACL은 NAT에서 보안 기능이 아니라 NAT 대상자를 지정하는 역할을 한다.
- PAT는 Port 번호를 이용하여 여러 사설 IP가 하나의 공인 IP를 공유하는 방식이다.
- 현재 가정, 회사, 학교 대부분의 네트워크는 PAT를 사용한다.
- Secondary IP는 하나의 인터페이스에 여러 IP를 설정하는 기능이다.
- Secondary IP는 Dynamic NAT 필수 기능이 아니라 Pool 구성이나 네트워크 이전 작업 등에 사용된다.
- Static NAT → Dynamic NAT → PAT 순으로 공인 IP 절약 효율이 증가한다.

## 한 줄 요약

NAT는 사설 IP를 공인 IP로 변환하여 인터넷 통신을 가능하게 하는 기술이며, 현재 대부분의 네트워크는 Port 번호를 이용해 하나의 공인 IP를 여러 사용자가 공유하는 PAT 방식을 사용한다.
