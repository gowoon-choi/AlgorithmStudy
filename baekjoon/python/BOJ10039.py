"""
baekjoon #10039 평균 점수
BOJ10039.py
2020.03.19
최고운 github.com/choigone
"""

sum = 0
for i in range(0,5):
    n = int(input())
    if(n < 40): n = 40
    sum = sum + n
print(int(sum/5))
