"""
baekjoon #1110 더하기 사이클
BOJ1110.py
2020.03.17
최고운 github.com/choigone
"""

n = result = int(input())
count = 0
while True:
    a = result // 10
    b = result % 10
    result = b * 10 + (a + b) % 10
    count += 1
    if n==result: break
print(count)
