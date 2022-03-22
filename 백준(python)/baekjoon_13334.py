# https://www.acmicpc.net/problem/13334
import sys
import heapq

N = int(sys.stdin.readline().strip())
inLoc = []

# 끝값, 시작값, 두 값의 차이를 저장
for _ in range(N):
    a, b = map(int, sys.stdin.readline().strip().split())
    minN = min(a, b)
    maxN = max(a, b)
    inLoc.append((maxN, minN, maxN - minN))

# 끝값을 기준으로 오름차순 정렬
inLoc.sort()

d = int(sys.stdin.readline().strip())

result = 0
ckLen = []

# 끝값을 기준으로 범위내의 사람들의 수를 구함
for peopleLen in inLoc:

    # 만약 두 값의 차이가 철로선분보다 크다면 비교대상에서 제외
    if d < peopleLen[2]:
        continue
    
    elif not ckLen:
        # 초기값은 정렬필요없음
        ckLen.append(peopleLen[1])
    
    else:
        while True:
            # 만약 기존에 있던 사람 중 가장 시작값이 작은 사람이 새로운 범위에서 벗어난다면
            # 해당 사람은 범위 밖에 위치하기에 범위내 list에서 제외
            if not ckLen or ckLen[0] >= peopleLen[0] - d:
                break
            heapq.heappop(ckLen)
            
        # 시작값을 내림차순 정렬하는 heapq
        heapq.heappush(ckLen, peopleLen[1])
    
    # len(ckLen) == 해당 범위내에 위치하는 사람들의 수 
    result = max(result, len(ckLen))
            
print(result)        
    

