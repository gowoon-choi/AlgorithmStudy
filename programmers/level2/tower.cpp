/*
 * Programmers 탑
 * tower.cpp
 * 2020.05.11
 * github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

vector<int> solution(vector<int> heights){
    vector<int> answer(heights.size(),0);
    int num;
    for(int i=heights.size()-1; i>0; i--){
        num = 0;
        for(int j=i-1; j>=0; j--){
            if(heights[j] > heights[i]){
                num = j+1;
                break;
            }
        }
        answer[i] = num;
    }
    return answer;
}

int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int i=0; i<n; i++) cin >> arr[i];
    arr = solution(arr);
    for(int i=0; i<arr.size(); i++) cout << arr[i] << " ";
    return 0;
}
