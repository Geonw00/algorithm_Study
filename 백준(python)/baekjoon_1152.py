# https://www.acmicpc.net/problem/1152

import sys

# 입력값 좌우의 공백 제거한 형태로 " "를 기준으로 분할 후 리스트
word = list(map(str, sys.stdin.readline().strip().split()))

# 단어의 개수는 리스트의 크기와 동일 
print(len(word))