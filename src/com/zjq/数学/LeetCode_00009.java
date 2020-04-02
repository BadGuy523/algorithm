package com.zjq.数学;

import java.util.Arrays;

/**
 * @description: LeetCode题9
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author: BadGuy
 * @date: 2020-04-02 13:04
 **/
public class LeetCode_00009 {

    public boolean isPalindrome(int x) {
        /** 转换成字符 **/
        /*boolean result = true;
        char[] chars = Integer.toString(x).toCharArray();
        System.out.println(Arrays.toString(chars));
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;*/
        /** 以数字来计算 **/
        /*int oldX = x;
        int newX = 0;
        while (x > 0) {
            newX =  newX * 10 + x % 10;
            x /= 10;
        }
        return oldX == newX;*/
        /** 数字计算优化，只需判断一半的数字即可 **/
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        LeetCode_00009 leetCode_00009 = new LeetCode_00009();
        System.out.println(leetCode_00009.isPalindrome(121));;
    }

}
