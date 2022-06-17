# https://www.acmicpc.net/problem/1654

import sys

K, N = map(int, sys.stdin.readline().strip().split())
lanList = []

for _ in range(K):
    lanList.append(int(sys.stdin.readline().strip()))

# 이분탐색
start = 1
end = max(lanList)

while start <= end:
    mid = (start + end) // 2
    total = 0
    
    for lan in lanList:
        total += lan // mid
    
    # 자른 랜선의 수가 N보다 크다면 잘라야할 랜선의 길이가 mid보다 작다는 의미
    if total >= N:
        start = mid + 1
    # 자른 랜선의 수가 N보다 작다면 잘라야할 랜선의 길이가 mid보다 크다는 의미
    else:
        end = mid - 1

# 조건에 만족하는 가장 긴 랜선의 길이를 출력해야하기 때문에
# start ~ end 사이의 모든 수가 조건에 만족할 경우
# 가장 긴 길이인 end를 출력
print(end)