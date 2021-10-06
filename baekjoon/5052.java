package com.gowoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static class Node{
        private Map<Character, Node> childNodes = new HashMap<>();
        private boolean isLast;
    }

    public static class Trie{
        private Node root;
        Trie(){
            this.root = new Node();
        }
        boolean insert(String number){
            Node node = this.root;
            for(int i=0; i<number.length(); i++){
                node = node.childNodes.computeIfAbsent(number.charAt(i), c -> new Node()); 
                if(node.isLast && i<number.length()-1) return false; 
            }
            if(!node.childNodes.isEmpty()) return false; 
            node.isLast = true;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            Trie trie = new Trie();
            for(int j=0; j<n; j++){
                String number = br.readLine();
                if(flag){
                    if(!trie.insert(number)) flag = false;
                }
            }
            if(flag) bw.write("YES\n");
            else bw.write("NO\n");
            bw.flush();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
