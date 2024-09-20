package programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SearchingMaze {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static int rowSize = -1;
    static int colSize = -1;

    static int answer = -1;
    static int startRow = -1;
    static int startCol = -1;
    static Queue<int[]> q = new LinkedList<>();

    public int solution(String[] maps) {

        rowSize = maps.length;
        colSize = maps[0].length();

        map = new char[rowSize][colSize];
        visited = new boolean[rowSize][colSize];

        // 1. 값 초기화
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);

                if(map[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        // 2. BFS로 탐색 시작
        findExit();

        return answer;
    }


    public static void findExit() {

        q.add(new int[]{startRow, startCol, 0, -1});
        visited[startRow][startCol] = true;

        while(!q.isEmpty()) {

            int[] v = q.poll();
            int curRow = v[0];
            int curCol = v[1];
            int curCount = v[2];
            int leverStatus = v[3];

            // 최종 도착지
            if(map[curRow][curCol] == 'E' && (leverStatus == 1)) {
                answer = Math.max(answer, curCount);
            }

            if(map[curRow][curCol] == 'L' && leverStatus == -1) {
                clearVisited();
                q.clear();
                visited[curRow][curCol] = true;
                q.add(new int[]{curRow, curCol, curCount, 1});
                continue;
            }

            for(int dir = 0; dir < 4; dir++) {

                int nextRow = curRow + dy[dir];
                int nextCol = curCol + dx[dir];

                if(isOutofBound(nextRow, nextCol) || map[nextRow][nextCol] == 'X' || visited[nextRow][nextCol]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                q.add(new int[]{nextRow, nextCol, curCount+1, leverStatus});

            }
        }


    }// end findExit()

    public static boolean isOutofBound(int nextRow, int nextCol) {
        return (nextRow >= rowSize || nextRow < 0 || nextCol >= colSize || nextCol < 0);
    }

    public static void clearVisited() {
        for(int i = 0; i < rowSize; i++) {
            Arrays.fill(visited, false);
        }
    }
}
