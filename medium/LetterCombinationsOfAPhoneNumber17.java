import java.util.*;
/*
-Thought Process: First Doubt if 2 consecutive 2's is it b or 2 a's we dont know so we consider all possibilities
-The number of digits represents number of characters not how many times it been pressed;
-Saved the mapping of digits in map with their respective index digit 
-Thought about recursion at the beginning because problem can be broken down into smaller problems
-Thought of the base condition i.e when all digits are processed completely

*/

public class LetterCombinationsOfAPhoneNumber17{
    static String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String digits=sc.nextLine();
        List<String> ans=letterCombinations(digits);
        System.out.println(ans);
    }
    static List<String> letterCombinations(String digits){
        if(digits.length()==0)return new ArrayList<>();
        return combinations(digits,0,"");
    }
    static List<String> combinations(String digits,int index,String current){
        List<String> list=new ArrayList<>();
        if(index==digits.length()){
            list.add(current);
            return list;
        }
        int digit=digits.charAt(index)-'0';
        String letters=map[digit];
        for(int i=0;i<letters.length();i++){
            char letter=letters.charAt(i);
            list.addAll(combinations(digits,index+1,current+letter));
        }
        return list;
    }
}
