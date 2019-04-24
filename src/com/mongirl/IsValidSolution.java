package com.mongirl;

import java.util.HashMap;
import java.util.Stack;
/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class IsValidSolution {
    public boolean isValid(String s) {
        //遍历字符串
        //判断是左括号的话入栈
        //右括号list
        //遍历list匹配左括号
        if(s == null || s.length() == 1){
            return false;
        }
        if(s.length() == 0) {
            return true;
        }


        char[] ss = s.toCharArray();
        Stack<Character> left = new Stack<Character>();
        for(int i = 0; i<ss.length; i++){
            if(ss[i] == '(' || ss[i] == '{' || ss[i] == '['){
                left.push(new Character(ss[i]));
            }else if(ss[i] == ')'){
                if(left.isEmpty() || left.pop() != '(') {
                    return false;
                }
            }else if(ss[i] == '}'){
                if(left.isEmpty() || left.pop() != '{') {
                    return false;
                }
            }else if(ss[i] == ']'){
                if(left.isEmpty() || left.pop() != '[') {
                    return false;
                }
            }
        }
        if(!left.empty()){
            return false;
        }
        return true;

    }

    /**题解思路**/
    public boolean isValidOnline(String s) {
        HashMap<Character,Character> mapping =  new HashMap<Character,Character>();
        mapping.put(')','(');
        mapping.put('}','{');
        mapping.put(']','[');
        Stack<Character> left = new Stack<Character>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(mapping.containsKey(c)){
                char topElement = left.empty() ? '#':left.pop();
                if(topElement != mapping.get(c)){
                    return false;
                }
            }else{
                left.push(c);
            }
        }

        return left.empty();

    }
}
