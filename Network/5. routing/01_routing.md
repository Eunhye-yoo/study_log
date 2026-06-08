# Routing (라우팅)

## Routing이란?

Routing(라우팅)은

데이터가 목적지 네트워크까지 이동할 때

어떤 경로로 보낼지 결정하는 과정이다.

쉽게 말하면

```text
네트워크의 길찾기 기능
```

이라고 생각하면 된다.

---

## 왜 Routing이 필요할까?

같은 네트워크에 있는 장비끼리는

Switch를 통해 통신할 수 있다.

예)

```text
PC A
192.168.1.10

PC B
192.168.1.20
```

둘 다

```text
192.168.1.0/24
```

네트워크에 속해 있으므로

Switch만으로 통신이 가능하다.

---

하지만

```text
PC A
192.168.1.10

PC B
10.10.10.20
```

처럼

서로 다른 네트워크라면

Switch만으로는 통신할 수 없다.

이때 Router가 필요하다.

---

## Router란?

Router는

서로 다른 네트워크를 연결하는 장비이다.

예)

```text
192.168.1.0/24

      ↓

    Router

      ↓

10.10.10.0/24
```

Router는

```text
어느 방향으로 보내야 하는가?
```

를 결정하여 데이터를 전달한다.

---

## Routing Table

Router는 Routing Table이라는 표를 가지고 있다.

Routing Table은

```text
목적지 네트워크

↓

어느 인터페이스로 보낼 것인가
```

를 저장한 표이다.

예)

```text
목적지              출구

192.168.1.0/24      G0/0
10.10.10.0/24       G0/1
```

비유하면

```text
네비게이션 지도
```

와 같다.

---

## Routing 동작 과정

상황

```text
PC A
192.168.1.10

      ↓

    Router

      ↓

PC B
10.10.10.20
```

---

1단계

PC A는

```text
10.10.10.20
```

으로 데이터를 전송한다.

---

2단계

PC A는 자신의 IP와 목적지 IP를 비교한다.

```text
192.168.1.10

↓

10.10.10.20
```

서로 다른 네트워크임을 확인한다.

---

3단계

PC A는 Router에게 데이터를 전달한다.

이때 사용하는 주소가

```text
Default Gateway
```

이다.

---

4단계

Router는 패킷을 수신한다.

---

5단계

Routing Table을 확인한다.

```text
10.10.10.0/24

어디로 보내야 하지?
```

---

6단계

해당 네트워크 방향으로 패킷을 전달한다.

---

7단계

목적지 PC가 패킷을 수신한다.

---

## Default Gateway란?

Default Gateway는

```text
다른 네트워크로 나가기 위한 출입구
```

이다.

예)

```text
IP : 192.168.1.100

SM : 255.255.255.0

GW : 192.168.1.1
```

---

PC는

```text
같은 네트워크

→ 직접 전송
```

```text
다른 네트워크

→ Gateway로 전송
```

을 수행한다.

---

## Routing에서 사용하는 PDU

3계층(Network Layer)의 PDU는

```text
Packet
```

이다.

예)

```text
[IP Header]
+
[Data]
```

---

Router는

Packet 안의 IP Address를 확인하여

어디로 전달할지 결정한다.

---

## Switch와 Router 차이

### Switch

```text
MAC Address 사용

같은 네트워크 통신 담당

Frame 처리
```

---

### Router

```text
IP Address 사용

다른 네트워크 통신 담당

Packet 처리
```

---

## 암기 포인트

```text
Routing

= 경로 결정
```

```text
Router

= 서로 다른 네트워크 연결
```

```text
Routing Table

= 경로 정보 저장
```

```text
Default Gateway

= 다른 네트워크로 나가는 출입구
```

```text
3계층 PDU

= Packet
```

```text
Switch

= Frame 처리
```

```text
Router

= Packet 처리
```

---

## 정리

- Routing은 목적지까지의 경로를 결정하는 과정이다.
- Router는 서로 다른 네트워크를 연결한다.
- Router는 Routing Table을 참고하여 데이터를 전달한다.
- 다른 네트워크로 나갈 때는 Default Gateway를 사용한다.
- Router는 Packet을 처리한다.
- Switch는 같은 네트워크 통신을 담당하고 Router는 다른 네트워크 통신을 담당한다.

## 한 줄 요약

Routing은 Router가 IP Address를 보고 목적지 네트워크까지의 경로를 결정하여 Packet을 전달하는 과정이다.
