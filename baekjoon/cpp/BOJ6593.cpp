/*
 * BOJ #6593 상범 빌딩
 * BOJ6593.cpp
 * 2020.03.18
 * github.com/choigone
 */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

int dx[6] = {1,-1,0,0,0,0};
int dy[6] = {0,0,-1,1,0,0};
int dz[6] = {0,0,0,0,1,-1};

class Point{
public:
    int x; int y; int z;
    Point(){}
    bool isOut(int xMax, int yMax, int zMax){
        if(x < 0 || y < 0 || z < 0) return true;
        else if(x >= xMax || y >= yMax || z >= zMax) return true;
        else return false;
    }
};

pair<bool,int> bfs(vector<vector<string>> building, int a, int b, int c, Point start, int n){
    int count = n;
    Point next;
    pair<bool,int> result;
    for(int i=0; i<6; i++){
        next.x = start.x+dx[i];
        next.y = start.y+dy[i];
        next.z = start.z+dz[i];
        if(!next.isOut(b,c,a)){
            if(building[next.z][next.x][next.y] == 'E'){
                return make_pair(true,count);
            }
            if(building[next.z][next.x][next.y] == '.'){
                building[next.z][next.x][next.y] = 'v';
                result = bfs(building, a, b, c, next, count+1);
                if(result.first == true){
                    return result;
                }
            }
        }
    }
    return make_pair(false,count);
}

int main(){
    int a, b, c;
    vector<vector<string>> building;
    Point start;
    vector<string> row;
    string line;
    while(1){
        cin >> a >> b >> c;
        if(a+b+c == 0) break;
        building.clear();
        for(int ia=0; ia<a; ia++){
            row.clear();
            for(int ib=0; ib<b; ib++){
                cin >> line;
                if(line.find("S") != string::npos){
                    start.x = ib;
                    start.y = line.find("S");
                    start.z = ia;
                }
                row.push_back(line);
            }
            building.push_back(row);
        }
        pair<bool,int> result = bfs(building, a, b, c, start, 0);
        if(!result.first) cout << "Trapped!" << endl;
        else cout << "Escaped in " << result.second+1 << " minute(s)." << endl;
    }
    return 0;
}
