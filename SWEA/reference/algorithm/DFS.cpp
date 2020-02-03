#include <iostream>
#include <vector>

using namespace std;

void dfs(vector<vector<int>> a, int start, int *visit){
    cout << start << " ";
    visit[start-1] = 1;
    for(int i=0;i<a[start-1].size();i++){
        if(visit[a[start-1][i]-1] == 1){
            continue;
        }
        else{
            dfs(a,a[start-1][i],visit);
        }
    }
}

int main(){
    int testCase, count, start;
    int temp1, temp2;

    cin >> testCase;
    cin >> count >> start;

    vector<vector<int>> map(count);
    int *visit = new int[count];
    fill_n(visit,count,0);

    while(true){
        cin >> temp1 >> temp2;
        if(temp1 == -1 && temp2 == -1) break;
        map[temp1-1].push_back(temp2);
        map[temp2-1].push_back(temp1);
    }
    dfs(map,start,visit);
    return 0;
}