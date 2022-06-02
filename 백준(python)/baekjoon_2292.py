# https://www.acmicpc.net/problem/2292

import sys

N = int(sys.stdin.readline().strip())

count = 1
maxN = 1

while N > maxN:
    maxN += count * 6
    count += 1

print(count)