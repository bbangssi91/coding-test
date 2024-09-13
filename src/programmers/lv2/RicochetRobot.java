package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobot {

    static char[][] boardGame;
    static boolean[][] visited;
    static final int[] dy = {1, 0, -1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int startRowPoint = -1;
    static int startColPoint = -1;
    static int endRowPoint = -1;
    static int endColPoint = -1;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        RicochetRobot t = new RicochetRobot();
        String[] s = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};

        System.out.println(t.solution(s));
    }

    static class Node {
        private int row;
        private int col;
        private int cnt;

        public Node(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    public int solution(String[] board) {

        boardGame = new char[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];

        // 1. 보드게임판 값 넣음
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                char c = board[i].charAt(j);
                boardGame[i][j] = c;


                if(c == 'R') {
                    startRowPoint = i;
                    startColPoint = j;
                }
                if(c == 'G') {
                    endRowPoint = i;
                    endColPoint = j;
                }
            }
        }


        findGoal(startRowPoint, startColPoint, 0);

        return answer == Integer.MAX_VALUE? -1 : answer;
    }

    // BFS 탐색
    public static void findGoal(int r, int c, int c2) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, c2));

        while(!q.isEmpty()) {
            Node node = q.poll();
            int curRow = node.row;
            int curCol = node.col;
            int curCount = node.cnt;

            if(boardGame[curRow][curCol] == 'G') {
                answer = Math.min(answer, curCount);
                return;
            }


            for(int dir = 0; dir < 4; dir++) {
                int[] nextPos = goStraight(curRow, curCol, dir);

                int nextRow = nextPos[0];
                int nextCol = nextPos[1];

                if(visited[nextRow][nextCol]) continue;

                visited[nextRow][nextCol] = true;
                q.add(new Node(nextRow, nextCol, curCount+1));

            }
        } // end q

    }

    public static int[] goStraight(int row, int col, int direction) {

        while(true) {
            int nextRow = row + dy[direction];
            int nextCol = col + dx[direction];

            // 배열 범위 넘으면 통과
            if(nextRow >= boardGame.length || nextRow < 0 ||
                    nextCol >= boardGame[0].length || nextCol < 0) {
                break;
            }

            if(boardGame[nextRow][nextCol] == 'D') {
                break;
            }

            row += dy[direction];
            col += dx[direction];

        }

        return new int[]{row, col};

    }


}
