# Network Basic
## 1. Network란?
Network는 여러장비(Device)를 통신 매체(Media)로 연결하여 데이터를 주고받기 위한 환경.

---
### 2. Network Media(통신매체)
네트워크 장비들은 유선 또는 무선 매체를 통해 연결된다.
### 2-1. 유선 매체
- 동축 케이블(Coaxial Cable)
- UTP (Unshielded Twisted Pair)
- STP (Shielded Twisted Pair)
- 광케이블(Fiber Optic)
### 2-2. 무선 매체 
- Bluetooth
- Infrared (적외선)
- Wi-Fi

---
## 3. Network Devvices(네트워크 장비)
### Hub
수신한 데이터를 모든 포트로 전달하는 장비
### Switch
목적지 MAC Address를 기반으로 필요한 포트에만 데이터를 전달
### Router
서로 다른 네트워크 간의 통신을 담당
### Bridge
네트워크를 분할하여 트래픽을 줄이는 장비
### Repeater
약해진 신호를 증폭하는 장비 
### NIC(Network Interface Card)
컴퓨터를 네트워크에 연결하기 위한 랜카드
### 공유기
가정이나 소규모 네트워크에서 인터넷 연결을 제공하는 장비

---
## 4. Network 분류
### 4-1. 범위에 따른 분류
#### LAN (Local Area Network)
- 근거리 통신망
- Ethernet 기술 사ㅏ용
#### WAN (Wide Area Network)
- 장거리 통신망
- 인터넷이 대표적인 예

---
### 4-2. 메세지 교환 방식
#### 회선 교환 방식(Circuit Switching)
특정 회선을 미리 확보한 후 데이터를 전송하는 방식

장점
- 안정적인 통신
- 지연이 적음

단점
- 회선이 점유되어 자원 낭비 발생

---
#### 패킷 교환 방식(Packet Switching)
데이터를 작은 패킷 단위로 분할하여 전송하는 방식

장점
- 네트워크 자원을 효율적으로 사용
- 인터넷에서 사용

단점
- 패킷 순서 변경 가능
- 지연 발생 가능

---
### 4-3. Network Topology(토폴로지)
#### Star
중앙 장치에 모든 장비가 연결된 구조
#### Bus
하나의 케이블엘 여러 장비가 연결된 구조
#### Ring
원형으로 연결된 구조
#### Tree
계층 구조로 연결된 형태
#### Mesh
모든 장비가 서로 연결된 구조

---
### 4-4. 통신 방식
#### 단방향(Simplex)
A -> B
예)
- Tv
- 라디오
#### 반이중(Half Duplex)
양방향 가능하지만 동시에 전송 불가 
예)
- 무전기
#### 전이중(Full Duplex)
양방향 동시 통신 가능
예)
- 전화

---
## 5. 데이터 전송 방식 
### Unicast
1:1 통신
### Multicast
1 : 특정 다수
### Broadcast
1 : 전체 

---
## 6. Protocol
Protocol은 서로 다른 장비들이 통신하기 위해 미리 약속한 규칙이다.

예)
- TCP
- IP
- HTTP
- HTTPS
- FTP
- DNS

