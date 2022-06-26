# https://www.acmicpc.net/problem/1316

import sys

N = int(sys.stdin.readline().strip())
res = 0

for _ in range(N):
    group = []
    word = sys.stdin.readline().strip()
    
    # deque를 이용하면 nowWord와 group을 따로 둘 필요가 없을 것으로 예상
    nowWord = word[0]
    group.append(word[0])
    check = True
    
    # 현재 문자가 나란히 붙어있지 않으며 과거에 등장한 적이 있다면 
    # 그룹단어가 아님
    for alpha in word:
        if alpha not in group:
            nowWord = alpha
            group.append(alpha)
        elif alpha in group and nowWord != alpha:
            check = False 
            break
    
    if check:
        res += 1

print(res)