"""
baekjoon #15552 빠른 A+B
BOJ15552.py
2020.02.25
최고운 github.com/choigone
"""

import sys

n = sys.stdin.readline()
for i in range(0,int(n)):
    a, b = sys.stdin.readline().split()
    print(int(a)+int(b))
