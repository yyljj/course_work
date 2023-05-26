package com.whut.reggie.LeetCodeTest.huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test93 {
    public static void main(String[] args) {
        test93 test93 = new test93();
        test93.restoreIpAddresses("0000");
    }
    List<Integer> record = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(s);
        dfs(res,stringBuilder,1,1,-1);
        return res;
    }
    public void dfs(List<String> res,StringBuilder stringBuilder,int index,int num,int beforeindex){
        if (num == 4)
        {
            if (!(stringBuilder.length() - beforeindex > 3) && stringBuilder.length() - beforeindex != 0)
                res.add(new String(stringBuilder));
            return;
        }
        if (!(index - beforeindex == 3 && Integer.parseInt(String.valueOf(stringBuilder.substring(beforeindex+1,beforeindex+3))) > 255)) {
            stringBuilder.insert(index, '.');
            dfs(res, stringBuilder, index + 2, num + 1, index + 1);
            stringBuilder.deleteCharAt(index);
        }else {
            return;
        }
        if (index < stringBuilder.length() && index - beforeindex < 3 && !(beforeindex == index - 1 && stringBuilder.charAt(index) == '0')) {
            dfs(res, stringBuilder, index + 1, num,beforeindex);
        }
    }
}
