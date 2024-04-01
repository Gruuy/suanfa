package LeetCode.一般;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2021/1/7
 * @Copyright: 2021 锦铭泰软件. All rights reserved.
 */
public class 省份数量 {

    /**
     * 这个可以看做一个图问题
     * 城市与城市之间是无向图  所以维护一个boolean表示是否有通路
     * 所以我们需要找到究竟有多少个图
     * 相当于没有连接的图有几个
     * @param isConnected
     * @return
     */
    public static int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        // 记录已经有边的城市
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            // 如果该城市是无边的
            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;

//        广度优先搜索，优先找出有联通的城市  遍历完再开始深入遍历
//        int provinces = isConnected.length;
//        boolean[] visited = new boolean[provinces];
//        int circles = 0;
//        Queue<Integer> queue = new LinkedList<Integer>();
//        for (int i = 0; i < provinces; i++) {
//            if (!visited[i]) {
//                queue.offer(i);
//                while (!queue.isEmpty()) {
//                    int j = queue.poll();
//                    visited[j] = true;
//                    for (int k = 0; k < provinces; k++) {
//                        if (isConnected[j][k] == 1 && !visited[k]) {
//                            queue.offer(k);
//                        }
//                    }
//                }
//                circles++;
//            }
//        }
//        return circles;
    }

    /**
     * 遍历方法  直到图无边为止
     * @param isConnected
     * @param visited
     * @param provinces
     * @param i
     */
    public static void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(findCircleNum2(new int[][]{{1,1,0},{1,1,0},{0,0,1}}) );
    }

    public static int findCircleNum2(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
