"""
baekjoon #10817 세 수
BOJ10817.py
2020.02.21
최고운 github.com/choigone
"""

a, b, c = map(int, input().split())
if a > b :
    if a < c :
        print(a)
    else:
        if b < c : print(c)
        else : print(b)
else :
    if b < c :
        print(b)
    else:
        if a < c : print(c)
        else : print(a)
