# https://www.acmicpc.net/problem/2748

import sys

N = int(sys.stdin.readline().strip())

n0 = 0
n1 = 1
count = 1

while count != N:
    res = n0 + n1
    n0 = n1
    n1 = res
    count += 1

if count == 1:
    print(1)
else:
    print(res)