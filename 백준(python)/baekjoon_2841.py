# https://www.acmicpc.net/problem/2841
import sys

# 주의할점
# result라는 이름을 변수로 사용할 때 자동적으로 unitest result가 import되는 경우
# 시간 효율성이 저해된다. 
N, P = map(int, sys.stdin.readline().strip().split())
result = 0
# 자바의 [N+1][] 이중리스트 생성
# 해당 디폴트 값을 0 지정하여 최초 값 넣을 때 index 에러 방지
pushLi = [[0] for i in range(N+1)]

for i in range(N):
    nowN, nowP = map(int, sys.stdin.readline().strip().split())
    
    # 이미 누르고 있는 프렛의 번호보다 눌러야 하는 프렛의 번호가 작을 경우
    # 이미 누르고 있는 프렛에서 손가락을 떼야함
    while pushLi[nowN][-1] > nowP:
        pushLi[nowN].pop()
        result += 1
        
    if pushLi[nowN][-1] < nowP:
        pushLi[nowN].append(nowP)
        result += 1
        
print(result)
