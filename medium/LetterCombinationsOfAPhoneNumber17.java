import java.util.*;

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
