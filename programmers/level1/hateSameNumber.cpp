/*
 * programmers 같은 숫자는 싫어
 * hateSameNumber.cpp
 * 2020.03.19
 * github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr){
    arr.erase(unique(arr.begin(), arr.end()),arr.end());
    return arr;
}

int main(){
    int n;
    cin >> n;
    vector<int> arr;
    int temp;
    for(int i=0; i<n; i++){
        cin >> temp;
        arr.push_back(temp);
    }
    vector<int> result = solution(arr);
    for(int i=0; i<result.size(); i++){
        cout << result[i] << " ";
    }
    return 0;
}
