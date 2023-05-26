package com.whut.reggie.LeetCodeTest.huisu;

import java.util.ArrayList;
import java.util.List;

public class test90 {
    public static void main(String[] args) {
        test90 test90 = new test90();
        test90.subsetsWithDup(new int[]{1,2,2,3});
    }
    boolean[] vis;
    boolean flag = false;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        vis = new boolean[nums.length];
        dfs(res,res1,0,nums);
        return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> res1,int index,int[] nums){
        if (index == nums.length){
            res.add(new ArrayList<>(res1));
            return;
        }
        if (index > 0 && nums[index] == nums[index-1] && !vis[index-1]){
            flag=true;
            dfs(res,res1,index+1,nums);
        }else {
            res1.add(nums[index]);
            vis[index]=true;
            dfs(res,res1,index+1,nums);
            res1.remove(res1.size()-1);
            vis[index]=false;
            flag=false;
        }
        if (!flag) {
            dfs(res, res1, index+1,nums);
        }
    }
}
