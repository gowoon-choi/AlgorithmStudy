import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    static Pattern pattern = Pattern.compile("[0-9]+");
    static Matcher matcher1, matcher2;
    static String head1, head2;
    static int number1, number2;
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                matcher1 = pattern.matcher(o1);
                matcher2 = pattern.matcher(o2);
                matcher1.find();
                matcher2.find();
                head1 = o1.substring(0, matcher1.start()).toLowerCase();
                head2 = o2.substring(0, matcher2.start()).toLowerCase();
                number1 = Integer.parseInt(matcher1.group());
                number2 = Integer.parseInt(matcher2.group());
                if(head1.equals(head2)){
                    return number1-number2;
                }
                return head1.compareTo(head2);
            }
        });
        return files;
    }
}
