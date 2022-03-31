# https://www.acmicpc.net/problem/1260

from collections import deque
import sys

N, M, V = map(int, sys.stdin.readline().strip().split())

# 편의를 위해 N+1 크기의 리스트
node = [[] for _ in range(N + 1)]

for _ in range(M):
    fNode, sNode = map(int, sys.stdin.readline().strip().split())
    
    # 간선은 두 정점을 연결하기 때문에 5 1 일 경우 5->1로 1->5로 이동가능
    node[fNode].append(sNode)
    node[sNode].append(fNode)

# 정점의 번호 오름차순정렬
for i in range(N + 1):
    node[i].sort()

resDfs = ''
# dfs 방문여부 체크
dfsCk = [False for _ in range(N + 1)]    
def dfs(start):
    global resDfs
    # 현재 노드 위치 방문체크
    dfsCk[start] = True
    
    # 마지막에 strip()안할 경우 입력단계에서 맨 앞의 공백제거
    if start == V:
        resDfs = str(start)
    else:
        resDfs += ' ' + str(start)
    
    for i in node[start]:
        # 연결된 노드 중 방문하지 않은 노드일 경우 방문진행
        if dfsCk[i] == False:
            dfs(i)

resBfs = ''
# bfs 방문여부 체크
bfsCk = [False for _ in range(N + 1)]  
resBfs = str(V)
def bfs(start):
    global resBfs
    # deque를 통해 queue 구현
    bfsque = deque([start])    
    bfsCk[start] = True

    while len(bfsque) != 0:
        # 현재 방문한 노드위치 
        next = bfsque.popleft()
        for i in node[next]:
            # 방문하지 않은 노드일 경우 방문예정 노드에 추가
            if not bfsCk[i]:
                bfsque.append(i)
                resBfs += ' ' + str(i)
                bfsCk[i] = True
        
dfs(V)
bfs(V)
print(resDfs)   
print(resBfs)    
    