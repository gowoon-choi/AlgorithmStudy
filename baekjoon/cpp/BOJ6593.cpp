/*
 * BOJ #6593 상범 빌딩
 * BOJ6593.cpp
 * 2020.03.18
 * github.com/choigone
 */

#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;

int dx[6] = {1,-1,0,0,0,0};
int dy[6] = {0,0,-1,1,0,0};
int dz[6] = {0,0,0,0,1,-1};

class Point{
public:
    int x; int y; int z; int d;
    Point(){}
    Point(int x, int y, int z, int d){
        this->x = x;
        this->y = y;
        this->z = z;
        this->d = d;
    }
    bool isOut(int xMax, int yMax, int zMax){
        if(x < 0 || y < 0 || z < 0) return true;
        else if(x >= xMax || y >= yMax || z >= zMax) return true;
        else return false;
    }
};

int bfs(vector<vector<string>> building, int a, int b, int c, Point start){
    start.d = 0;
    queue<Point> q;
    q.push(start);
    Point cur, next;
    while(!q.empty()){
        cur = q.front();
        for(int i=0; i<6; i++){
            next = Point(cur.x+dx[i],cur.y+dy[i],cur.z+dz[i],cur.d+1);
            if(!next.isOut(b,c,a)){
                if(building[next.z][next.x][next.y] == 'E'){
                    return next.d;
                }
                if(building[next.z][next.x][next.y] == '.'){
                    q.push(next);
                    building[next.z][next.x][next.y] = 'v';
                }
            }
        }
        q.pop();
    }
    return -1;
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
        for(int ia=0; ia<a; ia++) {
            row.clear();
            for (int ib = 0; ib < b; ib++) {
                cin >> line;
                if (line.find("S") != string::npos) {
                    start.x = ib;
                    start.y = line.find("S");
                    start.z = ia;
                }
                row.push_back(line);
            }
            building.push_back(row);
        }
        int result = bfs(building, a, b, c, start);
        if(result == -1) cout << "Trapped!" << endl;
        else cout << "Escaped in " << result << " minute(s)." << endl;
    }
    return 0;
}
