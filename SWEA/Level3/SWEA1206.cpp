/*
 * SWEA #1206 view
 * SWEA1206.cpp
 * 2020.03.05
 * github.com/choigone
 */

#include <iostream>
#include <vector>

#define MAX 255

using namespace std;

int main(){
    int testCase = 10; // 10
    for(int i=0; i<testCase; i++){
        int size;
        cin >> size;
        int **building = new int*[size];
        int temp;
        int max = 0;
        for(int j=0; j<size; j++){
            cin >> temp;
            int *arr = new int[MAX];
            fill_n(arr,MAX,0);
            fill_n(arr,temp,1);
            building[j] = arr;
            if(max < temp) max = temp;
        }
        int count = 0;
        for(int j=max-1; j>=0; j--){
            for(int k=0; k<size; k++){
                if(building[k][j] == 1){
                    if(building[k-2][j]+building[k-1][j]+building[k+1][j]+building[k+2][j] == 0) count++;
                }
            }
        }
        cout<< "#" << i+1 << " " <<count << endl;
    }
    return 0;
}
