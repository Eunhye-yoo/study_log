# 변수(variable)란?

변수는 값을 저장할 수 있는 공간이다.

# 기본 규칙

- 대소문자를 구분한다.
- 공백(space)을 포함할 수 없다.
- 숫자로 시작할 수 없다.
- 언더스코어(_)를 제외한 특수문자를 사용할 수 없다.
- 예약어를 사용할 수 없다.
- 의미 없는 변수명 사용을 지양한다.
- 여러 단어 조합 시 snake_case 또는 camelCase를 사용한다.

# 좋은 예시

## snake_case
'''Python
my_name = "Yoo"
'''

## camelCase
'''Python
myName = "Yoo"
'''

# 잘못된 예시

'''Python
my-name = "Yoo"
1name = "Yoo"
class = "Yoo"
