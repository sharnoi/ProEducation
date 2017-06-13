import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question2 {

	public static void main(String[] args) throws Exception {
		int n, e1, e2, x1, x2;
//		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170612_pm/src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		e1 = Integer.parseInt(st.nextToken());
		e2 = Integer.parseInt(st.nextToken());
		x1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		
		int[] s1 = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			s1[i] = Integer.parseInt(st.nextToken());			
		}
		
		int[] s2 = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			s2[i] = Integer.parseInt(st.nextToken());			
		}
		
		int[] t1 = new int[n-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++){
			t1[i] = Integer.parseInt(st.nextToken());			
		}
		
		int[] t2 = new int[n-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n-1; i++){
			t2[i] = Integer.parseInt(st.nextToken());			
		}
		
		int[][] curValue = new int[2][2];
		curValue[0][0] = e1+s1[0];
		curValue[0][1] = e2+s2[0];
		
		for(int i=1; i<n; i++){
			curValue[1][0] = Math.min(curValue[0][0] + s1[i], curValue[0][1] + t2[i-1] + s1[i]);
			curValue[1][1] = Math.min(curValue[0][1] + s2[i], curValue[0][0] + t1[i-1] + s2[i]);
			
			curValue[0][0] = curValue[1][0];
			curValue[0][1] = curValue[1][1];
		}
		
		System.out.println(Math.min(curValue[0][0]+x1, curValue[0][1]+x2));
	}
}