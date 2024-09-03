package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeLandScape {

    private static int n;
    private static int[][] treeMap;
    private static boolean[][] visited;
    private static int dy[] = {1, 0};
    private static int dx[] = {0, 1};
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        treeMap = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                treeMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pairCnt = n == 2 ? 2 : 4;

        dfs(0, 0, pairCnt);
        System.out.println(result);
        br.close();
    }

    private static void dfs(int cnt, int totalSum, int pairCnt) {

        // 최대 n개쌍이면 종료
        if(cnt == pairCnt) {
            result = Math.max(result, totalSum);
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(visited[i][j]) {
                    continue;
                }

                for(int dir = 0; dir < 2; dir++) {
                    int nextRow = i + dy[dir];
                    int nextCol = j + dx[dir];

                    if(isOutOfBound(nextRow, nextCol) || visited[nextRow][nextCol]) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    visited[i][j] = true;
                    dfs(cnt+1, totalSum + treeMap[i][j] + treeMap[nextRow][nextCol], pairCnt);
                    visited[i][j] = false;
                    visited[nextRow][nextCol] = false;

                }

            }
        }


    }

    private static boolean isOutOfBound(int nextRow, int nextCol) {
        return nextRow >= n || nextRow < 0 || nextCol >= n || nextCol < 0;
    }

}
