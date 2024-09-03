package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BestMember {

    static int N;
    static int M;
    static int[] possibleWeight;
    static boolean[] bestMember;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        possibleWeight = new int[N];
        bestMember = new boolean[N];
        Arrays.fill(bestMember, true);

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            possibleWeight[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            findBestMember(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }

        for(int i = 0; i < N; i++) {
            if(bestMember[i]) {
                result++;
            }
        }

        System.out.println(result);

        br.close();
    }

    private static void findBestMember(int a, int b) {

        int result = Integer.compare(possibleWeight[a], possibleWeight[b]);
        // 본인의 무게가 더 적으면 false 처리
        if(result > 0) {
            bestMember[a] = bestMember[a] ? true : false;
            bestMember[b] = false;
        }else if(result == 0) {
            bestMember[a] = false;
            bestMember[b] = false;
        }else{
            bestMember[b] = bestMember[b] ? true : false;
            bestMember[a] = false;
        }


    }
}
