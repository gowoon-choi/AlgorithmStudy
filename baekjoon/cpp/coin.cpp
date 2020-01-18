#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int min(int array[],int size){
    int result = 100000;
    for(int i=0;i<size;i++){
        if(array[i]!=-1 && array[i]<result) result = array[i];
    }
    return result;
}

int main(){
    int num, result, temp;
    cin >> num >> result;
    vector<int> coin;
    for(int i=0;i<num;i++){
        cin >> temp;
        coin.push_back(temp);
    }
    sort(coin.begin(),coin.end());
    coin.erase(unique(coin.begin(),coin.end()),coin.end());

    int temp2;
    int *dp = new int[result+1];
    int *target = new int[num];
    dp[0] = 0;
    for(int i=1;i<=result;i++){
        for(int j=0;j<num;j++){
            if(coin[j]<=i ){
                target[j] = dp[i-coin[j]];
            }
            else{
                target[j] = -1;
            }
        }
        temp2 = min(target,num);
        if(temp2 == 100000){
            dp[i] = -1;
        }
        else{
            dp[i] = temp2+1;
        }
    }
    cout << dp[result];
    return 0;
}