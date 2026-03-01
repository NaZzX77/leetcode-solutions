import java.util.Scanner;

public class CountNumbersWithUniqueDigits {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value of n");
        int n=sc.nextInt();
        int ans=countNumbersWithUniqueDigits(n);
        System.out.println(ans);
    }

    static int countNumbersWithUniqueDigits(int n){
        if(n<1)return n+1;
        int ans=1;
        for(int i=1;i<=n;i++){
            ans+=countuniquedigits(i);
        }
        return ans;
    }

    static int countuniquedigits(int n){
        if(n==1)return 9;
        if(n==2)return 81;
        if(n>10)return 0;
        int i=3;
        int ans=81;
        int leftdigits=8;
        while(i<=n){
            ans*=leftdigits;
            leftdigits--;
            i++;
        }
        return ans;
    }
}
