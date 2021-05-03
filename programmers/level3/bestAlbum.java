/*
 * 2021.05.03
 * gowoon-choi/github.com
 * programmers 베스트앨범
 */

package com.gowoon;

import java.util.*;

public class Solution {
    private static final int size = 2;

    public static class Song implements Comparable<Song>{
        private int id;
        private int count;
        Song(int id, int count){
            this.id = id;
            this.count = count;
        }
        @Override
        public int compareTo(Song o) {
            if(o.count == this.count) return this.id - o.id;
            return o.count - this.count;
        }
    }

    public static class Genre{
        private PriorityQueue<Song> songs;
        private int count;
        Genre(int id, int count){
            this.songs = new PriorityQueue<>();
            addSong(id, count);
        }
        public void addSong(int id, int count){
            songs.add(new Song(id, count));
            this.count += count;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Genre> play = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(play.containsKey(genres[i])) play.get(genres[i]).addSong(i, plays[i]);
            else play.put(genres[i], new Genre(i, plays[i]));
        }
        List<Map.Entry<String, Genre>> sorted = new LinkedList<>(play.entrySet());
        sorted.sort(new Comparator<Map.Entry<String, Genre>>() {
            @Override
            public int compare(Map.Entry<String, Genre> o1, Map.Entry<String, Genre> o2) {
                return o2.getValue().count - o1.getValue().count;
            }
        });
        int count;
        for(Map.Entry<String, Genre> entry : sorted){
            count = 0;
            for(int i=0; i<entry.getValue().songs.size(); i++){
                if(count == size) break;
                result.add(entry.getValue().songs.poll().id);
                i--;
                count++;
            }
        }
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(new String[]{"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"}, new int[]{500, 600, 150, 800, 1100, 2500, 100, 1000});
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
