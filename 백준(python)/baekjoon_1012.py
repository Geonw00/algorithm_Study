# https://www.acmicpc.net/problem/1012

import sys
from collections import deque

T = int(sys.stdin.readline().strip())
dirList = [(1, 0), (0, 1), (-1, 0), (0, -1)]

# bfs
def bfs(x, y):
    farm[x][y] = 2
    dp = deque([(x, y)])
    
    while dp:
        nowX, nowY = dp.popleft()
        
        for dx, dy in dirList:
            nextX = dx + nowX
            nextY = dy + nowY
            if 0 <= nextX < M and 0 <= nextY < N:
                # 지렁이의 영향력 내에 존재하는 배추들 2로 표시
                if farm[nextX][nextY] == 1:
                    farm[nextX][nextY] = 2
                    dp.append((nextX, nextY))        

for _ in range(T):
    res = 0
    inMNK = list(map(int, sys.stdin.readline().strip().split()))
    M = inMNK[0]
    N = inMNK[1]
    K = inMNK[2]
    
    farm = [[0 for _ in range(N)] for _ in range(M)]
    for _ in range(K):
        X, Y = map(int, sys.stdin.readline().strip().split())
        farm[X][Y] = 1
    
    for i in range(M):
        for j in range(N):
            # 특정 배추를 기준으로 지렁이를 두었을 경우
            # 인접한 배추가 존재하여 지렁이가 움직일 수 있다면 
            # 인접한 모든 배추들은 지렁이 한 마리로 대체가능
            # 인접하지 않은 배추가 존재한다면 그 배추를 기준으로 반복
            if farm[i][j] == 1:
                res += 1
                bfs(i, j)
    
    print(res)