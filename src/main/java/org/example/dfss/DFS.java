package org.example.dfss;

import java.util.Arrays;
import java.util.Scanner;


class DFS {
    public static int[][] gr;
    public static int[] used;
    public static int col = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        gr = new int[n][0];
        used = new int[n];
        Arrays.fill(used, 0);
        for (int i = 0; i < m; ++i) {
            int x = in.nextInt(), y = in.nextInt();
            --x;
            --y;
            gr[x] = addElement(gr[x], y);
            gr[y] = addElement(gr[y], x);
        }
        for(int i = 0;i<n;++i){
            if(used[i] == 0)
            {
                dfs(i);
                col++;
            }
        }
        int q = in.nextInt();
        for(int i =0;i<q;++i){
            int a = in.nextInt(), b = in.nextInt();
            --a;
            --b;
            if(used[a] != used[b])
            {
                System.out.println("Эти две вершины не связаны");
            }
            else {
                System.out.println("Эти две вершины связаны");
            }
        }
    }

    public static void dfs(int v){
        used[v] = col;
        for(int u : gr[v]){
            if(used[u] == 0)
                dfs(u);
        }
    }

    public static int[] addElement(int[] a, int x) {
        int[] res = Arrays.copyOf(a, a.length + 1);
        res[res.length - 1] = x;
        return res;
    }
}