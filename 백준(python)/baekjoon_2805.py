# https://www.acmicpc.net/problem/2805

import sys

N, M = map(int, sys.stdin.readline().strip().split())
tree = list(map(int, sys.stdin.readline().strip().split()))

start = 1
end = max(tree)

# 이분 탐색을 통해 적어도 M미터의 나무를 가져갈 수 있는 최댓값을 구함
while True:
    # start값이 end값을 초과할 때 종료
    # while문의 조건문으로 대체가능
    if start > end:
        break

    mid = (start + end) // 2
    treeLen = 0
    
    # mid값으로 나무를 자를 때 mid로 잘라서 나온 나무길이의 합
    for i in tree:
        if i > mid:
            treeLen += (i - mid)

    if M > treeLen:
        end = mid - 1
    else:
        start = mid + 1

# 최댓값 출력
print(end)