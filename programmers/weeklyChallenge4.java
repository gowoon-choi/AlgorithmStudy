import java.util.*;

class Solution {
    public static class Table{
        int size = 5;
        String job;
        ArrayList<String> languages;
        int score;
        Table(String table){
            String[] temp = table.split(" ");
            this.job = temp[0];
            this.languages = new ArrayList<>();
            this.languages.addAll(Arrays.asList(temp).subList(1, temp.length));
        }

        int getLanguageScore(String language){
            int index = languages.indexOf(language);
            if(index == -1) return 0;
            else return size - languages.indexOf(language);
        }

        void setScore(String[] languages, int[] preferences){
            int score = 0;
            for(int i=0; i<languages.length; i++){
                score += (getLanguageScore(languages[i]) * preferences[i]);
            }
            this.score = score;
        }
    }
    
    public String solution(String[] table, String[] languages, int[] preference) {
        ArrayList<Table> tables = new ArrayList<>();
        Table temp;
        for(String str : table){
            temp = new Table(str);
            temp.setScore(languages, preference);
            tables.add(temp);
        }
        tables.sort(new Comparator<Table>() {
            @Override
            public int compare(Table o1, Table o2) {
                if(o1.score == o2.score) return o1.job.compareTo(o2.job);
                return o2.score - o1.score;
            }
        });
        return tables.get(0).job;
    }
}
