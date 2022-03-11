# https://www.acmicpc.net/submit/2840/40282321

import sys

N, K = map(int, sys.stdin.readline().split())

# N 크기 리스트에 ''으로 모두 채움
li = ['' for i in range(N)]    
index = 0
result = ''
 
for i in range(int(K)):
    plusindex, alpa = map(str, sys.stdin.readline().split())
    plusindex = int(plusindex)
    # 전체 인덱스를 몇번이나 순환하였는 지 계산
    inNum = int((index + plusindex)/N)
    
    # 현재 위치한 인덱스 계산
    index = index + plusindex - (N * inNum)
    
    # 같은 인덱스에 다른 문자열이 올 수 없으므로 '!' 반환
    if li[index] != '' and li[index] != alpa:
        result = '!'
    else:
        li[index] = alpa
        
if result == '!':
    print(result)
    
else:
    for i in range(N):
        # 마지막 문자열을 기준으로 문자열 반환
        if index - i < 0:
            ckIndex = index - i + N
        else:
            ckIndex = index - i
        
        # 인덱스에 해당하는 문자열이 없을 경우 '?'로 표현
        if li[ckIndex] == '':
            result += '?'
        # 같은 문자열이 두 번 사용 x
        elif li[ckIndex] in result:
            result = '!'
            break
        else:
            result = result + li[ckIndex]
    print(result)