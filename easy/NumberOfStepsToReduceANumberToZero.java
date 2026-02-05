public class NumberOfStepsToReduceANumberToZero {

    public static void main(String[] args) {
        int test = 14;
        NumberOfStepsToReduceANumberToZero obj = new NumberOfStepsToReduceANumberToZero();
        System.out.println(obj.numberOfSteps(test));
    }

    int numberOfSteps(int num) {
        return helper(num, 0);
    }

    private int helper(int num, int count) {
        if (num == 0) return count;

        if (num % 2 == 0) {
            return helper(num / 2, count + 1);
        }
        return helper(num - 1, count + 1);
    }
}
