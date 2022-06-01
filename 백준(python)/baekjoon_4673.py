# https://www.acmicpc.net/problem/4673

selfList = []
for num in range(1, 10001):
    strNum = str(num)
    resNum = num
    
    for idxNum in range(len(strNum)):
        resNum += int(strNum[idxNum])
    
    # num과 num의 각 자릿수를 더한 값이 10000이하일 경우 셀프 넘버 리스트에 추가
    if resNum <= 10000:
        selfList.append(resNum)

# 셀프 넘버 리스트에 없는 숫자는 셀프 넘버가 없음을 의미
for result in range(1, 10001):
    if result not in selfList:
        print(result)