/*
 * BOJ #7576 토마토
 * BOJ7576.cpp
 * 2020.02.19
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int solution(vector<vector<int>> tomatoBox, queue<pair<int,int>> good, int nonTomato){
    if(good.size()+nonTomato == tomatoBox[0].size()*tomatoBox.size()) return 0;
    int result = 0;
    int result_idx = good.size();
    int fail_index = 0;
    while(!good.empty()){
        for(int d=0; d<4; d++){
            if(good.front().first+dx[d] < 0 || good.front().first+dx[d] >= tomatoBox.size() ||  good.front().second+dy[d] < 0 || good.front().second+dy[d] >= tomatoBox[0].size()) continue;
            else{
                if(tomatoBox[good.front().first+dx[d]][good.front().second+dy[d]] != 0) continue;
                else{
                    tomatoBox[good.front().first+dx[d]][good.front().second+dy[d]] = 1;
                    good.push(make_pair(good.front().first+dx[d], good.front().second+dy[d]));
                }
            }
        }
        good.pop();
        fail_index++;
        result_idx--;
        if(result_idx == 0 && good.size()!=0){
            result_idx = good.size();
            result++;
        }
    }
    if(fail_index+nonTomato != tomatoBox[0].size()*tomatoBox.size()) return -1;
    return result;
}

int main(){
    int m, n;
    cin >> m >> n;
    queue<pair<int,int>> good;
    vector<vector<int>> tomatoBox(n);
    vector<int> line(m);
    int tomato;
    int nonTomato=0;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin >> tomato;
            if(tomato == 1) good.push(make_pair(i,j));
            else if(tomato == -1) nonTomato++;
            line[j] = tomato;
        }
        tomatoBox[i] = line;
    }
    cout << solution(tomatoBox, good, nonTomato);
    return 0;
}
