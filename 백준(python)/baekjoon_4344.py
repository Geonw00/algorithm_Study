# https://www.acmicpc.net/problem/4344

import sys

N = int(sys.stdin.readline().strip())
inputList = []
res = []

for _ in range(N):
    inputList = list(map(int, sys.stdin.readline().strip().split()))
    pointList = inputList[1:]
    avg = sum(pointList) / inputList[0]
    count = 0
    
    # 평균을 넘는 학생 수
    for point in pointList:
        if point > avg:
            count += 1
    
    # 평균을 넘는 학생의 비율
    res.append(count/inputList[0] * 100)
    
for result in res:
    # 소숫점 셋째자리까지 출력
    print(f'{result:.3f}%')