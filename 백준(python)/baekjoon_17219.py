# https://www.acmicpc.net/problem/17219
import sys

N, M = map(int, sys.stdin.readline().strip().split())
res = []
memo = {}

for _ in range(N):
    K, V = map(str, sys.stdin.readline().strip().split())
    # dict에 site명을 key값으로 비밀번호를 value값으로 저장
    memo[K]= V

for _ in range(M):
    site = str(sys.stdin.readline().strip())
    
    # 사이트명을 통해 비밀번호 조회
    res.append(memo.get(site))
    
for ans in res:
    print(ans)
