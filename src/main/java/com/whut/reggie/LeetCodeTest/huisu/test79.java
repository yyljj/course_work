package com.whut.reggie.LeetCodeTest.huisu;

public class test79 {
    public static void main(String[] args) {
        test79 test79 = new test79();
        test79.exist(new char[][]{{'a'}},"a");
    }
    boolean flag = false;
    boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        if(board.length == 1 && board[0].length == 1){
            return board[0][0] == word.charAt(0);
        }
        vis = new boolean[board.length][board[0].length];
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                dfs(i,j,new StringBuilder(),word,board);
                if (flag){
                    return flag;
                }
            }
        }
        return flag;
    }
    public void dfs(int x , int y , StringBuilder sb , String word , char[][] board) {
        if (!flag) {
            if (sb.length() == word.length()) {
                if (sb.toString().equals(word)) {
                    flag = true;
                    return;
                }
            }
            if ((x >= 0 && x < board.length && y >= 0 && y < board[0].length)) {
                if (board[x][y] != word.charAt(sb.length()))
                    return;
            }
            if (!vis[x][y]) {
                sb.append(board[x][y]);
                vis[x][y] = true;
            } else {
                return;
            }
            if (x > 0) {
                dfs(x - 1, y, sb, word, board);
            }
            if (y < board[0].length - 1) {
                dfs(x, y + 1, sb, word, board);
            }
            if (x < board.length - 1) {
                dfs(x + 1, y, sb, word, board);
            }
            if (y > 0) {
                dfs(x, y - 1, sb, word, board);
            }
            sb.deleteCharAt(sb.length() - 1);
            vis[x][y] = false;
        }
    }
}
