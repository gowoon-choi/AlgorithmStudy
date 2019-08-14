/*
 * swExpert #8104
 * makeGroup.cpp
 * 2019.08.05
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>

using namespace std;

int main(){
    int testCase;
    int n,k;
    int result;
    vector<int> answer;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> n >> k;
        result = 0;
        if(n!=k){
            if(n%2==0){
                result = 1+(n*k);
                result = result * (n/2);
            }
            else{
                result = 1 + ((n*k)-k+1);
                result = (result * (n/2)) + (result/2);
            }
            answer.push_back(result);
        }
        cout << "#" << i+1;
        if(n==k){
            for(int j=0;j<k;j++) cout << " " << j+1;
        }
        else{
            for(int j=0;j<k;j++) cout << " " << answer[i];
        }
    }
    return 0;
}