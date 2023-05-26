package com.whut.reggie.LeetCodeTest.huisu;

import java.util.ArrayList;
import java.util.List;

public class test78 {
    public static void main(String[] args) {
        test78 test78 = new test78();
        test78.subsets(new int[]{1,2,3});
    }
    public List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>> res = new ArrayList<>();
          List<Integer> res1 = new ArrayList<>();
          dfs(res,res1,1,0,nums,true);
          res.add(new ArrayList<>());
          return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> res1,int sum,int index,int[] nums,boolean flag){
        if (sum > nums.length){
            return;
        }
        if (res1.size() == sum){
            res.add(new ArrayList<>(res1));
            return;
        }
        for (int i = index ; i < nums.length ; i++){
            res1.add(nums[i]);
            dfs(res,res1,sum,i+1,nums,false);
            res1.remove(res1.size()-1);
        }
        dfs(res,res1,sum+1,0,nums,true);
    }
}
