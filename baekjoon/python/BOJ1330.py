"""
baekjoon #1330 두 수 비교하기
BOJ1330.py
2020.02.17
최고운 github.com/choigone
"""

num1, num2 = map(int, input().split())
if num1 > num2:
    print('>')
elif num1 == num2:
    print('==')
else:
    print('<')
