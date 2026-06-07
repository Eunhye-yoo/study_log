# Transport Layer (Layer 4)

## 개요

Transport Layer는 OSI 7계층의 4계층으로, 서로 다른 컴퓨터 간 통신에서 프로그램 단위의 통신을 담당하는 계층이다.

Network Layer(Layer 3)가 “어느 컴퓨터로 보낼지”를 결정한다면, Transport Layer는 그 안에서 “어느 프로그램으로 보낼지”를 결정한다.

쉽게 말해,
- Layer 3 : 어디 컴퓨터로 갈까?
- Layer 4 : 그 컴퓨터 안에서 어느 프로그램으로 갈까?

---

## 왜 필요한가?

하나의 컴퓨터나 서버에는 여러 프로그램이 동시에 동작한다.

예:
- 웹 서버
- SSH 서버
- 파일 서버

이때 데이터가 서버에 도착하면 IP만으로는 부족하다. IP는 “컴퓨터 위치”만 알려주기 때문이다.

그래서 어떤 프로그램으로 데이터를 전달할지 구분해야 하고 그 역할을 Transport Layer가 담당한다.

---

## 주요 역할

### Port를 이용한 프로그램 구분

Transport Layer는 Port를 이용해서 컴퓨터 안의 프로그램을 구분한다.

예:

192.168.0.10:80 → 웹 서버
192.168.0.10:22 → SSH 서버


IP는 컴퓨터 주소이고 Port는 컴퓨터 안의 프로그램 주소이다.

---

### End-to-End 통신

송신자 프로그램과 수신자 프로그램 간 직접 통신을 가능하게 한다.


내 PC의 크롬 → 서버의 웹 서버


---

### 전송 방식 선택

Transport Layer는 데이터 전송 방식을 결정한다.

- TCP : 신뢰성 중심
- UDP : 속도 중심

---

## PDU (Protocol Data Unit)

Transport Layer의 PDU는 Segment(TCP) 또는 Datagram(UDP)이다.

---

## Port

Port는 하나의 컴퓨터에서 실행 중인 프로그램을 구분하는 번호이다.

형태:

IP 주소:Port 번호
예) 192.168.0.10:80


---

### Port 범위

| 구분 | 범위 |
|------|------|
| Well-Known Port | 0 ~ 1023 |
| Registered Port | 1024 ~ 49151 |
| Dynamic Port | 49152 ~ 65535 |

---

## Client / Server 구조

### Server
- 항상 고정된 Port 사용
- 특정 서비스 제공
- 예: HTTP(80), HTTPS(443)

### Client
- 접속 시 임시 Port 사용
- 통신 종료 후 사라짐

---

## TCP vs UDP 개념

### TCP
- 연결 기반
- 신뢰성 보장
- 순서 보장
- 데이터 재전송

→ 정확하지만 느림

### UDP
- 비연결
- 재전송 없음
- 순서 보장 없음

→ 빠르지만 손실 가능

---

## Layer 3 vs Layer 4 비교

| 구분 | Layer 3 | Layer 4 |
|------|--------|--------|
| 역할 | 컴퓨터 간 통신 | 프로그램 간 통신 |
| 주소 | IP | Port |
| PDU | Packet | Segment(TCP) / Datagram(UDP) |
| 장비 | Router | OS (프로세스 관리) |

---

## 한 줄 요약

Layer 3은 “어느 컴퓨터로 갈까”를 결정하고, Layer 4는 “그 컴퓨터 안의 어느 프로그램으로 갈까”를 결정한다.
