package com.whut.reggie.LeetCodeTest.huisu;

import java.util.ArrayList;
import java.util.List;

public class test89 {
    List<Integer> res1;
    boolean flag = false;

    public List<Integer> grayCode(int n) {
         List<Integer> res = new ArrayList<>();
         res.add(0);
         if (n == 1) {
             res.add(1);
             return res;
         }
         dfs(res,n);
         return res1;
    }
    public void dfs(List<Integer> res ,int n){
        if (!flag) {
            if (res.size() == Math.pow(2,n) - 1) {
                for (int i = 0; i < n; i++) {
                    if (!res.contains((int)Math.pow(2, i)) && (Math.pow(2, i) - res.get(res.size() - 1) % 2 == 0)) {
                        res.add((int) Math.pow(2, i));
                        break;
                    }
                }
                return;
            }
            if (res.size() == Math.pow(2,n)) {
                flag = true;
                res1 = new ArrayList<>(res);
                return;
            }
            for (int j = 0; j < n; j++) {
                int mid = (int) (Math.pow(2,j) - res.get(res.size() - 1));
                if (!res.contains((int) Math.pow(2, j)) && (mid % 2 == 0 || mid == 1)){
                    res.add((int) Math.pow(2, j));
                    dfs(res,n);
                    res.remove(res.size() - 1);
                }
            }
        }
    }
}
