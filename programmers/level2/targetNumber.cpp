/*
 * Programmers 타겟 넘버
 * targetNumber.cpp
 * 2020.07.08
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> numbers, int target) {
    int answer = 0;
    queue<int> current, next, temp;
    next.push(numbers[0]);
    next.push(numbers[0]*(-1));
    for(int i=1; i<numbers.size(); i++){
        current = next;
        next = temp;
        while (!current.empty()){
            next.push(current.front()+numbers[i]);
            next.push(current.front()-numbers[i]);
            current.pop();
        }
    }
    while (!next.empty()){
        if(next.front() == target) answer ++;
        next.pop();
    }
    return answer;
}

int main(){
    int size, target;
    cin >> size;
    vector<int> arr(size);
    for(int i=0; i<size; i++){
        cin >> arr[i];
    }
    cin >> target;
    cout << solution(arr, target);
    return 0;
}
