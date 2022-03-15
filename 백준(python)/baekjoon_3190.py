# https://www.acmicpc.net/problem/3190

import sys
from collections import deque

N = int(sys.stdin.readline())
K = int(sys.stdin.readline())

# 사과의 위치를 이중 배열을 통해서 표현
# 편의를 위해 0 ~ N+1의 크기로 만듬 
board = [[0] * (N+1) for i in range(N+1)]
for i in range(K):
    y, x = map(int, sys.stdin.readline().strip().split())
    board[y][x] = 1

L = int(sys.stdin.readline())
# 방향 전환 정보 딕셔너리를 통해 저장
changeL = {}
for i in range(L):
    X, C = map(str, sys.stdin.readline().strip().split())
    changeL[int(X)] = C

res = 0
x = 1
y = 1
front = 0

# 현재 뱀의 머리와 꼬리가 있는 위치 덱를 통해서 저장
nowLoc = deque()
nowLoc.append((x, y))

# 해당 초가 지난 후 방향 전환
def ckLoc(res):
    global front
    if res in changeL.keys():
        if changeL[res] == 'D':
            front += 1
        elif changeL[res] == 'L':
            front -= 1

while True:
    res += 1
    # 우
    if front % 4 == 0:
        x += 1
    # 하 
    elif front % 4 == 1:
        y += 1
    # 좌    
    elif front % 4 == 2:
        x -= 1
    # 상
    elif front % 4 == 3:
        y -= 1
    
    # 뱀이 board의 범위를 벗어나거나 자신의 몸과 닿을 시 종료
    if x == N+1 or x == 0 or y == N+1 or y == 0 or (x, y) in nowLoc:
        break
    
    # 이동한 위치에 사과 있을 시 사과 먹음
    if board[y][x] == 1:
        # 사과를 먹었으면 해당자리에 사과 초기화
        board[y][x] = 0
        nowLoc.append((x,y))
    else:
        nowLoc.popleft()
        nowLoc.append((x,y))
        
    # 방향전환 체크
    ckLoc(res)

print(res)
