# ICMP (Internet Control Message Protocol)

## ICMP란?

ICMP(Internet Control Message Protocol)는

네트워크 상태를 확인하거나 오류 정보를 전달하기 위한 프로토콜이다.

IP는 데이터를 전달하는 역할만 수행한다.

하지만

- 목적지에 도착했는지
- 상대방이 살아있는지
- 중간에 문제가 발생했는지

확인할 수 없다.

이러한 정보를 전달하기 위해 ICMP가 사용된다.

즉,

```text
IP = 데이터 전달

ICMP = 상태 확인 및 오류 보고
```

이다.

---

## Ping과 ICMP의 관계

많은 사람들이

```text
ICMP = Ping
```

이라고 생각하지만 정확히는 다르다.

```text
ICMP = 프로토콜

Ping = ICMP를 사용하는 명령어
```

이다.

예)

```cmd
ping 8.8.8.8
```

명령을 실행하면

ICMP 메시지가 전송된다.

---

## ICMP 메시지 구조

ICMP는 다양한 종류의 메시지를 사용한다.

이를 구분하기 위해 Header에

- Type
- Code
- Checksum

정보를 포함한다.

---

### Type

메시지의 큰 종류

예)

```text
Echo Request
Echo Reply
Destination Unreachable
Time Exceeded
```

---

### Code

Type의 세부 원인

예)

```text
Type
└─ Destination Unreachable
```

만으로는

왜 도달하지 못했는지 알 수 없다.

그래서 Code가 사용된다.

예)

```text
Code 0
= 네트워크 없음

Code 1
= 호스트 없음

Code 3
= 포트 없음
```

즉

```text
Type = 큰 분류

Code = 상세 설명
```

이다.

---

### Checksum

데이터가 전송 중 손상되었는지 확인하기 위한 값이다.

---

## 대표적인 ICMP 메시지

### Echo Request

```text
나 들려?
```

Ping 요청

---

### Echo Reply

```text
응 들려.
```

Ping 응답

---

### Destination Unreachable

```text
목적지에 도달할 수 없어.
```

오류 메시지

---

### Time Exceeded

```text
TTL이 만료되었어.
```

오류 메시지

---

## Ping 동작 원리

```text
내 PC
    │
    │ Echo Request
    ▼
상대방

상대방
    │
    │ Echo Reply
    ▼
내 PC
```

---

## Ping 실습

```cmd
ping 8.8.8.8
```

예)

```text
Reply from 8.8.8.8:
bytes=32
time=15ms
TTL=118
```

---

## 결과 해석

### bytes

전송한 데이터 크기

```text
bytes=32
```

32Byte 데이터 전송

---

### time

응답 속도

```text
time=15ms
```

숫자가 작을수록 좋다.

---

### TTL

Time To Live

패킷이 네트워크를 통과할 수 있는 최대 횟수

TTL이 0이 되면 패킷은 폐기된다.

---

## 자주 보는 오류 메시지

### Request Timed Out

```text
응답이 오지 않음
```

---

### Destination Host Unreachable

```text
목적지를 찾을 수 없음
```

---

### General Failure

```text
로컬 네트워크 설정 문제
```

---

## ARP와 ICMP

같은 네트워크에서 Ping을 보낼 때

ARP Cache Table에 정보가 없다면

ARP가 먼저 동작한다.

```text
ARP
↓
MAC 주소 확인
↓
ICMP Echo Request
↓
ICMP Echo Reply
```

따라서

```text
ARP가 먼저
ICMP가 나중
```

이다.

---

## 정리

- ICMP는 네트워크 상태 확인 및 오류 보고를 위한 프로토콜이다.
- Ping은 ICMP를 사용하는 명령어이다.
- Echo Request와 Echo Reply는 Ping에 사용된다.
- Type은 메시지 종류를 의미한다.
- Code는 Type의 세부 원인을 의미한다.
- Ping 실행 시 ARP가 먼저 동작할 수 있다.

## 한 줄 요약

ICMP는 네트워크의 상태와 오류를 전달하는 프로토콜이며, Ping은 ICMP를 이용해 연결 상태를 확인하는 명령어이다.
