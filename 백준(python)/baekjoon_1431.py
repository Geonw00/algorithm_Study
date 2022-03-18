# https://www.acmicpc.net/problem/1431

import sys
import re

N = int(sys.stdin.readline().strip())
guitarS = []

# 문자열 중 숫자인 모든 자리수의 값 반환
def checkRes(Serial):
    resSum = 0
    for i in Serial:
        if re.match('[0-9]', i):
            resSum += int(i)
    
    return resSum

for i in range(N):
    guitarS.append(sys.stdin.readline().strip())

# 선택정렬
for now in range(len(guitarS)-1):
    for comIn in range(now+1, len(guitarS)):
        comS =[]

        # 길이가 짧은 것이 우선순위 높음
        if len(guitarS[now]) != len(guitarS[comIn]):
            if len(guitarS[now]) > len(guitarS[comIn]):
                guitarS[now], guitarS[comIn] = guitarS[comIn], guitarS[now]
        
        # 문자열의 길이가 같다면 모든 자리수의 합이 낮은 것이 우선순위 높음
        elif len(guitarS[now]) == len(guitarS[comIn]):
            if checkRes(guitarS[now]) > checkRes(guitarS[comIn]):
                guitarS[now], guitarS[comIn] = guitarS[comIn], guitarS[now]
            
            # 앞의 두 비교를 통해 정렬을 할 수 없다면 사전순으로 정렬
            elif checkRes(guitarS[now]) == checkRes(guitarS[comIn]):
                if guitarS[now] > guitarS[comIn]:
                    guitarS[now], guitarS[comIn] = guitarS[comIn], guitarS[now]
            
for i in guitarS:
    print(i)
            