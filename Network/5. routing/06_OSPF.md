# OSPF (Open Shortest Path First)

## OSPF란?

OSPF(Open Shortest Path First)는 Link State 방식의 동적 라우팅 프로토콜이다.

Router끼리 주변의 연결 상태(Link) 정보를 교환하여 전체 네트워크 지도를 만든 뒤 Routing Table을 자동으로 생성한다.

경로 선택 기준은 Cost(대역폭/속도)이며, 목적지까지 가는 길의 속도가 가장 빠른(대역폭이 큰) 경로를 선택한다.

> OSPF는 "모든 도로의 지도와 제한 속도(대역폭)를 파악한 뒤, 방지턱이 많아도(Hop Count가 많아도) 고속도로처럼 가장 빠르게 도착할 수 있는 길"을 찾는 과정이라고 생각하면 된다.

---

## OSPF의 특징

- Link State 방식
- Dijkstra(다익스트라) 알고리즘 사용
- Cost(대역폭) 기준 경로 선택
- 네트워크 변화가 있을 때만 즉시 업데이트 (이벤트 기반)
- Area(구역) 개념을 사용하여 대규모 네트워크 가능
- 대형 네트워크 및 기업에서 가장 많이 사용

---

## OSPF의 주요 개념 (Area 및 Router 종류)

OSPF는 네트워크가 너무 커지면 관리가 힘들기 때문에 Area(구역)라는 단위로 나누어 관리한다.

### Area 0 (Backbone Area)
중심이 되는 구역이다. OSPF에서 다른 모든 Area들은 반드시 이 Area 0과 물리적으로 연결되어 있어야 통신이 가능하다.

### AS (Autonomous System)
하나의 거대한 네트워크 울타리다. 같은 관리자나 기업체 안에서 동일한 라우팅 규칙(프로토콜)을 사용하는 네트워크 영역을 뜻한다.

### ASBR (Autonomous System Boundary Router)
우리 네트워크 울타리(AS)와 외부 네트워크(예: 다른 회사 네트워크나 인터넷)를 연결해주는 경계 지점의 라우터이다.

---

## Wildcard Mask란?

Wildcard Mask는 OSPF 설정이나 보안 규칙을 정할 때, 특정 네트워크 범위를 지정하기 위해 사용하는 필터 값이다. Subnet Mask를 거꾸로 뒤집어 놓은 모양을 가진다.

Subnet Mask : 255.255.255.0

↓ 거꾸로 뒤집기 (255는 0으로, 0은 255로)

Wildcard Mask : 0.0.0.255

### 비트의 의미

0 = 이 자리는 무조건 똑같아야 함 (고정 / 일치)

1 = 이 자리는 어떤 숫자가 와도 상관없음 (무시)

예)

Network 주소 : 192.168.53.0
Wildcard Mask : 0.0.0.255

앞의 세 덩어리(192.168.53)는 무조건 똑같아야 하고, 마지막 옥텟은 어떤 숫자가 와도 상관없다는 뜻이다. 즉, 192.168.53.0 대역 전체를 의미한다.

---

## OSPF 설정

router ospf 1
network 192.168.53.0 0.0.0.255 area 0
network 1.1.1.0 0.0.0.255 area 0

### 명령어 설명

router ospf 1
OSPF 프로세스 시작 (뒤의 숫자 1은 Process ID이며, 라우터 내부에서 식별용으로 쓰는 1~65535 사이의 숫자이다.)

network [Network 주소] [Wildcard Mask] area [Area 번호]
내가 광고할 네트워크 대역을 지정하고, 해당 대역이 속할 구역(Area)을 지정한다. (가장 기본이 되는 단일 구역 환경에서는 보통 area 0을 사용한다.)

---

## Routing Table 확인

show ip route

예)

O 192.168.54.0/24 [110/65] via 1.1.1.2

의미

O = OSPF

110 = Administrative Distance (우선순위 값)

65 = Cost (대역폭 기준 목적지까지의 총 비용)

via = Next Hop (다음에 거칠 라우터 IP)

---

## 실습 1 - OSPF 단일 구역(Single Area) 설정

### 사용 장비

- Router 2대
- PC 2대
- Switch 2대

### 토폴로지

PC0
192.168.53.10/24
GW 192.168.53.254

    |

Switch0

    |

R0 G0/0
192.168.53.254/24

R0 G0/1
1.1.1.1/24

    |

R1 G0/0
1.1.1.2/24

R1 G0/1
172.16.0.1/16

    |

Switch1

    |

PC1
172.16.0.10/16
GW 172.16.0.1

### 목표

- OSPF 설정 (Area 0 사용)
- Wildcard Mask 적용 확인
- Router끼리 Neighbor(이웃) 관계 맺고 네트워크 학습
- PC0 ↔ PC1 Ping 성공

### 캡처

![OSPF Topology](../images/routing/ospf-topology-basic.png)

(토폴로지 전체 캡처)

![OSPF Config](../images/routing/ospf-config-basic.png)

(R0의 OSPF 설정 화면)

![OSPF Route](../images/routing/ospf-route-basic.png)

(show ip route 결과에서 'O'로 시작하는 경로 확인)

![OSPF Ping](../images/routing/ospf-ping-basic.png)

(PC0 → PC1 ping 성공)

---

## 암기 포인트

Link State

Dijkstra

Cost (대역폭 기준)

Area 0 (Backbone Area)

ASBR = AS 경계 라우터

Wildcard Mask = Subnet Mask의 반대 (0은 일치, 1은 상관없음)

router ospf [Process ID]

network [네트워크] [와일드카드] area [번호]

show ip route (코드 O)

---

## 정리

- OSPF는 Link State 기반의 동적 라우팅 프로토콜이다.
- 라우터끼리 링크 상태 정보를 교환하여 전체 네트워크 지도를 그리고 최적 경로를 찾는다.
- 거리가 멀어도 대역폭(속도)이 더 빠른 경로를 최적의 길(Cost가 낮은 길)로 선택한다.
- OSPF 설정을 할 때는 Subnet Mask 대신 Wildcard Mask를 사용하여 범위를 지정한다.
- 구역을 쪼개어 대규모 네트워크를 구성할 수 있으며, 중심 구역인 Area 0이 반드시 필요하다.
- show ip route 명령어를 쳤을 때 OSPF로 배운 주소는 맨 앞에 'O' 마크가 붙는다.

## 한 줄 요약

OSPF는 대역폭(속도)을 기준으로 가장 빠른 경로를 선택하며, 대규모 네트워크 관리를 위해 Area와 Wildcard Mask를 사용하는 대표적인 Link State 동적 라우팅 프로토콜이다.
