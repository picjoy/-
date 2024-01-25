import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] str = a.split("");

        for(int i =0; i< str.length; i++){
            char chr = str[i].charAt(0); 
            if(Character.isUpperCase(chr)){
                 System.out.print(Character.toLowerCase(chr));
             }else{
                 System.out.print(Character.toUpperCase(chr));
             }
        }
    }
}
