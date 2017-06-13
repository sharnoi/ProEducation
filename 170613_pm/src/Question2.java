import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Question2 {
	
    public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170613_pm/src/input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		long xnm = (long)x * 10000000L;
		
		long[] L = new long[N];
		for(int n=0; n<N; n++){
			L[n] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(L);
		
		long result = -1L;
		long L1=0, L2=0;
		int i=0, j=L.length-1;
		while(i < j){
			if(L[i] + L[j] == xnm){
				if(result < Math.abs(L[i]-L[j])){
					result = Math.abs(L[i]-L[j]);
					L1 = L[i];
					L2 = L[j];
				}
				j--;
				i++;
			}else if(L[i] + L[j] > xnm){
				j--;
			}else{
				i++;
			}
		}
//		for(int i=0; i<N-1; i++){
//			for(int j=i+1; j<N; j++){
//				if(L[i] + L[j] == xnm){
//					if(result < Math.abs(L[i]-L[j])){
//						result = Math.abs(L[i]-L[j]);
//						L1 = L[i];
//						L2 = L[j];
//					}
//				}
//			}
//		}
		
		if(result == -1L){
			System.out.println("danger");
		}else{
			System.out.println("yes " + L1 + " " + L2);
		}
    }
}