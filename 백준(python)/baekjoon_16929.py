# https://www.acmicpc.net/problem/16929

import sys

N, M = map(int, sys.stdin.readline().strip().split())

# 게임판의 상태
pointMap = [['' for _ in range(M)] for _ in range(N)]

for y in range(N):
    inPoint = sys.stdin.readline().strip()
    for x in range(M):
        pointMap[y][x] = inPoint[x]

# 상하좌우로 이동
dirList = [(0, -1), (1, 0), (0, 1), (-1, 0)]

# 방문여부
visitCk = [[False for _ in range(M)] for _ in range(N)]

# 전역변수 사용 x
# 최초에 전역변수를 사용하여 문제를 풀었지만 시간초과 발생
# 내부 변수와 전역 변수의 변수 저장 방식의 차이(STORE_FAST opcode, STORE_NAME opcode)
# dfs
def dfs(startPointY, startPointX, firstY, firstX, count):
    
    # 크기가 4개 이상의 점으로 구성된 사이클이 발견될 시 종료
    if count >= 4 and firstX == startPointX and firstY == startPointY:
        print('Yes')
        # exit() => 프로세스 종료
        exit()
        
    for x, y in dirList:
        nextPointY = startPointY + y
        nextPointX = startPointX + x
        # 다음 점의 위치는 게임판의 크기를 벗어날 수 없음
        if 0 <= nextPointY < N and 0 <= nextPointX < M:   
            # 방문하지 않았으며 현재 점의 색과 방문할 점의 색이 같다면 방문진행    
            if visitCk[nextPointY][nextPointX] == False and pointMap[startPointY][startPointX] == pointMap[nextPointY][nextPointX]:
                visitCk[nextPointY][nextPointX] = True
                dfs(nextPointY, nextPointX, firstY, firstX, count+1)
                visitCk[nextPointY][nextPointX] = False

for y in range(N):
    for x in range(M):
        dfs(y, x, y, x, 0)

# 사이클이 발견되지 않음을 의미(발견 시 Yes 출력 후 프로세스 종료)
print('No')