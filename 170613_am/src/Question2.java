import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question2 {
	static int T;
	static int[] dist;
	
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170613_am/src/input2.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> primeNum = new ArrayList<>();
		primeNum.add(2);
		for(int i=3; i<=10000; i++){
			boolean isPrime = true;
			for(int prime : primeNum){
				if(i%prime == 0){
					isPrime = false;
					break;
				}
			}
			
			if(isPrime){
				primeNum.add(i);
			}
		}
		
		int[] pn = new int[2];
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
			dist = new int[primeNum.size()];
			StringTokenizer st = new StringTokenizer(br.readLine());
			pn[0] = Integer.parseInt(st.nextToken());
			pn[1] = Integer.parseInt(st.nextToken());
			Arrays.sort(pn);
			
			int start = primeNum.indexOf(pn[0]);
			int end = primeNum.indexOf(pn[1]);
			
			if(pn[0] != pn[1]){
				findCourse(start, end, primeNum);
			}
			
			System.out.println(dist[end]);
		}
    }

	private static void findCourse(int start, int end, List<Integer> primeNum) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] isVisit = new boolean[primeNum.size()];
		
		que.offer(start);
		isVisit[start] = true;
		
		while(!que.isEmpty()){
			int point = que.poll();
			
			if(point == end){
				break;
			}
			
			int matchCount = 0;
			for(int i=start; i<primeNum.size(); i++){
				if(isVisit[i]){
					continue;
				}
				
				char[] p1 = String.valueOf(primeNum.get(point)).toCharArray();
				char[] p2 = String.valueOf(primeNum.get(i)).toCharArray();
				
				int count = 0;
				for(int c=0; c<4; c++){
					if(p1[c] != p2[c]){
						++count;
					}
					if(count > 1){
						break;
					}
				}
				
				if(count == 1){
					isVisit[i] = true;
					dist[i] = dist[point] + 1;
					que.offer(i);
				}
			}
		}
	}
}