// 백준 채점 시간초과

#include <iostream>
using namespace std;

int main(){
    string str;
    cin >> str;

    string temp;
    for(int i = str.length()-2; i > 0; i--){
        temp = str.substr(0,i);
        if(str.substr(str.length()-i,i) == temp){
            for(int j=0;j<(str.length()-2)-i;j++){
                if(str.substr(j+1,i) == temp){
                    cout << temp;
                    return 0;
                }
            }
        }
    }
    cout << "-1";
    return 0;
}