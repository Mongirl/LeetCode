package com.mongirl;

/**
 * 1.两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {
        int[] result  = new int[2];
        for(int i =0;i<nums.length-1;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }

            }

        }
        return result;
    }
}
