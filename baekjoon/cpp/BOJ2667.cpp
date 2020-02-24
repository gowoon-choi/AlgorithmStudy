/*
 * BOJ #2667 단지번호붙이기
 * BOJ2667.cpp
 * 2020.02.22
 * github.com/choigone
 */

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int dx[4] = {0, -1, 0, 1};
int dy[4] = {1, 0, -1, 0};

void search(vector<vector<int>> arr, queue<pair<int,int>> list, int n){
    vector<int> result;
    while(!list.empty()){
        int count = 0;
        int curX = list.front().first;
        int curY = list.front().second;
        if(arr[curX][curY] == -1){
            list.pop();
            continue;
        }
        queue<pair<int,int>> area;
        area.push(make_pair(curX,curY));
        arr[curX][curY] = -1;
        count++;
        while(!area.empty()){
            for(int i=0; i<4; i++){
                int nextX = area.front().first + dx[i];
                int nextY = area.front().second + dy[i];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n){
                    continue;
                }
                else{
                    if(arr[nextX][nextY] == 1){
                        area.push(make_pair(nextX,nextY));
                        arr[nextX][nextY] = -1;
                        count++;
                    }
                }
            }
            area.pop();
        }
        result.push_back(count);
        list.pop();
    }
    sort(result.begin(), result.end());
    cout << result.size() << endl;
    for(int i=0; i<result.size(); i++) cout << result[i] << endl;
}

int main(){
    int n;
    cin >> n;
    queue<pair<int,int>> list;
    vector<vector<int>> arr(n);
    string temp;
    for(int i=0; i<n; i++){
        cin >> temp;
        for(int j=0; j<n; j++){
            arr[i].push_back(temp[j]-48);
            if(temp[j] == 49) list.push(make_pair(i,j));
        }
    }
    search(arr,list,n);
    return 0;
}
