# https://www.acmicpc.net/problem/13335

import sys
from collections import deque

inputList = list(map(int, sys.stdin.readline().strip().split()))
n = inputList[0]
w = inputList[1]
L = inputList[2]         

truck = list(map(int, sys.stdin.readline().strip().split()))
truckQ = deque()
bridge = deque()

for i in truck:
    truckQ.append(i)

# 다리에 첫 번째 트럭진입
bridge.append(truckQ.popleft())
res = 1

# 모든 트럭이 다리에 진입할 때까지 반복
while truckQ:
    res += 1
    
    # 다리를 건넌 트럭 제거
    if len(bridge) == w:
        bridge.popleft()
    
    # 다리에 트럭이 올라갈 수 있을 경우, 새 트럭 진입
    # 아닐 경우 새로운 트럭이 진입하지 않았기때문에 0추가 
    if sum(bridge) + truckQ[0] <= L:
        bridge.append(truckQ.popleft())
    else:
        bridge.append(0)

# 마지막 트럭이 다리를 건너는 시간을 더해줘야함
res += w

print(res)