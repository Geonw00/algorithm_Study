# https://www.acmicpc.net/problem/17478

import sys

N = int(sys.stdin.readline().strip())

print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.")

def recur(count, leftStr):
    # 재귀의 깊이에 따라서 앞에 붙는 문자열 변화
    if count == 0:
        leftStr = ""
    else:
        leftStr += "____"
        
    count += 1
    
    # N만큼의 재귀했을 시 종료
    if count > N+1:
        return
    elif count == N+1:
        print(f'''{leftStr}"재귀함수가 뭔가요?"
{leftStr}"재귀함수는 자기 자신을 호출하는 함수라네"''')
        print(f"{leftStr}라고 답변하였지.")
    else:
        print(f'''{leftStr}"재귀함수가 뭔가요?"
{leftStr}"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
{leftStr}마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
{leftStr}그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."''')
        # 재귀
        recur(count, leftStr)
        print(f"{leftStr}라고 답변하였지.")
        
recur(0, "")