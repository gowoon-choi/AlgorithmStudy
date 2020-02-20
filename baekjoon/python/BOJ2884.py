"""
baekjoon #2884 알람시계
BOJ2884.py
2020.02.20
최고운 github.com/choigone
"""

h, m = map(int, input().split())
if((m-45) < 0):
    if(h == 0):
        print(f"{23} {60+(m-45)}")
    else:
        print(f"{(h-1)} {60+(m-45)}")
else:
    print(f"{h} {m-45}")
