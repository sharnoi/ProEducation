import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question5 {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170612_pm/src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] coin = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++){
			coin[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(coin);
		int W = Integer.parseInt(br.readLine());
		
		int[] count = new int[W+1];
		int maxCoinIndex = 0;
		for(int i=coin[0]; i<=W; i++){
			for(int c=1; c<coin.length; c++){
				if(coin[c] > i){
						maxCoinIndex = c-1;
					break;
				}else if(c==coin.length-1){
					maxCoinIndex = coin.length-1;
					break;
				}
			}
			
			int min = 0;
			for(int cc=maxCoinIndex; cc>=0; cc--){
				int cnt=0;
				while(i-coin[cc]*cnt >= 0){
					int mod = i-(coin[cc]*cnt);
					if(count[mod] != 0 || mod == 0){
						if(min == 0){
							min = count[mod] + cnt;
						}else{
							min = Math.min(min, count[mod] + cnt);
						}
						break;
					}else{
						cnt++;
					}
				}
			}
			count[i] = min;
		}
		
		System.out.println(count[W]);
	}
}