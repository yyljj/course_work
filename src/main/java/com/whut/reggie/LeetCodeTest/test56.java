package com.whut.reggie.LeetCodeTest;

import java.util.*;

public class test56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0)
            return new int[0][2];
        Arrays.sort(intervals, (int[] o1,int[] o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1 ; i < len ; i++){
            int L = intervals[i][0];
            int R = res.get(res.size() - 1)[1];
            if (L > R){
                res.add(intervals[i]);
            }else {
                res.get(res.size() - 1)[1] = Math.max(R,intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
