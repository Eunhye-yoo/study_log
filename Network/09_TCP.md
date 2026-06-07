# TCP (Transmission Control Protocol)

## TCP란?

TCP(Transmission Control Protocol)는 신뢰성 있는 데이터 전송을 보장하는 통신 프로토콜이다.

즉, 데이터를 "정확하게, 순서대로, 손실 없이" 전달하는 방식이다.

---

## 왜 TCP가 필요할까?

네트워크에서는 다음 문제가 발생할 수 있다.

- 데이터 손실
- 데이터 순서 변경
- 중복 전송

TCP는 이런 문제를 해결하기 위해 존재한다.

---

## TCP 특징

### 연결형 프로토콜 (Connection-oriented)

TCP는 통신 전에 반드시 연결을 생성한다.

통신 흐름:
- 연결 생성
- 데이터 전송
- 연결 종료

---

### 3-way Handshake (연결 과정)

TCP 연결은 다음 3단계로 이루어진다.

SYN → SYN + ACK → ACK

Client → Server : SYN (연결 요청)  
Server → Client : SYN + ACK (요청 수락)  
Client → Server : ACK (최종 확인)

→ 이 과정을 통해 연결이 확립된다.

---

### 신뢰성 보장 (Reliable Transmission)

TCP는 데이터를 전송한 뒤 반드시 확인 응답(ACK)을 받는다.

데이터가 손실되면 재전송을 수행한다.

---

### 순서 보장 (Ordering)

데이터는 여러 조각으로 나뉘어 전송될 수 있다.

TCP는 Sequence Number를 이용해
수신 측에서 정확한 순서로 재조립한다.

---

### 흐름 제어 (Flow Control)

수신자가 처리 가능한 속도에 맞춰 전송 속도를 조절한다.

즉, 받는 쪽이 느리면 보내는 속도를 줄인다.

---

### 혼잡 제어 (Congestion Control)

네트워크가 혼잡하면 전송 속도를 줄여
전체 네트워크 안정성을 유지한다.

---

## TCP 동작 흐름

연결 생성 (3-way handshake)  
↓  
데이터 전송  
↓  
ACK 확인  
↓  
손실 시 재전송  
↓  
연결 종료  

---

## TCP 사용하는 대표 서비스

- 웹 (HTTP / HTTPS)
- 파일 전송 (FTP)
- 이메일
- 로그인 / 인증 시스템

---

## TCP 단점

- 속도가 느림
- 구조가 복잡함
- 오버헤드가 큼

---

## 헷갈리는 개념 정리 (중요)

네트워크 개념은 같은 레벨이 아니라 서로 다른 계층에서 동작한다.

그래서 같이 보면 헷갈린다.

---

## Broadcast / Unicast / Multicast vs TCP / UDP

이 둘은 비교 대상이 아니다.

### Broadcast / Unicast / Multicast

**"누구에게 보내는가?"**

- Unicast → 1:1
- Broadcast → 전체
- Multicast → 그룹

→ L2 (Data Link Layer) 개념

---

### TCP / UDP

**"어떻게 보내는가?"**

- TCP → 신뢰성 있음 (ACK, 순서 보장, 재전송)
- UDP → 빠름 (확인 없음)

→ L4 (Transport Layer) 개념

---

## 왜 헷갈릴까?

둘 다 "통신 방식"이라고 불리기 때문이다.

하지만 역할은 완전히 다르다.

```text
Broadcast / Unicast = 누구에게 보낼지
TCP / UDP = 어떻게 보낼지
```
---

## TCP 핵심 정리

- 연결을 먼저 만든다
- 데이터가 정확하게 도착하는 것을 보장한다
- 순서를 보장한다
- 손실 시 재전송한다

---

## 한 줄 요약

TCP는 "느리지만 정확한 데이터 전달을 보장하는 통신 방식"이다.
