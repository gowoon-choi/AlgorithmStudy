/*
 * 2020.01.06
 * gowoon-choi/github.com
 * programmers 가장 큰 수
 */

package com.gowoon;

import java.util.*;

public class Solution {
    static public String solution(int[] numbers) {
        String result = "";
        ArrayList<String> convertedArr = new ArrayList<>();
        for (int number : numbers) {
            convertedArr.add(String.valueOf(number));
        }
        convertedArr.sort((num1, num2)-> (num1+num2).compareTo(num2+num1));
        for (String s : convertedArr) {
            result = s + result;
        }
        while (result.length() > 1 && result.charAt(0) == '0'){
            result = result.substring(1);
        }
        return result;
    }
}
