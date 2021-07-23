package org.example.dfss;

import java.util.Arrays;
import java.util.Scanner;


class DFS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] gr = new int[n][0];
        for (int i = 0; i < m; ++i) {
            int x = in.nextInt(), y = in.nextInt();
            --x;
            --y;
            gr[x] = addElement(gr[x], y);
            gr[y] = addElement(gr[y], x);
        }
        int[] used = new int[n];
        Arrays.fill(used, 0);
        int cnt = 1;
        int[] ans = new int[0];
        int[] all = {0};
        for(int i = 0;i<n;++i){
            if(used[i] == 0)
            {
                dfs(i, cnt, all, used, gr);
                ans = addElement(ans, all[0]);
                all[0] = 0;
                cnt++;
            }
        }
        int q = in.nextInt();
        for(int i =0;i<q;++i){
            int a = in.nextInt(), b = in.nextInt();
            --a;
            --b;
            if(used[a] != used[b])
            {
                System.out.println(0);
            }
            else
                System.out.println(ans[used[a] - 1]);
        }
    }
    public static void dfs(int v, int col, int[] all, int[] used, int[][] gr){
        used[v] = col;
        all[0]++;
        for(int u : gr[v]){
            if(used[u] == 0)
                dfs(u, col, all, used, gr);
        }
    }
    public static int[] addElement(int[] a, int x) {
        int[] res = Arrays.copyOf(a, a.length + 1);
        res[res.length - 1] = x;
        return res;
    }
}