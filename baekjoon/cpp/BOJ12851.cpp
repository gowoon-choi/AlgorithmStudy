/*
 * BOJ #12851 숨바꼭질2
 * BOJ12851.cpp
 * 2020.04.20
 * github.com/choigone
 */

#include <iostream>
#include <queue>

using namespace std;

#define MAX 100000

void bfs(int n, int k){
    int visited[MAX+1] = {0,};
    queue<int> current;
    queue<int> next;
    int time = 0;
    int count = 0;
    next.push(n);
    int branch[3];
    int now;
    bool isContinue = true;
    if(n==k){
        isContinue = false;
        count++;
    }
    while(isContinue){
        current = next;
        next = {}; // queue clear
        time++;
        while(!current.empty()){
            now = current.front();
            current.pop();
            branch[0] = now-1;
            branch[1] = now+1;
            branch[2] = now*2;
            visited[now] = 1;
            for(int i=0; i<3; i++){
                if(branch[i] < 0 || branch[i] > MAX){
                    continue;
                }
                else{
                    if(visited[branch[i]] == 0){
                        if(branch[i] == k){
                            count++;
                            isContinue = false;
                            continue;
                        }
                        next.push(branch[i]);
                    }
                }
            }
        }
    }
    cout << time << "\n" << count;
}

int main() {
    int n, k;
    cin >> n >> k;
    bfs(n,k);
    return 0;
}
