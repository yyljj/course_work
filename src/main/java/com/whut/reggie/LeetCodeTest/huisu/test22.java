package com.whut.reggie.LeetCodeTest.huisu;

import java.util.ArrayList;
import java.util.List;

public class test22 {
    public static void main(String[] args) {
        test22 test22 = new test22();
        test22.generateParenthesis(3);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res,sb,0,0,n);
        return res;
    }
    public void dfs(List<String> res,StringBuilder sb,int left,int right,int n){
        if (left == right && left == n){
            res.add(new String(sb));
            return;
        }
        if (left < n) {
                sb.append("(");
                dfs(res, sb, left + 1, right, n);
                sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right){
            sb.append(")");
            dfs(res,sb,left,right+1,n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
