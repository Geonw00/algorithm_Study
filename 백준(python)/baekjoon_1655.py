# https://www.acmicpc.net/problem/1655

import sys
import heapq

# heapq의 경우 자바의 priorityQueue와 비슷하게 생각
# 리스트를 default 오름차순 정렬
N = int(sys.stdin.readline().strip())

leftQue = []
rightQue = []

for i in range(N):
    inNum = int(sys.stdin.readline().strip())
    
    if i % 2 == 0:
        # max heap (내림차순) 0번 인덱스가 최댓값
        # reversed=True와 같이 오름차순 정렬을 위해 비교값은 -를 통해 정렬
        # 실제값 튜플형식으로 같이 저장
        heapq.heappush(leftQue, (-inNum, inNum))
        
    else:
        # min heap (오름차순) 0번 인덱스가 최솟값
        heapq.heappush(rightQue, inNum)
    
    # 오른쪽 리스트의 최솟값이 왼쪽 리스트의 최댓값보다 작다면 두 값 교체
    if len(rightQue) != 0 and leftQue[0][1] > rightQue[0]:
        ckNum = heapq.heappop(rightQue)
        heapq.heappush(rightQue, heapq.heappop(leftQue)[1])
        heapq.heappush(leftQue, (-ckNum, ckNum))
        
    print(leftQue[0][1])
