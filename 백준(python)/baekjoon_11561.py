# https://www.acmicpc.net/problem/11561
import sys

# 1 ~ n까지 더하면 bridgeCount
# 그러므로 n * (n + 1) / 2 = bridgeCount가 성립해야함
# bridgeCount가 2 일경우
# n은 1 < n < 2이 되므로 1이 result값이 된다. 

T = int(sys.stdin.readline().strip())

res = []

for i in range(T):
    bridgeCount = int(sys.stdin.readline().strip())
    
    count = 0
    start = 1
    # bridgeCount의 최대는 10의 16승이므로 정답인 n의 수는 bridgeCount보다 낮음
    end = 10 ** 16
    
    # 이분탐색
    while start <= end:
        mid = int((start + end) / 2)
        
        ckN = (mid * (mid + 1)) / 2

        # ckN <= bridgeCount은 mid <= n을 의미
        # 그러므로 최대의 n을 도출하기 위해서 mid는 더 큰 숫자이거나 n이므로 
        # count에 mid 값을 넣고 mid + 1부터 탐색을 지속한다.
        if ckN <= bridgeCount:
            count = mid
            start = mid + 1
        
        else:
            end = mid - 1
            
    res.append(count)

for i in res:
    print(i)

 