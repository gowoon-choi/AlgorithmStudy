import java.util.*;
import java.lang.*;
import java.io.*;
 
class Main
{
    static Scanner sc;
    static int c, n;
    static boolean[] check;
    static HashSet<Integer> hSet;
    static String str; 
 
    public static void main (String[] args) throws java.lang.Exception
    {
        sc = new Scanner(System.in);
        check = new boolean[7];
        hSet = new HashSet<Integer>();
        
        c = sc.nextInt();
        for(int i = 1; i <= c; i++){
            str = sc.next();
            hSet.clear();
            for(int j = 0; j < str.length(); j++) check[j] = false;
            
            dfs("");
            System.out.println(hSet.size());
        }
    }
    
    public static void dfs(String s){
        for(int i = 0; i < str.length(); i++){
            if(check[i] == false){
                String tmp = s + str.charAt(i);
                int num = Integer.parseInt(tmp);
                
                check[i] = true;
                if(isPrime(num)) hSet.add(num);
                dfs(tmp);
                check[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num){
        if(num == 1 || num == 0) return false;
        
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}
