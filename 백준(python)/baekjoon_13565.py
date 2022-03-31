# https://www.acmicpc.net/problem/13565

import sys
# 런타임 에러(RecursionError) <= 재귀함수 깊이 오류로 인하여 재귀 최대깊이 조정
sys.setrecursionlimit(10**6)
M, N = map(int, sys.stdin.readline().strip().split())

nodeMap = []
for _ in range(M):
    nodeMap.append(sys.stdin.readline().strip())

# 방문여부
nodeCk = [[False for _ in range(N)] for _ in range(M)]

# 현재 위치에서 상하좌우만 이동 가능(아래로 가는 것이 가장 중요하기에 제일 앞에 배치)
nextYX = [(1, 0), (0, 1), (0, -1), (-1, 0)]

res = 'NO'
def dfs(y, x):
    global res
    # 마지막 행에 도착한 것은 전류가 안쪽까지 침투함을 의미
    if y == M - 1:
        res = 'YES'

    nodeCk[y][x] = True
    for Y, X in nextYX:
        nextY = y + Y
        nextX = x + X
        
        # 해당 좌표에 전류가 통해야하며 0 <= Y < M , 0 <= X < N의 범위를 벗어나면 안된다.
        if res != 'YES' and -1 < nextY < M and -1 < nextX < N and nodeMap[nextY][nextX] == '0' and nodeCk[nextY][nextX] == False:
            dfs(nextY, nextX)

for i in range(N):
    # 시작지점도 전류가 통하는 지점
    if nodeMap[0][i] == '0':
        dfs(0, i)
    
    if res == 'YES':
        break

print(res)
    