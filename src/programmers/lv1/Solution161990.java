package programmers.lv1;

public class Solution161990 {

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) {
        Solution161990 s = new Solution161990();
        s.solution(args);
    }

    public int[] solution(String[] wallpaper) {

        /**
         *  1. 입력된 Input의 가로세로 배열 크기를 구한다.
         */
        int row = wallpaper.length;
        int col = wallpaper[0].length();

        char[][] copyWallPaper = new char[row][col];

        /**
         *  2. Wallpaper의 값을 복사본으로 옮겨담는다.
         */
        for(int i = 0; i < row; i++) {
            for (String s : wallpaper) {
                copyWallPaper[i] = s.toCharArray();
            }
        }

        int minRowIdx = 0;
        int maxRowIdx = 0;
        int minColIdx = 0;
        int maxColIdx = 0;

        /**
         *  3. '#' 의 좌표 최대 최소값을 구한다.
         */
        for(int i = 0; i < row; i++) {
            for(int j = 0 ; j < col; j++) {
                if(copyWallPaper[i][j] == '#') {
                    minRowIdx = Math.min(minRowIdx, i);
                    maxRowIdx = Math.max(maxRowIdx, i);
                    minColIdx = Math.min(minColIdx, j);
                    maxColIdx = Math.max(maxColIdx, j);
                }
            }
        }

        int[] answer = {minRowIdx, minColIdx, maxRowIdx+1, maxColIdx+1};
        return answer;
    }

}
