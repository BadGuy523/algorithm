package com.zjq.数学;

/**
 * @description: LeetCode题7
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author: BadGuy
 * @date: 2020-04-02 12:26
 **/
public class LeetCode_00007 {

    public int reverse(int x) {
        Long b = 0L;
        int a = x;
        //取每位数倒序求和，判断是否溢出做特殊处理
        for (;a != 0;a = a / 10) {
            b = b * 10 + a % 10;
        }
        return x < 0 ? (b < 0 && b > Integer.MIN_VALUE ? b.intValue() : 0) : (b > 0 && b < Integer.MAX_VALUE ? b.intValue() : 0);
    }

    //试试骚操作
    public int reverse2(int x) {
        StringBuilder builder =  new StringBuilder(Integer.toString(x));
        String sign = builder.substring(0,1).equals("-") ? "-" : "";
        builder.reverse();
        int a = 0;
        try {
            a = Integer.valueOf(sign + builder.toString().replaceAll("-",""));
        } catch (Exception e){
            a = 0;
        }
        return a;
    }

    public static void main(String[] args) {
        LeetCode_00007 leetCode_00007 = new LeetCode_00007();
        System.out.println(leetCode_00007.reverse2(-1234));
    }

}
