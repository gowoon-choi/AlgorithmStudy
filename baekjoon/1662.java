package com.gowoon;

import java.io.*;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();
        Stack<String> stack = new Stack<>();
        int len;
        for(int i=0; i<target.length(); i++){
            if(target.charAt(i) == ')'){
                len = 0;
                while (!stack.peek().equals("(")){
                    if(stack.peek().charAt(0) == '*') len+=Integer.parseInt(stack.pop().substring(1));
                    else{
                        stack.pop();
                        len++;
                    }
                }
                stack.pop();
                stack.push("*" + (len*Integer.parseInt(stack.pop())));
            }else{
                stack.push(String.valueOf(target.charAt(i)));
            }
        }
        len = 0;
        while(!stack.isEmpty()){
            if(stack.peek().charAt(0) == '*') len+=Integer.parseInt(stack.pop().substring(1));
            else{
                stack.pop();
                len++;
            }
        }
        bw.write(len + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
