"""
baekjoon #2523 별 찍기 -13
BOJ2523.py
2020.03.19
최고운 github.com/choigone
"""

n = int(input())
for i in range(0,n):
    print("*"*(i+1),end='\n')
for i in range(n-1,0,-1):
    print("*"*i,end='\n')
