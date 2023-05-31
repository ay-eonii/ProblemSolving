class Solution {
    public int solution(int[] arr) {

        int lcm = LCM(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            lcm = LCM(lcm, arr[i]);
        }
        return lcm;
    }

    private int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    private int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
}