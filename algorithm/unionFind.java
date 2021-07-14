package com.gowoon;

public class UnionFind {
    int[] root;
    UnionFind(int size){
        this.root = new int[size];
        for(int i=0; i<size; i++){
            root[i] = i;
        }
    }

    int find(int x){
        if(root[x] == x) return x;
        else return find(root[x]);
    }

    void union(int x, int y){
        x = find(x);
        y = find(y);
        root[y] = x;
    }
}
