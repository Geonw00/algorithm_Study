# https://www.acmicpc.net/problem/5622

import sys

word = sys.stdin.readline().strip()
# ord()를 통해 문자열을 아스키 코드로 변환
# chr()을 통해 아스키 코드를 문자열로 재변환
# [A-Z] 리스트 구성
alpha = [chr(i) for i in range(ord('A'), ord('Z') + 1)]
res = 0

# 'PQRS' == 7 이고 'WXYZ' == 9번으로 구성되어 있음
# 위의 경우를 인지하지 못해 아래와 같이 구현
# dict를 사용하는 것이 더 좋아보임
for dial in word:
    if ord(dial) < ord('S'): 
        if dial == 'S':
            res += (alpha.index(dial) // 3) + 2
        else:
            res += (alpha.index(dial) // 3) + 3
    else:
        if dial == 'Z':
            res += ((alpha.index(dial) - 1) // 3) + 2
        else:
            res += ((alpha.index(dial) - 1) // 3) + 3

print(res)