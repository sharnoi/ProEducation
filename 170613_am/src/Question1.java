import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question1 {
	static int count = 0;
	
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/SDS/workspace/170613_am/src/input.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
        setQueen(a, 0);
		
		System.out.println(count);
    }
	
    public static boolean isQueenPossible(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) return false;
            if ((q[i] - q[n]) == (n - i)) return false;
            if ((q[n] - q[i]) == (n - i)) return false;
        }
        return true;
    }

    public static void setQueen(int[] q, int n) {
        if (n == q.length) {
            count++;
        } else {
            for (int i = 0; i < q.length; i++) {
                q[n] = i;
                if (isQueenPossible(q, n)){ 
                	setQueen(q, n + 1);
                }
            }
        }
    }
}

