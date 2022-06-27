# https://www.acmicpc.net/problem/2798

import sys

N, M = map(int, sys.stdin.readline().strip().split())

card = list(map(int, sys.stdin.readline().strip().split()))
res = sys.maxsize

# 중복없이 카드 세 장을 더하는 모든 경우의 수 탐색
for i in range(N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            # 카드 세 장의 합이 M을 넘지않으며, 가장 가까운 카드 선별 
            if res == sys.maxsize:
                if res > M - (card[i] + card[j] + card[k]) >= 0:
                    res = card[i] + card[j] + card[k]
            elif M - res > M - (card[i] + card[j] + card[k]) >= 0:
                res = card[i] + card[j] + card[k]

print(res)