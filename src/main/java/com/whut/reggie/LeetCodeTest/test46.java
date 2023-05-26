package com.whut.reggie.LeetCodeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test46 {
    public static void main(String[] args) {
        test46 test46 = new test46();
        test46.permute(new int[]{1,2,3});
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0)
            return res;
         List<Integer> output = new ArrayList<>();
         for (int num : nums){
             output.add(num);
         }
         dfs(len,output,res,0);
         return res;
    }
    public void dfs(int len,List<Integer> output, List<List<Integer>> res ,int first){
        if (first == len){
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first ; i < len ; i++){
            Collections.swap(output,first,i);
            dfs(len,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }
}
