# https://www.acmicpc.net/problem/15591
# python3으로 제출시 시간초과, pypy3로 제출하여 해결

import sys
from collections import deque

N, Q = map(int, sys.stdin.readline().strip().split())

# 각 video 기준 유사도 그래프 구성
# 편의를 위해 N+1의 크기로 1 ~ N 까지의 index 사용
usadoGraph = [[] for _ in range(N+1)]
resList = []

# 입력받은 수 기준 유사도 검증함수
def bfs(startNum):
    res = 0
    visitCk[startNum] = True
    
    # 유사도 갱신의 위해서 최댓값으로 deque 구성
    usadoQue = deque([(startNum, sys.maxsize)])

    while usadoQue:
        nowV, usado = usadoQue.popleft()

        for nextV, nextUsado in usadoGraph[nowV]:
            nextUsado = min(usado, nextUsado)
            if not visitCk[nextV] and K <= nextUsado:
                res += 1
                usadoQue.append((nextV, nextUsado))
                visitCk[nextV] = True
    return res      

for _ in range(N-1):
    usadoInput = list(map(int, sys.stdin.readline().strip().split()))
    # video간의 유사도를 기준으로 그래프 구성
    usadoGraph[usadoInput[0]].append((usadoInput[1], usadoInput[2]))
    usadoGraph[usadoInput[1]].append((usadoInput[0], usadoInput[2]))

for _ in range(Q):
    K, nowVideo = map(int, sys.stdin.readline().strip().split())
    visitCk = [False for _ in range(N+1)]
    resList.append(bfs(nowVideo))

for result in resList:
    print(result)