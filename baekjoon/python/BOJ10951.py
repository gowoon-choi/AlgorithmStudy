"""
baekjoon #10951 A+B - 4
BOJ10951.py
2020.03.10
최고운 github.com/choigone
"""

#method1
import sys

for line in sys.stdin:
    a, b = map(int, line.split())
    print(a+b)

#method2
while True:
    try:
        a, b = map(int, input().split())
        print(a+b)
    except:
        break
