# https://www.acmicpc.net/problem/2156

import sys

n = int(sys.stdin.readline().strip())
wine = []
dp = [0 for _ in range(n)]

for _ in range(n):
    wine.append(int(sys.stdin.readline().strip()))

dp[0] = wine[0]

for i in range(1, n):
    # 포도잔을 두 잔 마실경우 두 잔 모두 마시는 것이 가장 많이 마시는 경우의 수
    if i == 1:
        dp[i] = wine[i-1] + wine[i]
        
    # 포도잔을 세 잔 마실경우 3가지의 경우의 수 존재
    elif i == 2:
        dp[i] = max(wine[i-1] + wine[i-2], wine[i-1] + wine[i], wine[i-2] + wine[i])
    
    # i번째 잔까지 최대로 마시는 경우 i+1번째 값은 무조건 제외
    # 그러므로 아래와 같은 3가지의 경우의 수 도출
    else:
        dp[i] = max(dp[i-3] + wine[i-1] + wine[i], dp[i-2] + wine[i], dp[i-1])

print(dp[n-1])