class Solution {
    public int solution(int[] numbers) {
        int max1=numbers[0];
        int sec=numbers[0];

        int flag = 0;

        for (int n : numbers) {
            if (max1<n) {
							max1 = n;
						}
        }
        // 
        for (int num : numbers) {
            if (num<max1 && sec<num) {
							sec = num;
						}
            if (num==max1) {
							flag++;
						}
					if (flag>=2) {
						sec = max1;
					}
        }
        return max1 * sec;
    }


		public void main(String[] args) {
			int[] nums = {30,25,4,3,2};

			System.out.println(solution(nums));
		}
}

        // System.out.println(max1);
        // System.out.println(sec);
        // int max1 = 0;
        // int sec = 0;

