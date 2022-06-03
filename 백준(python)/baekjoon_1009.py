import sys

# https://www.acmicpc.net/problem/1009

T = int(sys.stdin.readline().strip())

for _ in range(T):
    a, b = map(int, sys.stdin.readline().strip().split())

    # a의 b승을 10으로 나눈 나머지가 0일 경우, 10번 컴퓨터가 마지막으로 처리함을 의미
    # 아닐 경우 a의 b승을 10으로 나눈 나머지번 컴퓨터가 마지막으로 처리함을 의미
    # math.pow는 나머지 부분은 지원하지 않지만 내장 pow는 지원
    if pow(a, b, 10) == 0:
        print(10)
    else:
        print(pow(a, b, 10))