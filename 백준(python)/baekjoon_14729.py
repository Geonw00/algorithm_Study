# https://www.acmicpc.net/problem/14729
import sys
from queue import PriorityQueue

# 1번 방법
N = int(sys.stdin.readline())
# python의 경우 put()을 통해 데이터를 넣고, get()을 통해 pop의 기능을 수행한다.
prQue = PriorityQueue()

for i in range(N):
    grade = float(sys.stdin.readline().strip())
    prQue.put(grade)

for i in range(7):
    print('%0.3f' %prQue.get())
    
# ==========================================================================
# 2번 방법
# PriorityQueue()를 사용한 경우 효율성 떨어짐, list 사용
N = int(sys.stdin.readline())
li = []

for i in range(N):
    grade = float(sys.stdin.readline().strip())
    li.append(grade)

li.sort()

for i in range(7):
    print('%0.3f' %li[i])