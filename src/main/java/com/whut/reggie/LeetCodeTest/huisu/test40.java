package com.whut.reggie.LeetCodeTest.huisu;

import java.util.*;

public class test40 {
    public static void main(String[] args) {
        test40 test40 = new test40();
        test40.combinationSum2(new int[]{10,1,2,7,6,1,5} , 8);
    }
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> res1 = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates){
            if (freq.isEmpty() || num != freq.get(freq.size() - 1)[0]){
                freq.add(new int[]{num , 1});
            }else {
                freq.get(freq.size() - 1)[1]++;
            }
        }
        dfs(0,target);
        return res;
    }
  public void dfs(int index, int remain){
        if (remain == 0)
        {
            res.add(new ArrayList<>(res1));
        }
        if (index == freq.size() || remain < freq.get(index)[0]){
            return;
        }
      dfs(index + 1,remain);
        int most = Math.min(remain/freq.get(index)[0],freq.get(index)[1]);
        for (int i = 0 ; i <= most ; i++){
            res1.add(freq.get(index)[0]);
            dfs(index + 1, remain - i * freq.get(index)[0]);
        }
        for (int i = 0 ; i <= most ; i++){
            res1.remove(res1.size() - 1 );
        }
  }
}
