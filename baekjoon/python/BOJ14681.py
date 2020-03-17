"""
baekjoon #14681 사분면 고르기
BOJ14681.py
2020.03.17
최고운 github.com/choigone
"""

x = int(input())
y = int(input())
result = 1
if y < 0: result += 2
if x*y < 0: result += 1
print(result)
