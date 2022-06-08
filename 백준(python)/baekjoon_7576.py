# https://www.acmicpc.net/problem/7576

import sys
from collections import deque

M, N = map(int, sys.stdin.readline().strip().split())
box = []

# 상하좌우 방향 리스트
dir = [(1, 0), (0, 1), (-1, 0), (0, -1)]
qCount = 0

for _ in range(N):
    box.append(list(map(int, sys.stdin.readline().strip().split())))

tomatoDeque = deque([])

# 최초에 익어있던 토마토의 위치를 덱에 추가
for i in range(N):
    for j in range(M):
        if box[i][j] == 1:
            tomatoDeque.append((i, j, 0))

while tomatoDeque:
    popQ = tomatoDeque.popleft()
    qN = popQ[0]
    qM = popQ[1]
    qCount = popQ[2]

    for dN, dM in dir:
        nextN = qN + dN
        nextM = qM + dM
        if 0 <= nextN < N and 0 <= nextM < M:
            # 상하좌우 중 익지않은 토마토가 위치할 경우 
            # 최소날짜를 증가시키며 해당 토마토를 익었음을 표시하고 해당 토마토 위치 덱에 추가
            if box[nextN][nextM] == 0:
                box[nextN][nextM] = 1
                tomatoDeque.append((nextN, nextM, qCount+1))

# 만약 모든 토마토가 익지 못했을 경우 0출력 후 프로세스 종료
for i in range(N):
    for j in range(M):
        if box[i][j] == 0:
            print(-1)
            sys.exit(0)

# 프로세스가 종료되지않았다면 토마토가 모두 익었음을 의미
# 토마토가 모두 익을 때까지 최소날짜 출력
print(qCount)