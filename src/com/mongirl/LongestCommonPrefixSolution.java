package com.mongirl;
/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefixSolution {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int length = strs[0].length();
        //找到最短字符串的长度
        for(int i =1; i<strs.length; i++){
            if(length > strs[i].length()){
                length = strs[i].length();
            }


        }
        if(length <= 0){
            return "";
        }

        int res = -1;
        for(int i =0; i<length; i++){
            boolean b = true;
            for(int j =0; j<strs.length-1; j++){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    b = false;
                    break;
                }

            }
            if(b) {
                res = i;
            }else {
                break;
            }


        }
        if(res > -1 && res < strs[0].length()-1) {
            return strs[0].substring(0,res+1);
        }else if(res == strs[0].length()-1){
            return strs[0];
        }
        return "";
    }

    public String longestCommonPrefixFromXH(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        //网上思路 比较第一个到第二个的最长字符串，第三个，第四个直到最后一个
        //假设第一个是最长字符
        String result = strs[0];
        int i = 1;
        while(i < strs.length){
            if(strs[i].indexOf(result) != 0){
                result = result.substring(0,result.length() -1);
            }else{
                i++;
            }
        }
        return result;
    }

}
