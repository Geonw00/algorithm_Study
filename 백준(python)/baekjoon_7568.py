# https://www.acmicpc.net/problem/7568

import sys

N = int(sys.stdin.readline())
inputList = []
ans = ''

# 키와 몸무게 리스트에 추가
for _ in range(N):
    x, y = map(int, sys.stdin.readline().strip().split())
    inputList.append([x, y])

# 1번 사람부터 차례로 N번까지의 사람과 하나하나 비교
for idx in range(N):
    rank = 1
    nowX = inputList[idx][0]
    nowY = inputList[idx][1]
    
    for i in range(N):
        if i != idx and nowX < inputList[i][0] and nowY < inputList[i][1]:
            rank += 1
    if idx == 0:
        ans += str(rank)
    else:
        ans += ' ' + str(rank)

# 양식에 맞게 출력
print(ans)