"""
baekjoon #5543 상근날드
BOJ5543.py
2020.03.04
최고운 github.com/choigone
"""

burger = []
drink = []
for i in range(0,3):
    burger.append(int(input()))
for i in range(0,2):
    drink.append(int(input()))
print(min(burger)+min(drink)-50)
