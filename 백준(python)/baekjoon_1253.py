# https://www.acmicpc.net/problem/1253
import sys

N = int(sys.stdin.readline().strip())

inNums = list(map(int,sys.stdin.readline().strip().split()))
res = 0

# 리스트를 오름차순 정렬
inNums.sort()

# 입력된 숫자 하나를 기준으로 다른 리스트내 숫자들의 합이 기준 숫자가 나오는지 확인
for good in range(len(inNums)):
    left = 0
    right = len(inNums) - 1
    goodN = inNums[good]
    
    # 이분탐색 사용
    while left < right:
        # 자신은 제외
        if good == left:
            left += 1
            continue
            
        elif good == right:
            right -= 1
            continue
        
        sumN = inNums[left] + inNums[right]
        
        if sumN == goodN:
            res += 1
            break
        
        # 합이 기준숫자보다 작을 경우 최솟값을 한단계 상승시킨다.
        elif sumN < goodN:
            left += 1
        
        # 합이 기준숫자보다 클 경우 최댓값을 한단계 하락시킨다.
        else:
            right -= 1

print(res)