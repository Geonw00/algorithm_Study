# https://www.acmicpc.net/problem/2667

import sys
from collections import deque

dirList = [(1, 0), (0, 1), (-1, 0), (0, -1)]
N = int(sys.stdin.readline().strip())
house = [[] for _ in range(N)]
res = []

# 단지를 배정받은 집일 경우 '2'로 표시
# 단지를 배정 후 단지에 위치한 집의 수 반환
def bfs(x, y):
    count = 1
    house[x][y] = '2'
    dq = deque([(x, y)])
    
    while dq:
        nX, nY = dq.popleft()
        
        for dx, dy in dirList:
            nextX = dx + nX
            nextY = dy + nY
            
            if 0 <= nextX < N and 0 <= nextY <N:
                if house[nextX][nextY] == '1':
                    count += 1
                    house[nextX][nextY] = '2'
                    dq.append((nextX, nextY))
    
    return count
            
# list를 int타입으로 입력받을 경우
# 숫자 0이 list에 담기지 않는 경우 발생 => string으로 변경
for idx in range(N):
    house[idx] = list(sys.stdin.readline().strip())

for i in range(N):
    for j in range(N):
        if house[i][j] == '1':
            res.append(bfs(i, j))

# 총 단지의 수 출력
print(len(res))

# 오름차순 정렬
res.sort()

for result in res:
    print(result)