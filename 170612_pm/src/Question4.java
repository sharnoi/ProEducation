import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170612_pm/src/input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] matSize = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<matSize.length;i++){
			matSize[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] result = new int[n][n];
//		for(int m=0; m<n; m++){
//			result[m][m] = 0;
//		}
		
		for(int m1=1; m1<n; m1++){
			for(int m2=0; m2+m1<n; m2++){
				int min = 100*100*100*500;
				for(int c=0; c<m1; c++){
					min = Math.min(min, result[m2][m2+c] + result[m2+c+1][m1+m2] + (matSize[m2] * matSize[m2+c+1] * matSize[m1+m2+1])); 
				}
				result[m2][m1+m2] = min;
			}
		}
		
		System.out.println(result[0][n-1]);
	}
}