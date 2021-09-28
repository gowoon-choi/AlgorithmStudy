package com.gowoon;

import java.io.*;
import java.util.*;

public class Main {
    public static class Tetromino{
        private int[][] block;
        private int kinds;
        private boolean isSame;
        Tetromino(int[][] block, int kinds, boolean isSame){
            this.block = block;
            this.kinds = kinds;
            this.isSame = isSame;
        }
        void rotate(){
            int[][] result = new int[block[0].length][block.length];
            for(int i=0; i<block.length; i++){
                for(int j=0; j<block[i].length; j++){
                    result[j][result[0].length-i-1] = block[i][j];
                }
            }
            block = result;
        }
        void symm(){
            int[][] result = new int[block.length][block[0].length];
            for(int i=0; i<block.length; i++){
                for(int j=0; j<block[i].length; j++){
                    result[block.length-i-1][j] = block[i][j];
                }
            }
            block = result;
        }
        int width(){ return block[0].length; }
        int height() { return block.length; }
    }

    public static ArrayList<Tetromino> blocks = new ArrayList<>(){
        {
            add(new Tetromino(new int[][]{{1,1,1,1}}, 2, true));
            add(new Tetromino(new int[][]{{1,1},{1,1}}, 1, true));
            add(new Tetromino(new int[][]{{1,0},{1,0},{1,1}}, 4,false));
            add(new Tetromino(new int[][]{{1,0},{1,1},{0,1}}, 4, false));
            add(new Tetromino(new int[][]{{1,1,1},{0,1,0}}, 4,true));
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // reader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // writer
        StringTokenizer st; // tokenizer

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int sum, flag;
        for(Tetromino block : blocks){
            if(block.isSame) flag = 1;
            else flag = 2;
            for(int i=0; i<flag; i++){
                block.symm();
                for(int count = 0; count<block.kinds; count++){
                    block.rotate();
                    for(int a=0; a+block.height() <= board.length; a++){
                        for(int b=0; b+block.width() <= board[a].length; b++){
                            sum = 0;
                            for(int c=0; c<block.block.length; c++){
                                for(int d=0; d<block.block[c].length; d++){
                                    if(block.block[c][d] == 1) sum += board[a+c][b+d];
                                }
                            }
                            result.add(sum);
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(Collections.max(result)));

        bw.write( "\n"); // for return value
        bw.flush(); // flush
        bw.close(); // close
        br.close(); // close
    }
}
