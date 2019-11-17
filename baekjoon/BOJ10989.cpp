/*
 * baekjoon #10898 수 정렬하기3
 * BO10989.cpp
 * 2019.11.16
 * 최고운 github.com/choigone
 */

#include <iostream>

using namespace std;

int main(){
    int n;
    scanf("%d",&n);

    int arr[N] = {0,};
    int temp;
    for(int i=0; i<n; i++){
        scanf("%d",&temp);
        arr[temp]++;
    }

    for(int i=0; i<N; i++){
        if(arr[N]!=0){
            for(int j=0; j<arr[i]; j++){
                printf("%d\n",i);
            }
        }
    }

    return 0;
}
