package com.zjq.栈;

import java.util.Stack;

/**
 * 给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
 *
 * 列表中的每个元素只可能是整数或整数嵌套列表
 *
 * 提示：你可以假定这些字符串都是格式良好的：
 *
 * 字符串非空
 * 字符串不包含空格
 * 字符串只包含数字0-9, [, - ,, ]
 *  
 *
 * 示例 1：
 *
 * 给定 s = "324",
 *
 * 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 *  
 *
 * 示例 2：
 *
 * 给定 s = "[123,[456,[789]]]",
 *
 * 返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 *
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 *     i.  一个 integer 包含值 456
 *     ii. 一个包含一个元素的嵌套列表
 *          a. 一个 integer 包含值 789
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/mini-parser
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_00385 {

    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> sk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '[') {
                sk.push(new NestedInteger());
            } else if((ch >= '0' && ch <= '9') || ch == '-') {
                sb.append(ch);
            } else {
                if(sb.length() >= 1) {
                    int num = Integer.parseInt(sb.toString());
                    NestedInteger ni = new NestedInteger(num);
                    NestedInteger top = sk.peek();
                    top.add(ni);
                    sb.delete(0, sb.length());
                    }
                if(ch == ']') {
                    NestedInteger top = sk.pop();
                    if(sk.isEmpty()) return top;
                    NestedInteger newtop = sk.peek();
                    newtop.add(top);
                    }
                }
            }
        if (sb.length() >= 1)
            return new NestedInteger(Integer.parseInt(sb.toString()));
        return sk.peek();
    }

}

