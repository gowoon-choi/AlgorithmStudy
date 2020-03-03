"""
baekjoon #11021 A+B - 7
BOJ11021.py
2020.03.03
최고운 github.com/choigone
"""

n = int(input())
for i in range(0,n):
    a, b = map(int,input().split())
    print(f"Case #{i+1}: {a+b}")
    # print(f"Case #{i+1}: {sum(map(int,input().split()))}")
