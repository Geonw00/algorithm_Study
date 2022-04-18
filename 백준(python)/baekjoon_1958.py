# https://www.acmicpc.net/problem/1958

import sys

# 문제의 LCS는 Longest Common Subsequence 임을 인지 ==> 수열
strList = []
for _ in range(3):
    inStr = sys.stdin.readline().strip()
    strList.append(inStr)

# 3개의 문자열 비교가 필요하므로 3차원 배열 생성 (x축 == 0번 인덱스 문자열)
LCS = [[[0] * (len(strList[2]) + 1) for _ in range(len(strList[1]) + 1)] for _ in range(len(strList[0]) + 1)]

# 
for x in range(1, (len(strList[0]) + 1)):
    for y in range(1, (len(strList[1]) + 1)):
        for z in range(1, (len(strList[2]) + 1)):
            # print(x ,' ', y ,' ', z)
            
            # 만약 3개의 문자열의 공통 부분 수열이 존재할 시
            # 해당 문자까지의 최장 공통 부분 수열의 길이는 앞의 문자까지의 최장 공통 부분 수열 길이 + 1
            if strList[0][x-1] == strList[1][y-1] and strList[1][y-1] == strList[2][z-1]:
                LCS[x][y][z] = LCS[x-1][y-1][z-1] + 1
            
            # 공통 부분 수열이 존재하지 않을 시, 
            # 해당 문자이전의 공통 부분 수열의 길이 유지
            else:
                LCS[x][y][z] = max(LCS[x-1][y][z], LCS[x][y-1][z], LCS[x][y][z-1])

# 최장 공통 부분 수열의 길이 탐색
res = 0
for x in range(len(LCS)):
    for y in range(len(LCS[x])):
        for z in range(len(LCS[x][y])):
            res = max(res, LCS[x][y][z])

print(res)