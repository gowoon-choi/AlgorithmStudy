 """
baekjoon #2439 별 찍기 - 2
BOJ2439.py
2020.03.07
최고운 github.com/choigone
"""

n = int(input())
for i in range(1,n+1):
    print(' ' * (n-i) + '*' * i)
