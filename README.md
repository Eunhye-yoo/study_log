# IT Study Log

개발과 인프라의 기초를 이해하기 위해 공부한 내용을 **직접 다시 설명할 수 있는 형태로 정리하는 개인 학습 저장소**입니다.

단순한 자료 모음보다 개념을 이해하고, 실습으로 확인하고, 다시 정리하는 과정을 남기는 것을 목표로 합니다.

## Study Areas

| Area | 주요 내용 | 현재 상태 |
| --- | --- | --- |
| **Network** | OSI 7 Layer, IP, ARP, ICMP, NAT, TCP/UDP, Subnetting, Routing, OSPF, VLAN, Trunk | 지속 학습 중 |
| **Java** | Java 기본 문법 및 객체지향 개념 학습 기록 | 정리 보강 중 |
| **Python** | 변수, 입력, 출력 등 기본 문법 | 기초 학습 |
| **Spring Boot** | MVC, Thymeleaf, Interceptor, JPA, QueryDSL | 별도 실습 저장소에서 학습 중 |

## Repository Structure

### Network

네트워크의 동작 원리를 기초부터 Routing / Switching까지 단계적으로 정리하고 있습니다.

현재 정리된 주요 주제:

- Network 기본 개념
- OSI 7 Layer
- Physical / Data Link / Network / Transport Layer
- IP Address
- MAC Address와 IP Address
- ARP / ICMP
- NAT
- TCP / UDP
- Subnetting / VLSM
- Static Routing
- Default Routing
- Dynamic Routing
- RIP
- OSPF
- VLAN
- Trunk

Packet Tracer 실습 결과와 Routing Table, Ping 결과, 설정 화면도 함께 기록하고 있습니다.

Inter-VLAN Routing, STP, VTP 등 일부 Switching 주제는 계속 보강 중입니다.

### Java

Java 학습 내용을 정리하기 위한 영역입니다.

현재는 기본 구조를 만들어 두고 있으며, 이후 객체지향, Collection, Exception, Stream 등 실제 학습 내용에 맞춰 순차적으로 보강할 예정입니다.

### Python

Python 기본 문법 학습 기록입니다.

현재 정리된 내용:

- 변수 이름 규칙
- `input()`
- `print()`

## Learning Method

학습할 때 아래 흐름을 기준으로 기록합니다.

**1. 개념 이해 → 2. 직접 실습 → 3. 결과 확인 → 4. 핵심 내용 정리 → 5. 다시 설명**

네트워크의 경우 설정 명령어 자체를 외우기보다 **패킷이 어디로 이동하는지, 라우팅 테이블이 왜 그렇게 만들어지는지**를 이해하는 데 중점을 두고 있습니다.

개발 학습에서도 코드 결과만 확인하는 것이 아니라 **요청 흐름, 객체 관계, 데이터 처리 과정**을 설명할 수 있는 수준까지 이해하는 것을 목표로 합니다.

## Related Practice

- [SpringBoot_practice](https://github.com/Eunhye-yoo/SpringBoot_practice) — Spring MVC, Thymeleaf, Interceptor, JPA, QueryDSL 실습
- [EduPOP](https://github.com/Eunhye-yoo/EduPOP) — Java / Spring 기반 학원 관리 서비스 팀 프로젝트

---

This repository records my learning process from fundamentals to practical implementation.
