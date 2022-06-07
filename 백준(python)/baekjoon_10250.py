# https://www.acmicpc.net/problem/10250

import sys

T = int(sys.stdin.readline().strip())

for _ in range(T):
    inputList = list(map(int, sys.stdin.readline().strip().split()))
    H = inputList[0]
    W = inputList[1]
    N = inputList[2]
    
    # 온 순서를 건물의 층 수로 나눈 나머지가 0일 경우 최상층을 의미
    if N % H == 0:
        Y = str(H)
        X = str(N // H)
    else:
        Y = str(N % H)
        X = str(1 + (N // H))

    # X가 한자리일 경우, 앞에 '0'추가
    if len(X) == 1:
        print(f'{Y}0{X}')
    else:
        print(f'{Y}{X}')