"""
baekjoon #10430 나머지
BOJ10430.py
2020.02.09
최고운 github.com/choigone
"""

A, B, C = map(int, input().split())
print((A+B) % C)
print(((A % C)+(B % C)) % C)
print((A*B) % C)
print(((A % C)*(B % C)) % C)
