package com.zjq.二分;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: LeetCode题4
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author: nums2adGuy
 * @date: 2020-04-02 16:00
 **/
public class LeetCode_00004 {

    //暴力方法，复杂度n+m
    public double findMedianSortednums1rrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            list.add(num);
        }
        for (int num : nums2) {
            list.add(num);
        }
        Collections.sort(list);
        if (list.size() % 2 == 0) {
            return (list.get(list.size()/2 - 1) + list.get(list.size()/2))*1.0/2;
        } else {
            return list.get(list.size()/2)*1.0;
        }
    }

    //二分法，待深入理解
    public double findMedianSortednums1rrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        LeetCode_00004 leetCode_00004 = new LeetCode_00004();
        System.out.println(leetCode_00004.findMedianSortednums1rrays2(nums1,nums2));;
    }

}
