package com.zjq.哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: LeetCode题1
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author: BadGuy
 * @date: 2020-04-02 11:35
 **/
public class LeetCode_00001 {
    public int[] twoSum(int[] nums, int target) {
        /** 暴力求解 **/
/*        int[] result = {0,1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }*/
        /** 两遍哈希表优化 **/
/*        int[] result = {0,1};
        Map<Integer,Integer> map = new HashMap<>();
        //将数组值作为键，索引作为值做哈希映射
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        //遍历一次数组，用和值减去每个数得差值，在哈希表中查找差值对应值，判断大小区分前后关系
        for (int i = 0; i < nums.length;i ++) {
            int number = target - nums[i];
            if (map.get(number) != null) {
                if (map.get(number) == i) {
                    continue;
                } else {
                    if (map.get(number) > i) {
                        result[0] = i;
                        result[1] = map.get(number);
                    } else {
                        result[1] = i;
                        result[0] = map.get(number);
                    }
                }
            }
        }*/
        /** 一遍哈希表优化 **/
        int[] result = {0,1};
        Map<Integer, Integer> map = new HashMap<>();
        int number = 0;
        //遍历一遍，在构建哈希表时，同时判断已有哈希表中有无满足条件的数
        for (int i = 0; i < nums.length; i++) {
            number = target - nums[i];
            if (map.get(number) != null && map.get(number) != i) {
                result[0] = map.get(number);
                result[1] = i;
                break;
            }
            //若遇到相加的两数相同的情况，第二个数做哈希映射时会将第一个数抹去，所以需要在判断之后做put操作
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        int target = 6;
        LeetCode_00001 leetCode_1 = new LeetCode_00001();
        System.out.println(Arrays.toString(leetCode_1.twoSum(nums,target)));;
    }

}
