/*
 * Programmers 더 맵게
 * moreSpicy.cpp
 * 2020.05.12
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int>> q(scoville.begin(), scoville.end());
    int temp1, temp2;
    while(q.top() < K){
        if(q.size() ==  1){
            answer = -1;
            break;
        }
        temp1 = q.top();
        q.pop();
        temp2 = q.top();
        q.pop();
        q.push(temp1+temp2*2);
        answer++;
    }
    return answer;
}

int main(){
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }
    cout << solution(arr, k);
    return 0;
}
