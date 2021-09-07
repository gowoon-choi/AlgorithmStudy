import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
      static Queue<String> q = new LinkedList<String>();
      static HashSet<String> hs = new HashSet<String>(); 
      static HashMap<String, Integer> hm = new HashMap<String, Integer>();
      static int startPoint = 0;
      static int length = Integer.MAX_VALUE;
     public static int[] solution(String[] gems) {
        int[] answer;  
        for(String g : gems) {
        	hs.add(g);
        }
        int start = 0;
        for(int i = 0; i < gems.length; i++) {
        	if(!hm.containsKey(gems[i])) hm.put(gems[i], 1);
        	else hm.put(gems[i], hm.get(gems[i]) + 1);
        	q.add(gems[i]);
        	while(true) {
        		String temp = q.peek();
        		if(hm.get(temp) > 1) {
        			hm.put(temp, hm.get(temp) - 1);
        			q.poll();
        			startPoint++;
        		}
        		else {
        			break;
        		}
        	}
        	if(hm.size() == hs.size() && length > q.size()) {
        		length = q.size();
        		start = startPoint;
        	}
        }
        return new int[]{start + 1, start + length};  
    }
}
