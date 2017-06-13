import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question1 {

	public static void main(String[] args) throws Exception {
		int N;
//		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170612_pm/src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[] cost = new int[N+1];
		int[] result = new int[N+1];
		cost[0] = 0;
		result[0] = 0;
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++){
			cost[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=N; i++){
			int max = 0;
			for(int j=0; j<i; j++){
				max = Math.max(max, result[j] + cost[i-j]);
			}
			result[i] = max;
		}
		
		System.out.println(result[N]);
	}
}
