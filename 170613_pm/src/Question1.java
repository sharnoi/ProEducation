import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question1 {
	
    public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170613_pm/src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] numArr = new long[N];

		for(int n=0; n<N; n++){
			numArr[n] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(numArr);
		
		int maxCnt = 0;
		int cnt = 1;
		long result = 0; 
		for(int i=1; i<numArr.length; i++){
			if(numArr[i] == numArr[i-1]){
				cnt++;
			}else{
				cnt = 1;
			}
			
			if(maxCnt < cnt){
				maxCnt = cnt;
				result = numArr[i-1];
			}
		}
		
		System.out.println(result);
    }
}