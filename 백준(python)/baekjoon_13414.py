# https://www.acmicpc.net/problem/13414
import sys

K, L = map(int, sys.stdin.readline().strip().split())

ckApplydup = {}

for i in range(L):
    studentN = str(sys.stdin.readline().strip())
    
    # 여러번 신청할 시 마지막 신청 값 순위가 기준이 됨
    # key는 학번으로 value는 순위로 저장
    ckApplydup[studentN] = i

# dict의 value값 기준으로 sort
sortApply = sorted(ckApplydup.items(),  key= lambda x: x[1])

# 수강 가능인원까지 선착순 K명 도출
for i in sortApply[:K]:
    print(i[0])