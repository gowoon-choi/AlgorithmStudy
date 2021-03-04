/*
 * 2021.03.04
 * gowoon-choi/github.com
 * programmers 위장
 */

package com.gowoon;

import java.util.HashMap;

public class Solution {
    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> items = new HashMap();
        for (String[] clothe : clothes) {
            if(items.get(clothe[1]) == null) items.put(clothe[1], 1);
            else items.put(clothe[1], items.get(clothe[1])+1);
        }
        for(String key : items.keySet()) answer = answer * (items.get(key) + 1);
        return answer-1;
    }
}
