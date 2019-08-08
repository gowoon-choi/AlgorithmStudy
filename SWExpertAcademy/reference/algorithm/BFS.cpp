#include <iostream>
#include <vector>
#include <queue>

using namespace std;

void bfs(vector<vector<int>>a, int *visit, int start){
    queue<int> q;
    q.push(start);
    visit[start-1] = 1;
    while(!q.empty()){
        cout << q.front() << " ";
        for(int i=0;i<a[q.front()-1].size();i++){
            if(visit[a[q.front()-1][i]-1] == 1){
                continue;
            }
            else{
                q.push(a[q.front()-1][i]);
                visit[a[q.front()-1][i]-1] = 1;
            }
        }
        q.pop();
    }
}

int main(){
    int testCase, count, start;
    int temp1,temp2;

    cin >> testCase;
    cin >> count >> start;

    vector<vector<int>> map(count);
    int *visit = new int[count];

    for(int i=0;i<testCase;i++){
        fill_n(visit,count,0);
        map.clear();
        map.resize(count);
        while(true){
            cin >> temp1 >> temp2;
            if(temp1 == -1 && temp2 == -1) break;
            map[temp1-1].push_back(temp2);
            map[temp2-1].push_back(temp1);
        }
        bfs(map,visit,start);
    }
    return 0;
}