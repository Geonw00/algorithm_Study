# https://www.acmicpc.net/problem/5397

import sys
from collections import deque

def findPw(inCase):
    index = 0
    result = ''
    resultdeq = deque()
    # 현재 커서가 위치한 index는 deque 마지막 위치
    for i in inCase:
        if i == '-':
            # 마지막 문자열 삭제
            if index > 0:
                resultdeq.pop()
                index -= 1
        
        # 좌측으로 커서가 이동해야하기 때문에 오른쪽으로 회전   
        elif i == '<':
            if index > 0:
                resultdeq.rotate(1)
                index -= 1

        # 우측으로 커서가 이동해야하기 때문에 왼쪽으로 회전   
        elif i == '>':
            if index < len(resultdeq):
                resultdeq.rotate(-1)
                index += 1
        
        else:
            # 현재 커서위치에 문자열 추가
            resultdeq.append(i)
            index += 1
    
    # 문자열을 index 기준 0부터 정렬해야함
    resultdeq.rotate(index)
    result = "".join(resultdeq)
    
    return result

N = int(sys.stdin.readline())

resultLi = []
for i in range(N):
    # strip() 을 안할 시 50%에서 오답처리
    inCase = str(sys.stdin.readline().strip())
    resultLi.append(findPw(inCase))

for i in resultLi:
    print(i)
    