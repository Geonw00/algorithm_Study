# https://www.acmicpc.net/problem/17952

import sys
from collections import deque

N = int(sys.stdin.readline().strip())
study = deque([])
res = 0

for _ in range(N):
    inList = list(map(int, sys.stdin.readline().strip().split()))
    
    # deque가 비어있는 경우
    if not study:
        if inList[0] == 1:
            if inList[2] - 1 == 0:
                res += inList[1]
            else:
                study.append((inList[1], inList[2]-1))
        # 과제목록이 비어있고 새로운 과제가 없을 경우 할 일이 없음을 의미
        else:
            pass
    
    # deque가 비어있지 않은 경우
    else:
        if inList[0] == 1:
            if inList[2] - 1 == 0:
                res += inList[1]
            else:
                study.append((inList[1], inList[2]-1))
            
        else:
            # 새로운 과제가 없을 경우 최근에 하던 과제를 진행
            nowStudy = study.pop()
            if nowStudy[1] - 1 ==0:
                res += nowStudy[0]
            else:
                study.append((nowStudy[0], nowStudy[1]-1))

print(res)