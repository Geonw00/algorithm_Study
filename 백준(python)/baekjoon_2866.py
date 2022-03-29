# https://www.acmicpc.net/submit/2866
import sys

R, C = map(int, sys.stdin.readline().strip().split())

res = 0

# 열의 개수만큼 리스트 생성
textList = ['' for _ in range(C)]

for _ in range(R):
    textStr = str(sys.stdin.readline().strip())
    
    # 입력된 문자열을 열단위로 읽어서 문자열 리스트 생성
    for i in range(C):
        textList[i] += textStr[i]
         
while True:
    
    # 열기준 문자열에서 맨 처음에 들어온 행의 문자 제거
    for i in range(C):
        textList[i] = textList[i][1:]
    
    # set을 통해 중복 문자열이 있을 경우 삭제
    textSet = set(textList)

    # set의 길이가 줄어든 경우 문자열이 중복되었음을 의미
    # 문자열이 중복되었거나 더 이상 행이 없을 경우 반복문 종료
    if len(textSet) != C or textList[0] == '':
        break
    
    # 중복된 값이 없을 경우 count + 1 
    else: 
        res += 1

print(res)
        