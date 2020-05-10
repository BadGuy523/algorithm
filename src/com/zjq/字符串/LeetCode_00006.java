package com.zjq.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class LeetCode_00006 {

    public String convert(String s, int numRows) {
        // 新建指定行数的列表，存入多个空字符串
        List<StringBuilder> builderList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder builder = new StringBuilder();
            builderList.add(builder);
        }
        // 初始索引
        int start = 0;
        // 递增或递减字长
        int flag = -1;

        // 将指定字符串转为字符数组
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            builderList.get(start).append(chars[i]);
            if (start % numRows == 0) {
                flag = 1;
            }
            if ((start + 1) % numRows == 0) {
                flag = -1;
            }
            start += flag;
            if (numRows == 1) {
                start = 0;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(builderList.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode_00006 leetCode_00006 = new LeetCode_00006();
        System.out.println(leetCode_00006.convert("AB", 1));;
    }

}
