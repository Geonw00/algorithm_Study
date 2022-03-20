# https://www.acmicpc.net/problem/5619

import sys

N = int(sys.stdin.readline().strip())
inputNum = []
for i in range(N):
    # 자연수의 크기를 기준으로 sort하기 위해 int형으로 입력값 변환
    inputNum.append(int(sys.stdin.readline().strip()))

inputNum.sort()
sortAddNum = []

# 세 번째로 작은 수는 입력값을 오름차순 정렬한 네번째 숫자까지의 계산으로 도출가능 
# 모든 결과값을 구한 뒤 sort시 메모리초과발생

# 만약 N이 3이라면 3번 index는 존재하지 않기때문에 index 에러발생
if N == 3:
    for firstPosition in range(3):
        
        for secondPosition in range(3):
        
            if firstPosition != secondPosition:
                # 해당 숫자들을 문자열로 더한 후 정렬을 위해 int형으로 변환하여 리스트에 저장
                sortAddNum.append(int(str(inputNum[firstPosition]) + str(inputNum[secondPosition])))

else: 
    for firstPosition in range(4):
    
        for secondPosition in range(4):
        
            if firstPosition != secondPosition:
                # 해당 숫자들을 문자열로 더한 후 정렬을 위해 int형으로 변환하여 리스트에 저장
                sortAddNum.append(int(str(inputNum[firstPosition]) + str(inputNum[secondPosition])))
            
sortAddNum.sort()

print(sortAddNum[2])


