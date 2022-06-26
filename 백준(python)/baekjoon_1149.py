# https://www.acmicpc.net/problem/1149

import sys

N = int(sys.stdin.readline().strip())

home = [[] for _ in range(N)]

for i in range(N):
    home[i] = list(map(int, sys.stdin.readline().strip().split()))

# 현재 집마다 빨강, 초록, 파랑을 선택했을 때 
# 현재 집의 색을 제외하고 이전 집의 최소비용을 더함
for i in range(N - 1):
    home[i+1][0] = min(home[i][1], home[i][2]) + home[i+1][0]
    home[i+1][1] = min(home[i][0], home[i][2]) + home[i+1][1]  
    home[i+1][2] = min(home[i][0], home[i][1]) + home[i+1][2]

print(min(home[N-1]))