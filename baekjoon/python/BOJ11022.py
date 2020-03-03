"""
baekjoon #11022 A+B - 8
BOJ11022.py
2020.03.03
최고운 github.com/choigone
"""

n = int(input())
for i in range(0,n):
    a, b = map(int, input().split())
    print(f"Case #{i+1}: {a} + {b} = {a+b}")
