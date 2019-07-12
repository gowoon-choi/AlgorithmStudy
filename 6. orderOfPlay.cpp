#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int func(vector<int> a, vector<int> b){
    int result = 0;
    int flag = 0;
    sort(a.begin(),a.end());
    sort(b.begin(),b.end());
    for(int i=0;i<a.size();i++){
        for(int j=0;j<b.size();j++){
            if(a[i]<=b[j]){
                result++;
                b.erase(b.begin()+j);
                flag = 1;
                break;
            }
        }
        if(flag == 0) b.erase(b.begin());
        flag = 0;
    }
    return result;
}

int main() {
    int cases, player, temp;
    cin >> cases;
    vector<int> ourTeam, russiaTeam, result;
    for(int i=0;i<cases;i++){
        cin >> player;
        for(int j=0;j<player;j++){
            cin >> temp;
            russiaTeam.push_back(temp);
        }
        for(int j=0;j<player;j++){
            cin >> temp;
            ourTeam.push_back(temp);
        }
        result.push_back(func(russiaTeam, ourTeam));
        russiaTeam.clear();
        ourTeam.clear();
    }
    for(int i=0;i<cases;i++) cout << result[i] << endl;
    return 0;
}