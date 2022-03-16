# https://www.acmicpc.net/problem/1918

import sys
import re

inMath = sys.stdin.readline().strip()
res = ''
cal = []
# ord('+'), ord('-'), ord('/'), ord('*')
# 43, 45, 47, 42로 사칙연산 우선순위 판단 힘듬
# 딕셔너리를 통해서 우선순위 지정 1순위, 2순위
prior = {'+': 2, '-': 2, '*': 1, '/': 1 }

for i in inMath:

    # 문자열이 알파벳 대문자일 경우 결과문자열에 입력
    if re.match('[A-Z]', i):
        res += i
    
    elif i == '(':
        cal.append(i)
    
    # 문자열이 닫는 괄호일 경우 괄호 안의 연산이 먼저 이루어지기 때문에
    # 여는 괄호가 나올때까지의 연산자를 결과문자열에 입력 
    elif i == ')':
        while True:
            if cal[len(cal)-1] == '(':
                cal.pop()
                break
            else: 
                res += cal.pop()
                
    else:
        # 사칙연산 중 곱셈과 나눗셈의 우선순위가 높기 때문에 
        # 입력 연산자가 덧셈이나 뺄셈일 경우 앞쪽에서 이루어지는 연산의 우선순위가 더 높다면
        # 해당 연산이 먼저 이루어져야하기때문에 
        # 앞쪽에 위치한 모든 연산 선행
        # 여는 괄호가 존재할 경우 그 범위 내의 연산만을 선행
        while True:
            if len(cal) == 0 or cal[len(cal)-1] == '(' or prior[cal[len(cal)-1]] > prior[i]:
                cal.append(i)
                break
            
            else:
                res += cal.pop()
                
# 마지막 남은 연산자 결과문자열에 입력
while len(cal) != 0:
    res += cal.pop()

print(res)
        