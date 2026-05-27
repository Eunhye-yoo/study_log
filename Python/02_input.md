# input() 함수 란?
- 사용자로 하여금 값을 받는 함수
- input함수의 매개 변수는 사용자가 적을 내용에 대한 가이드 라인
- 하나의 input 함수에 매개변수가 여러개 될 수 없음
- 매개 변수의 입력한 값은 문자열 취급
- 매개 변수의 값을 숫자 취급 하려면 int, float함수를 사용

## 형 변환

### 문자열 -> 숫자
```python
number = input("숫자 =")
print(number*20)
```
위와 같이 출력하면 사용자가 입력한 값을 문자열 취급 함으로
오류가 뜬다. 

Therefore, 
```python
number = int(input("숫자 ="))
print(number*20)

### 숫자-> 문자열
원하는 결과: 25번째 접속 하셨습니다.
'''python
n = 20
print(n+"번째 접속하셨습니다.")
```
위와 같이 코드를 입력하면, n을 숫자 취급 해서 숫자와 문자를 더한 TypeError가 뜸

Therefore,
```python
n = 20
print(srt(n)+"번째 접속하셨습니다.")

