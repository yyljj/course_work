package com.whut.reggie.LeetCodeTest.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test39 {
    public static void main(String[] args) {
        test39 test39 = new test39();
        test39.combinationSum(new int[]{2,3,5},8);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res,res1,candidates,target,0);
        return res;
    }
    public void dfs(List<List<Integer>> res , List<Integer> res1 , int[] candidates , int target ,int index){
        if (target == 0){
            res.add(new ArrayList<>(res1));
            return;
        }
        if (index == candidates.length){
            return;
        }
        for (int i = index ; i < candidates.length ; i++){
            int most = target / candidates[i];
            for (int j = 1 ; j <= most ; j++){
                res1.add(candidates[i]);
                dfs(res,res1,candidates,target - j * candidates[i] ,i + 1);
            }
            for (int k = 1 ; k <= most ; k++){
                res1.remove(res1.size() - 1);
            }
        }
    }
}
