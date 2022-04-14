# https://www.acmicpc.net/problem/2565

import sys

N = int(sys.stdin.readline().strip())

lineNode = []

for i in range(N):
    A, B = map(int, sys.stdin.readline().strip().split())    
    lineNode.append((A, B))

# A 전깃줄의 위치를 기준으로 오름차순 정렬
lineNode.sort(key=lambda x: x[0])

# 교차하지 않는 가장 많은 전깃줄 개수 리스트
maxList = [0 for _ in range(N)]

for last in range(N):
    
    maxLine = 1
    for before in range(last):
        
        # last 전깃줄의 위치보다 위에 있는 전깃줄의 경우
        # 연결된 B 전깃줄의 위치가 last 위치와 연결된 B 전깃줄보다 위에 위치할 경우
        # 교차되지 않는다. 
        if lineNode[last][1] > lineNode[before][1]:
            maxLine = max(maxLine, maxList[before] + 1)
    
    maxList[last] = maxLine

# 없애야 하는 전깃줄 최소 개수 = 전체 전깃줄 수 - 교차되지 않는 최대 전깃줄 개수
print(N - max(maxList))