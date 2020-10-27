import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() < b.length()){
                    return -1;
                }else if(a.length() > b.length()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for(int i=0; i<phone_book.length; i++){
            for(int j=i+1; j<phone_book.length; j++){
                if(phone_book[j].indexOf(phone_book[i])==0){
                    return false;
                }
            }
        }
        return true;
    }
}
