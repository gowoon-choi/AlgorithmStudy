"""
baekjoon #2753 윤년
BOJ2753.py
2020.02.19
최고운 github.com/choigone
"""

year = int(input())
if year % 4 == 0 and (year % 100 != 0 or year % 400 == 0): print(1)
else: print(0)
