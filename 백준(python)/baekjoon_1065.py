# https://www.acmicpc.net/problem/1065

import sys

N = int(sys.stdin.readline().strip())

res = 0

# 문제 입력: 1 ~ 1000사이의 자연수
for num in range(1, N+1):
    # 1000은 한수 성립 x
    if num >= 100:
        # 100의 자릿수와 10의 자릿수의 차이 그리고 10의 자릿수와 1의 자릿수의 차이 비교
        # 절댓값 적용시 101과 같은 수 가 포함되어 오류 발생
        if int(str(num)[0]) - int(str(num)[1]) == int(str(num)[1]) - int(str(num)[2]):
            res += 1
            
    # 1 ~ 100 사이의 수는 항상 한수가 성립
    else:
        res += 1

print(res)