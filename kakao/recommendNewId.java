class Solution {
    public static String rule1(String new_id){
        return new_id.toLowerCase();
    }

    static char[] chars = {'-', '_', '.'};
    public static String rule2(String new_id){
        StringBuilder result = new StringBuilder();
        int character;
        boolean isPossible;
        for(int i=0; i<new_id.length(); i++){
            character = new_id.charAt(i);
            isPossible = true;
            if(!(character >= 97 && character <= 122) && !(character >= 48 && character <= 57)){
                isPossible = false;
                for(char ch : chars){
                    if (ch == character) {
                        isPossible = true;
                        break;
                    }
                }
            }
            if(isPossible) result.append(new_id.charAt(i));
        }
        return result.toString();
    }

    public static String rule3(String new_id){
        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }
        return new_id;
    }

    public static String rule4(String new_id){
        if(new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        return new_id;
        return new_id;
    }

    public static String rule5(String new_id){
        if(new_id.equals("")) new_id = "a";
        return new_id;
    }

    public static String rule6(String new_id){
        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
        }
        while (new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }
        return new_id;
    }

    public static String rule7(String new_id){
        StringBuilder new_idBuilder = new StringBuilder(new_id);
        while (new_idBuilder.length() < 3){
            new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1));
        }
        return new_idBuilder.toString();
    }
    
    public String solution(String new_id) {
        String answer = new_id;
        answer = rule1(answer);
        answer = rule2(answer);
        answer = rule3(answer);
        answer = rule4(answer);
        answer = rule5(answer);
        answer = rule6(answer);
        answer = rule7(answer);
        return answer;
    }
}
