import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Question3 {
	static int N;
	static int[] numArr;
	static int[] tempArr;
	
    public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170613_pm/src/input3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		tempArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++){
			numArr[n] = Integer.parseInt(st.nextToken());
		}
		long result = calInversion(0, numArr.length-1); 
		
		System.out.println(result);
    }

	private static long calInversion(int start, int end) {
		if(start == end){
			return 0;			
		}
		
		int mid = (start+end)/2;
		long cnt1 = calInversion(start, mid);
		long cnt2 = calInversion(mid+1, end);
		long cnt = merge(start, end, mid);
		
		return cnt1+cnt2+cnt;
	}

	private static long merge(int start, int end, int mid) {
		
//		System.arraycopy(numArr, start, tempArr, start, end-start+1);
		for(int i=start; i<=end; i++){
			tempArr[i] = numArr[i];
		}
			
		int i=start, j=mid+1, temp=start;
		long cnt = 0L;
		while(i <= mid && j <= end){
			if(tempArr[i] <= tempArr[j]){
				numArr[temp++] = tempArr[i++];
			}else{
				numArr[temp++] = tempArr[j++];
				cnt += (long)(mid+1-i);
			}
		}
		
		while(i<=mid){
			numArr[temp++] = tempArr[i++];
		}
		while(j<=end){
			numArr[temp++] = tempArr[j++];
		}
		return cnt;
	}
}