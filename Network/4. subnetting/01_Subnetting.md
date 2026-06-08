# Subnetting

## Subnetting이란?

Subnetting은

하나의 큰 네트워크를 여러 개의 작은 네트워크로 나누는 기술이다.

Subnet은

```text
Sub + Network
```

의 합성어이다.

즉,

```text
큰 Network

↓

작은 Network 여러 개
```

로 분할하는 것이다.

---

## 왜 Subnetting을 사용할까?

초기에는 IP Address를 Class(A,B,C) 단위로 사용했다.

예)

```text
Class C

192.168.1.0/24
```

사용 가능한 Host 수

```text
254개
```

하지만 실제로는

```text
부서 A : 30명

부서 B : 20명

부서 C : 15명
```

처럼 사용한다.

그런데 네트워크를 나누지 않으면

```text
254개 전체를 하나의 네트워크
```

로 사용하게 된다.

결과적으로

- IP 낭비
- Broadcast 증가
- 관리 어려움

문제가 발생한다.

그래서 Subnetting을 사용한다.

---

## CIDR 표기법

CIDR(Classless Inter-Domain Routing)

Subnet Mask를 간단하게 표현하는 방법이다.

예)

```text
192.168.10.0/24
```

여기서

```text
/24
```

는

```text
Subnet Mask

255.255.255.0
```

을 의미한다.

---

### 자주 사용하는 CIDR

```text
/8  = 255.0.0.0

/16 = 255.255.0.0

/24 = 255.255.255.0

/25 = 255.255.255.128

/26 = 255.255.255.192

/27 = 255.255.255.224

/28 = 255.255.255.240

/29 = 255.255.255.248

/30 = 255.255.255.252
```

---

## IP 주소의 구성

예)

```text
192.168.10.35/24
```

IP는

```text
Network 부분

+

Host 부분
```

으로 구성된다.

---

### Network Address

해당 네트워크 자체를 의미

예)

```text
192.168.10.0
```

---

### Host Address

실제 장비에 할당되는 주소

예)

```text
192.168.10.1

~

192.168.10.254
```

---

### Broadcast Address

같은 네트워크의 모든 장비에게 보내는 주소

예)

```text
192.168.10.255
```

---

## Subnetting에서 반드시 찾는 3가지

문제가 나오면 항상 찾는다.

```text
1. Network Address

2. Host 범위

3. Broadcast Address
```

시험에서도 거의 무조건 나온다.

---

## Host 계산 공식

사용 가능한 Host 수

공식

```text
2^n - 2
```

n = Host Bit 수

---

왜 -2 를 할까?

```text
1개 = Network Address

1개 = Broadcast Address
```

때문이다.

---

예)

```text
/24
```

Host Bit

```text
32 - 24

= 8
```

따라서

```text
2^8 - 2

= 254
```

---

## Subnet 개수 계산

공식

```text
2^n
```

n = 빌려온 Bit 수

---

예)

```text
/24

↓

/26
```

2 Bit를 빌려왔다.

따라서

```text
2²

= 4개 Subnet
```

생성

---

## 문제 푸는 순서

### Host 수가 주어졌을 때

1단계

필요 Host 수 확인

예)

```text
50개
```

---

2단계

Host 공식 사용

```text
2^5 - 2 = 30

부족

2^6 - 2 = 62

가능
```

---

3단계

Host Bit = 6

따라서

```text
32 - 6

= /26
```

---

4단계

Subnet Mask 확인

```text
255.255.255.192
```

---

## 암기 필수

```text
/25 → 128

/26 → 64

/27 → 32

/28 → 16

/29 → 8

/30 → 4
```

이 숫자를

Block Size

또는

증가값

이라고 부른다.

---

## 예제 1

문제

```text
192.168.53.0/24

Host 50개씩 필요
```

---

### 1단계

Host 계산

```text
2^5 - 2 = 30

부족

2^6 - 2 = 62

가능
```

---

### 2단계

Host Bit = 6

```text
/26
```

사용

---

### 3단계

증가값 계산

```text
256 - 192

= 64
```

---

### 결과

```text
192.168.53.0/26

Host

1 ~ 62

Broadcast

63
```

---

```text
192.168.53.64/26

Host

65 ~ 126

Broadcast

127
```

---

```text
192.168.53.128/26

Host

129 ~ 190

Broadcast

191
```

---

```text
192.168.53.192/26

Host

193 ~ 254

Broadcast

255
```

---

총 4개의 Subnet 생성

---

## 예제 2

문제

```text
192.168.53.0/24

6개의 Subnet 필요
```

---

### 1단계

Subnet 공식

```text
2^2 = 4

부족

2^3 = 8

가능
```

---

### 2단계

3 Bit 빌리기

```text
/24

↓

/27
```

---

### 3단계

증가값

```text
256 - 224

= 32
```

---

### 결과

```text
192.168.53.0/27
Broadcast 31

192.168.53.32/27
Broadcast 63

192.168.53.64/27
Broadcast 95

192.168.53.96/27
Broadcast 127

192.168.53.128/27
Broadcast 159

192.168.53.160/27
Broadcast 191

192.168.53.192/27
Broadcast 223

192.168.53.224/27
Broadcast 255
```

총 8개 Subnet 생성

---

## 실전 꿀팁

시험에서 가장 많이 사용하는 공식

```text
Host

2^n - 2
```

---

```text
Subnet

2^n
```

---

CIDR만 보고 Host 수 암기

```text
/24 = 254 Host

/25 = 126 Host

/26 = 62 Host

/27 = 30 Host

/28 = 14 Host

/29 = 6 Host

/30 = 2 Host
```

이 표는 거의 외워두는 것이 좋다.

---

## 정리

- Subnetting은 하나의 네트워크를 여러 개로 나누는 기술이다.
- IP 주소 낭비를 줄이고 Broadcast를 감소시킨다.
- CIDR은 Subnet Mask를 간단하게 표현하는 방법이다.
- Host 계산 공식은 2^n - 2 이다.
- Subnet 계산 공식은 2^n 이다.
- 문제에서는 Network Address, Host 범위, Broadcast Address를 찾는 것이 핵심이다.

## 한 줄 요약

Subnetting은 하나의 큰 네트워크를 여러 개의 작은 네트워크로 나누어 IP를 효율적으로 사용하는 기술이다.
