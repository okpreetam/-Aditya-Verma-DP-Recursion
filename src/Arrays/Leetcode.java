package Arrays;

import java.util.Arrays;

class Leetcode {
    public static int[] moveZeroes(int[] nums) {
        int numsLen = nums.length;
        int zeroIndex = 0, numIndex = 0;

        while (numIndex < numsLen) {
            if (nums[numIndex] == 0) {
                numIndex++;
            } else {
                if (zeroIndex == numIndex) {
                    zeroIndex++;
                    numIndex++;
                } else {
                    nums[zeroIndex] = nums[numIndex];
                    nums[numIndex] = 0;
                    zeroIndex++;
                    numIndex++;
                }
            }
        }

        return nums;
    }


    public static void main(String[] args) {
        int[] arr = {2,0};
        Arrays.stream(moveZeroes(arr)).forEach(System.out::println);
    }
}
