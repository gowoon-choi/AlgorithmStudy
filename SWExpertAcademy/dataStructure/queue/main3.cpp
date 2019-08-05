/*
 * queue 구현 using library
 */

#include <iostream>
#include <queue>

using namespace std;

int main(){
    queue<int> a;
    int testCase, size, value;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> size;
        for(int j=0;j<size;j++){
            cin >> value;
            a.push(value);
        }
        for(int j=0;j<size;j++){
            cout << a.front() << " ";
            a.pop();
        }
        cout << endl;
    }
    return 0;
}