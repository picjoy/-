import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
//         String[] str = a.split("");
        
//         for(int i = 0; i < str.length; i++){
//             System.out.println(str[i]);
//         }
// toCharArray() : String 문자열을 char형 배열로 바꿔서 반환해주는 메서드
        for (char ch : a.toCharArray())
            System.out.println(ch);


    }
}
