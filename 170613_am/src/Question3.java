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

public class Question3 {
	static int N, R, Q, x, y, count=0;
	static List<Integer>[] child;
	static int[] start, end;
	
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170613_am/src/input3.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		start = new int[2*N];
		end = new int[2*N];
		
		child = new List[N+1];
		for(int l=1; l<child.length; l++){
			child[l] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<child.length; i++){
			int parent = Integer.parseInt(st.nextToken());
			if(i==R){
				continue;
			}
			
			child[parent].add(i); 
		}
		
		start[R] = count;
		findChild(R);
		
		
		for(int q = 0; q<Q; q++){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if(x==y || (start[x] < start[y] && start[y] < end[x])){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
    }

	private static void findChild(int node) {		
		start[node] = ++count;
		List<Integer> childList = child[node];
		for(int ch : childList){
			findChild(ch);
		}
		end[node] = ++count;
	}
}