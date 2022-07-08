import sys

nums = list(map(int, sys.stdin.readline().strip().split()))
res = 0

for num in nums:
    # pow(x, y) => x ** y
    res += pow(num, 2)

# 10으로 나눈 나머지 출력
print(res % 10)