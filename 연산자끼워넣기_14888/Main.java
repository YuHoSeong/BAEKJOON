package 연산자끼워넣기_14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, tmp, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] input, operator = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수
        N = Integer.parseInt(br.readLine());

        // 수열
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 {+, -, *, /}
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(input[0], 1);

        System.out.println(max);
        System.out.println(min);
    }
    
    static void dfs(int num, int idx) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {

                // 해당 연산자를 1 감소 시킨다.
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(num + input[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - input[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * input[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / input[idx], idx + 1);
                        break;
                }

                // 다음 연산을 위한 연산자 개수 복구
                operator[i]++;
            }
        }
    }
}
