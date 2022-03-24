# https://www.acmicpc.net/problem/5568
import sys

n = int(sys.stdin.readline().strip())
k = int(sys.stdin.readline().strip())
inList = []
for _ in range(n):
    inNum = str(sys.stdin.readline().strip())
    inList.append([inNum, 0])
    
b = set()
hap = ''

# 재귀함수를 통해 가진 모든 카드 수에서 k개를 뽑았을 때의 모든 경우의 수 도출
def addN(count, stringN):
    startStr = stringN
    if count == 0:
        # set을 사용해 중복숫자 제거
        b.add(stringN)
        return

    # 카드 하나 뽑을 때마다 count -1
    count -= 1
    for i in range(len(inList)):
        if inList[i][1] != 1:
            inList[i][1] = 1
            stringN += inList[i][0]
            addN(count, stringN)
            # 결과값 저장 후 이전 문자열로 초기화
            stringN = startStr
            inList[i][1] = 0
             
addN(k, hap)
print(len(b))
