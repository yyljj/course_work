package com.whut.reggie.LeetCodeTest.huisu;

import java.util.ArrayList;
import java.util.List;

public class test113 {
    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(-2);
        TreeNode treeNode3 = new TreeNode(-3);
        treeNode2.left = null;
        treeNode2.right = treeNode3;
        test113 test113 = new test113();
        test113.pathSum(treeNode2,-5);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> res1 = new ArrayList<>();
       if (root == null){
           return res;
       }
       dfs(res,res1,targetSum,0,root);
       return res;
    }

    public void dfs(List<List<Integer>> res , List<Integer> res1 , int targetSum , int nowSum , TreeNode nowNode){
        if (nowSum + nowNode.val == targetSum){
            if (res1.size() != 0 || (nowNode.left == null && nowNode.right == null)) {
                res1.add(nowNode.val);
                res.add(new ArrayList<>(res1));
                res1.remove(res1.size() - 1);
                return;
            }
        }
        if (targetSum >= 0 && nowSum + nowNode.val > targetSum || targetSum < 0 && nowSum + nowNode.val < targetSum){
            return;
        }
        if (nowNode.left != null) {
            res1.add(nowNode.val);
            dfs(res, res1, targetSum, nowSum + nowNode.val, nowNode.left);
            res1.remove(res1.size() - 1);
        }
        if (nowNode.right != null) {
            res1.add(nowNode.val);
            dfs(res, res1, targetSum, nowSum + nowNode.val, nowNode.right);
            res1.remove(res1.size() - 1);
        }
    }
}
