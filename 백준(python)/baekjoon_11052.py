# https://www.acmicpc.net/problem/11052

import sys

N = int(sys.stdin.readline().strip())

# list로 받았기 때문에 0번 index부터 시작
# 0번 index가 카드 1장팩을 의미
card = list(map(int, sys.stdin.readline().strip().split()))

# 카드 1장팩의 경우에는 경우의 수를 따질 필요가 없기때문에 제외
for idx in range(1, N):
    
    # 4장 카드를 뽑을 경우
    # (1, 3), (2, 2) 카드팩을 사는 경우의 수 존재
    for i in range(1, idx+1):
        card[idx] = max(card[idx], card[i-1] + card[idx - i])

# N개 카드를 뽑을 경우 최댓값 출력
print(card[N-1])