"""
baekjoon #10871 X 보다 작은 수
BOJ10871.py
2020.03.07
최고운 github.com/choigone
"""

n, target = map(int,input().split())
nums = map(int, input().split())
for i in list(nums):
    if i < target:
        print(i, end=' ')
