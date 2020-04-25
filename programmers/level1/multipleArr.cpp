/*
 * Programmers 나누어 떨어지는 숫자 배열
 * multipleArr.cpp
 * 2020.04.25
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor){
    vector<int> answer;
    for(int i=0; i<arr.size(); i++) {
        if(arr[i]%divisor == 0) answer.push_back(arr[i]);
    }
    if(answer.size() == 0) answer.push_back(-1);
    else sort(answer.begin(),answer.end());
    return answer;
}

int main(){
    int n, divisor;
    cin >> n >> divisor;
    vector<int> arr(n);
    for(int i=0; i<n; i++) cin >> arr[i];
    arr = solution(arr, divisor);
    for(int i=0; i<arr.size(); i++) cout << arr[i] << " ";
    return 0;
}
