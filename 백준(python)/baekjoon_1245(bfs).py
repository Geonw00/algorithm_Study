# https://www.acmicpc.net/problem/1245

import sys
from collections import deque

# bfs
def bfs(y, x):
    global topCk
    bfsQue = deque([(y, x)])   
    
    # 방문여부 체크
    visitCk[y][x] = True

    while len(bfsQue) != 0:
        nowY, nowX = bfsQue.popleft()
        
        # 상하좌우, 대각선 위치
        for dY, dX in dirList:
            nextY = nowY + dY
            nextX = nowX + dX
            if 0 <= nextY < N and 0 <= nextX < M:
                
                # 만약 방문할지점의 산높이가 더 크다면 이전 위치는 산봉우리가 아님
                if mountHeight[nextY][nextX] > mountHeight[y][x]:
                    topCk = False
                
                # 산 높이가 같은 지점일 경우 방문
                elif visitCk[nextY][nextX] == False and mountHeight[nextY][nextX] == mountHeight[y][x]:        
                    visitCk[nextY][nextX] = True
                    bfsQue.append((nextY, nextX))
                
N, M = map(int, sys.stdin.readline().strip().split())

mountHeight = [[] for _ in range(N)]
visitCk = [[False for _ in range(M)] for _ in range(N)]

# 인접한 격자는 상하좌우 + 대각선
dirList = [(0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1)]

# 해당 위치가 산봉우리인지 확인
topCk = True

resCount = 0
minHeight = 500

for i in range(N):
    # type(list(map(int,sys.stdin.readline().strip().split())))) => list[int]
    # type(sys.stdin.readline().strip().split()) -> list[string]
    # 위 두개의 코드는 타입에서 차이를 보이지 않지만 내부 숫자의 타입은 int와 string으로 다르다.
    # string의 경우 bfs 내부 산봉우리 크기 비교시에 int형으로 변환해 주어야한다. 
    mountHeight[i] = list(map(int,sys.stdin.readline().strip().split()))

for Y in range(N):
    for X in range(M):
        # 방문하지 않은 위치 방문
        if visitCk[Y][X] == False and mountHeight[Y][X] != 0:
            topCk = True
            bfs(Y, X)

print(resCount)