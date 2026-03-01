/*
Solved the NextGreaterElements 1 first then moved onto this where the only difference was the size was same and i had to handle it for circular
index so thought of the math and then came up with int index = (value + i) % nums.length; to get the correct indexes checked to find the next greater element .
*/
import java.util.*;
public class NextGreaterElements {
    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = findnextgreat(nums, i);
        }
        return ans;
    }
    public static int findnextgreat(int[] nums, int value) {
        for (int i = 1; i < nums.length; i++) {   // start from 1 to avoid comparing with itself
            int index = (value + i) % nums.length;
            if (nums[index] > nums[value]) {
                return nums[index];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = nextGreaterElements(nums);
        System.out.println("Next greater elements:");
        System.out.println(Arrays.toString(result));
    }
}
