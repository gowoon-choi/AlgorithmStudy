/*
 * programmers 정수 삼각형
 * integerTriangle.cpp
 * 2020.10.08
 * github.com/gowoon-choi
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> triangle) {
    vector<int> current, next;
    next.push_back(triangle[0][0]);
    for(int i=1; i<triangle.size(); i++){
        current = next;
        next.clear();
        for(int j=0; j<=i; j++){
            if(j==0) next.push_back(current[j] + triangle[i][j]);
            else if(j==i) next.push_back(current[j-1] + triangle[i][j]);
            else{
                if(current[j-1] > current[j]) next.push_back(current[j-1] + triangle[i][j]);
                else next.push_back(current[j] + triangle[i][j]);
            }
        }
    }
    sort(next.begin(), next.end());
    return next[next.size()-1];
}

int main(){
    int n;
    cin >> n;
    vector<vector<int>> triangle(n);
    for(int i=0; i<n; i++){
        vector<int> temp(i+1);
        for(int j=0; j<=i; j++){
            cin >> temp[j];
        }
        triangle[i] = temp;
    }
    cout << solution(triangle);
    return 0;
}
