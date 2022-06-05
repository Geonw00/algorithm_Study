# https://www.acmicpc.net/problem/2193

import sys

N = int(sys.stdin.readline().strip())

dp = [0 for _ in range(91)]

# 이친수의 경우 자릿수가 하나 작은 이친수에 0이
# 자릿수가 둘 작은 이친수에서 01이 추가되는 패턴을 보이고 있다.
# 그러므로 N-1, N-2 자릿수의 이친수 수를 더한 값은
# N 자릿스의 이친수 수를 의미한다. 
for idx in range(1, N+1):
    if idx == 1 or idx == 2:
        dp[idx] = 1
    else:
        dp[idx] = dp[idx-1] + dp[idx-2]

print(dp[N])