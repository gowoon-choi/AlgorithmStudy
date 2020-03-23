"""
baekjoon #2446 별 찍기 - 9
BOJ2446.py
2020.03.23
최고운 github.com/choigone
"""

n = int(input())
for i in range(0,n):
    print(" "*i + "*"*((n-i)*2-1))
for i in range(1,n):
    print(" "*(n-i-1) + "*"*(i*2+1))
