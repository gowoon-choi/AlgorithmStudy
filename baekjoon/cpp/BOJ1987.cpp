/*
 * baekjoon #1987
 * BOJ1987.cpp
 * 2019.10.12
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// TODO 방문해제..!!

int visited[26] = {false};

vector<int> result;

// e w s n
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

int width, height;

// -65
void dfs(vector<vector<char>> board, int curX, int curY, int count){
    if(visited[board[curY][curX] - 65] == false){
        visited[board[curY][curX] - 65] = true;

        for(int i=0; i<4; i++){
            int x = curX + dx[i];
            int y = curY + dy[i];

            // 보드를 벗어나지 않으면
            if(x >= 0 && x < width && y >= 0 && y < height){
                dfs(board,x,y,count+1);
            }
        }
    }
    else{
        result.push_back(count);
    }
}

int main(){
    cin >> height >> width;

    vector<vector<char>> board(height);
    string temp;
    for(int i=0; i<height; i++){
        cin >> temp;
        for(int j=0; j<width; j++){
            board[i].push_back(temp[j]);
        }
    }

    dfs(board,0,0,0);
    sort(result.begin(),result.end());
    cout << result[result.size()-1];

    return 0;
}