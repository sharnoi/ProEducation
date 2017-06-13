import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question3 {
	static char[] input1;
	static char[] input2;
	static int[][] result;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170612_pm/src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input1 = br.readLine().toCharArray();
		input2 = br.readLine().toCharArray();
		
		if(input1.length > input2.length){
			char[] temp = input1;
			input1 = input2;
			input2 = temp;
		}
		
		result = new int[input1.length+1][input2.length+1];
//		for(int i=0; i<input1.length+1; i++){
//			result[i][0] = 0;
//		}
//		for(int j=0; j<input2.length+1; j++){
//			result[0][j] = 0;
//		}
		
		for(int i=1; i<=input1.length; i++){
			char c1 = input1[i-1];
			for(int j=1; j<=input2.length; j++){
				char c2 = input2[j-1];
				if(c1 == c2){
					result[i][j] = result[i-1][j-1]+1;
				}else{
					result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		int i = input1.length;
		int j = input2.length;
		while(true){
			int val = result[i][j];
			if(val == 0){
				break;
			}
			if(val == result[i][j-1]){
				--j;
				continue;
			}else if(val == result[i-1][j]){
				--i;
				continue;
			}else{
				sb.append(input2[j-1]);
				--i;
				--j;
			}
		}
		
		System.out.println(sb.reverse().toString());
	}
}