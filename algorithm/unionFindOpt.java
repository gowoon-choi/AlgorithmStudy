package com.gowoon;

public class UnionFindOpt {
    int[] root;
    int[] height;
    UnionFindOpt(int size){
        this.root = new int[size];
        this.height = new int[size];
        for(int i=0; i<size; i++){
            root[i] = i;
            height[i] = 0;
        }
    }

    int find(int x){
        if(root[x] == x) return x;
        else return root[x] = find(root[x]);
    }

    void union(int x, int y){
        x = find(x);
        y = find(y);
        root[y] = x;
        if(x == y)
            return;
        if(height[x] < height[y]) root[x] = y;
        else {
            root[y] = x;
            if(height[x] == height[y]) height[x]++;
        }
    }
}
