# https://www.acmicpc.net/problem/2839

import sys

N = int(sys.stdin.readline().strip())

fiveCount = 0
threeCount = 0
# 정확하게 N킬로그램을 만드는 답들의 리스트
resBasket = []

# 배달할 설탕의 3, 5의 모든 개수 조합 찾기
for count in range((N // 3) + 1):
    threeCount = count
    fiveCount = (N - 3 * count) // 5
    
    if fiveCount * 5 + threeCount * 3 == N:
        resBasket.append(fiveCount + threeCount)

# 리스트에 아무것도 존재하지 않을 경우, 정확하게 N킬로그램에 부합하는 값이 없기때문에
# -1 반환 
if not resBasket:
    print(-1)
else:
    print(min(resBasket))