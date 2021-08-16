import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<String, String> nicknames = new HashMap<>(); // uid : nickname
    static class Record{
        private String command;
        private String uid;
        Record(String command, String uid){
            this.command = command;
            this.uid = uid;
        }
        String print(){
            String nickname = nicknames.get(uid);
            String suffix;
            if(command.equals("Leave")) suffix = "나갔습니다";
            else suffix = "들어왔습니다";
            return nickname+"님이 "+suffix+".";
        }
    }
    public String[] solution(String[] record) {
        ArrayList<Record> records = new ArrayList<>();
        String[] content;
        for(String command : record){
            content = command.split(" ");
            switch (content[0]){
                case "Enter":
                    nicknames.put(content[1], content[2]);
                    records.add(new Record(content[0], content[1]));
                    break;
                case "Leave":
                    records.add(new Record(content[0], content[1]));
                    break;
                case "Change":
                    nicknames.put(content[1], content[2]);
                    break;
            }
        }
        String[] answer = new String[records.size()];
        for(int i=0; i<records.size(); i++){
            answer[i] = records.get(i).print();
        }
        return answer;
    }
}
