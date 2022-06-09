# https://www.acmicpc.net/problem/1158

import sys
from collections import deque

N, K = map(int, sys.stdin.readline().strip().split())

dq = deque()
res = ""

for idx in range(1, N+1):
    dq.append(idx)

# N명의 사람이 모두 제거될때까지 반복
while dq:
    # K를 기준으로 한 요세푸스 순열에 해당하는 수가 가장 오른쪽에 위치하도록 재배치
    dq.rotate(-K)
    
    # 요세푸스 순열에 해당하는 수 제거
    if len(dq) == 1:
        res += str(dq.pop())
    else:    
        res += str(dq.pop()) + ", "

print(f'<{res}>')