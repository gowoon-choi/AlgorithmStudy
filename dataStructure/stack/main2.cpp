/*
 * stack library 사용
 */

#include <iostream>
#include <stack>

using namespace std;

int main(){
    stack<int> a;
    int testCase, size, value;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> size;
        for(int j=0;j<size;j++){
            cin >> value;
            a.push(value);
        }
        for(int j=0;j<size;j++){
            cout << a.top() << " ";
            a.pop();
        }
        cout << endl;
    }
    return 0;
}