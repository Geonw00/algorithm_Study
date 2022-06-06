# https://www.acmicpc.net/problem/2309

import sys

lenList = []

for _ in range(9):
    dwarfLen = int(sys.stdin.readline().strip())
    lenList.append(dwarfLen)

for i in range(9):
    for j in range(i+1, 9):
        # 난쟁이 두명을 제외하고 키가 100이 되면 종료
        if sum(lenList) - (lenList[i] + lenList[j]) == 100:
            lenList.remove(lenList[j])
            lenList.remove(lenList[i])
            break
    
    # 이중 for문을 사용했기 때문에 break 두번 사용 필요
    if len(lenList) != 9:
        break

# 난쟁이 키 순으로 오름차순 정렬
lenList.sort()
for result in lenList:
    print(result)