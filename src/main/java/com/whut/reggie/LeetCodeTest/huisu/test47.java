package com.whut.reggie.LeetCodeTest.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test47 {
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        vis = new boolean[nums.length];
        dfs(res,res1,nums);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> res1,int[] nums){
        if (res1.size() == nums.length)
        {
            res.add(new ArrayList<>(res1));
            return;
        }
        for (int i = 0 ; i < nums.length ; i++){
            if (vis[i]){
                continue;
            }
            res1.add(nums[i]);
            vis[i] = true;
            dfs(res,res1,nums);
            res1.remove(res1.size() - 1);
            vis[i] = false;
        }
    }

}
