# Transport Layer (Layer 4)

## 개요

Transport Layer는 OSI 7계층의 4계층으로, 서로 다른 컴퓨터 간 통신에서 프로그램 단위의 통신을 담당하는 계층이다.

Network Layer(Layer 3)가 “어느 컴퓨터로 보낼지”를 결정한다면, Transport Layer는 그 안에서 “어느 프로그램으로 보낼지”를 결정한다.

---

## 왜 필요한가?

IP만으로는 부족하다.

왜냐하면 하나의 컴퓨터 안에는 여러 프로그램이 동시에 네트워크를 사용하기 때문이다.

예:
- 웹 브라우저
- SSH
- DB 서버

IP는 “컴퓨터 위치”만 알려주고  
프로그램은 구분하지 못한다.

**그래서 프로그램을 구분하는 기능이 필요하고 그것이 Transport Layer의 역할이다.**

---

## Port (핵심 개념)

Port는 한 컴퓨터 안에서 실행 중인 프로그램을 구분하는 번호이다.

즉,
- IP = 컴퓨터 주소
- Port = 프로그램 주소

---

### Port가 필요한 이유
한 컴퓨터에서는 여러 서비스가 동시에 실행된다.

Port가 없다면:

192.168.0.10
→ 여기까지는 컴퓨터까지만 도착
→ 어떤 프로그램인지 모름


그래서 Port를 붙인다:


192.168.0.10:80 → 웹 서버

192.168.0.10:22 → SSH 서버

192.168.0.10:3306 → DB 서버


---

### Port 범위

| 구분 | 범위 | 의미 |
|------|------|------|
| Well-Known Port | 0 ~ 1023 | 핵심 서비스 (HTTP, HTTPS 등) |
| Registered Port | 1024 ~ 49151 | 일반 애플리케이션 |
| Dynamic Port | 49152 ~ 65535 | 클라이언트 임시 사용 |

---

## Socket (중요)

실제 통신 단위는 Port가 아니라 Socket이다.

Socket = IP + Port

예:

192.168.0.10:80


**실제 네트워크 통신 엔드포인트**

---

## Multiplexing / Demultiplexing

#### Multiplexing (보낼 때)
여러 프로그램의 데이터를 하나의 네트워크로 합치는 과정

예:
- 크롬
- 게임
- 카카오톡

→ 모두 동시에 인터넷 사용 가능

---

#### Demultiplexing (받을 때)
받은 데이터를 Port 기준으로 올바른 프로그램에 분배하는 과정

예:
- 80번 → 웹 브라우저
- 22번 → SSH
- 3306 → DB

**Port는 “분배 기준” 역할**

---

## Client / Server 구조

### Server
- 고정 Port 사용
- 서비스 제공

예:
- HTTP → 80
- HTTPS → 443
  
**이유: 항상 같은 주소로 접근해야 하기 때문**

---

### Client
- 접속 시 임시 Port 사용
- 통신 종료 후 사라짐

예:

Client: 50001 → Server:80
Client: 50002 → Server:80

**이유: 여러 요청을 동시에 처리하기 위해**

---

## End-to-End 통신

프로그램과 프로그램이 직접 통신하는 구조


크롬 → 웹 서버


---

## 전송 방식

Transport Layer는 전송 방식을 선택한다:

- TCP : 신뢰성 중심
- UDP : 속도 중심

---

## PDU


Transport Layer의 PDU는 Segment(TCP) 또는 Datagram(UDP)이다.

---

## TCP vs UDP

### TCP
- 연결 기반
- 신뢰성 보장
- 순서 보장
- 데이터 재전송

→ 정확하지만 느림

---

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
| PDU | Packet | Segment / Datagram |
| 장비 | Router | OS (프로세스 관리) |

---

## 정리

- Transport Layer는 서로 다른 컴퓨터 간 **프로그램 단위 통신을 담당한다**
- Port를 이용해 프로그램을 구분한다
- Socket은 IP + Port 조합이다
- Multiplexing / Demultiplexing으로 데이터 분배를 수행한다
- TCP와 UDP 중 하나의 방식으로 전송한다
- PDU는 Segment 또는 Datagram이다

---

## 한 줄 요약

Layer 3은 "어느 컴퓨터로 보낼까"를 담당한다면,  
Layer 4는 "그 컴퓨터 안의 어느 프로그램으로 보낼까"를 담당한다.
