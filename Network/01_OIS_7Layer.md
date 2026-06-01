# OSI 7 Layer

OSI(Open Systems Interconnection) 모델은 네트워크 통신 과정을 7개의 계층으로 나누어 표준화한 참조 모델이다.

| 계층 | 이름           | 주요 역할        |
| -- | ------------ | ------------ |
| 7  | Application  | 사용자 서비스 제공   |
| 6  | Presentation | 데이터 형식 변환    |
| 5  | Session      | 연결 관리        |
| 4  | Transport    | 데이터 전송       |
| 3  | Network      | IP 주소 및 라우팅  |
| 2  | Data Link    | MAC 주소 기반 통신 |
| 1  | Physical     | 전기 신호 전송     |

## PDU(Protocol Data Unit)
PDU는 각 계층에서 처리하는 데이터의 단위를 의미한다.

데이터가 하위 계층으로 내려가면서 각 계층의 헤더(Header)가 추가되고, 이에 따라 데이터의 이름(PDU)도 변경된다.

| 계층    | 데이터 단위             |
| ----- | ------------------ |
| L7~L5 | Data               |
| L4    | Segment / Datagram |
| L3    | Packet             |
| L2    | Frame              |
| L1    | Bit                |

## Encapsulation

송신 측에서 상위 계층 데이터에 헤더를 추가하며 하위 계층으로 전달하는 과정

Data → Segment → Packet → Frame → Bit

## Decapsulation

수신 측에서 헤더를 제거하며 상위 계층으로 전달하는 과정

Bit → Frame → Packet → Segment → Data

