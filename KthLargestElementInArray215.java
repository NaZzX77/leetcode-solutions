/*
First i used O(nlogn) sorting using merge sort then returned n-k th index because i sorted in ascending order then i thought for like 5 -10 of optimizing and it hit me if i use quick sort i dont need to 
sort the whole array just the part of the array where the element index n-k lies so thought of that and recursed it with the appropriate condition which not going to lie did take me like about 5-10 minutes
even after having the idea of what to do 
*/
import java.util.*;
public class KthLargestElementInArray215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findKthLargest(nums, k));
    }
    public static int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, target);
    }
    static int quickSelect(int[] arr, int low, int high, int target) {
        int start = low;
        int end = high;
        int pivot = arr[low + (high - low) / 2];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        if (target <= end) {
            return quickSelect(arr, low, end, target);
        } else if (target >= start) {
            return quickSelect(arr, start, high, target);
        } else {
            return arr[target];
        }
    }
    /*class Solution {
        public int findKthLargest(int[] nums, int k) {
            int[] ans = mergesort(nums);
            return ans[ans.length - k];
        }
        static int[] mergesort(int[] nums) {
            if (nums.length == 1) return nums;
            int mid = nums.length / 2;
            int[] left = mergesort(Arrays.copyOfRange(nums, 0, mid));
            int[] right = mergesort(Arrays.copyOfRange(nums, mid, nums.length));
            return merge(left, right);
        }
        static int[] merge(int[] first, int[] second) {
            int[] merged = new int[first.length + second.length];
            int f = 0, s = 0, m = 0;
            while (f < first.length && s < second.length) {
                if (first[f] < second[s]) merged[m++] = first[f++];
                else merged[m++] = second[s++];
            }
            while (f < first.length) merged[m++] = first[f++];
            while (s < second.length) merged[m++] = second[s++];
            return merged;
        }
    }*/
}
