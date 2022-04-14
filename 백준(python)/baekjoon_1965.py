# https://www.acmicpc.net/problem/1965

import sys

N = int(sys.stdin.readline().strip())

boxList = list(map(int, sys.stdin.readline().strip().split()))

# 상자의 개수에 따른 한 번에 넣을 수 있는 최대 상자 개수
maxBox = [0 for _ in range(N)]

for lastBox in range(N):
    # 최소 1개
    maxSize = 1
    for beforeBox in range(lastBox):
        
        # 가장 뒤에 위치한 상자의 크기가 앞에 위치한 상자의 크기 보다 클 경우 
        # 상자를 담을 수 있다.
        if boxList[beforeBox] < boxList[lastBox]:
            maxSize = max(maxSize, maxBox[beforeBox] + 1)
    
    maxBox[lastBox] = maxSize

print(max(maxBox))