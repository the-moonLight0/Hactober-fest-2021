// This is a codechef problem.

package CodeChef;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class BinarySubsequence {
	public static void main(String[] args) {
		// System.in and System.out are input and output streams, respectively.
		InputStream inputStream = System.in;

		InputReader in = new InputReader(inputStream);

		int t = in.nextInt();
		while (t-- != 0) {
			int n = in.nextInt();
			String s = in.next();
			int zeros=0;
			int ones=0;
			int currzeros=0;
			int currones=0;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='0') {
					zeros++;
				}
				else {
					ones++;
				}
			}
			int ans = Math.min(zeros, ones);
			for(int i=0; i<n; i++) {
				if(s.charAt(i)=='0') {
					currzeros++;
				}
				else {
					currones++;
				}
				ans = Math.min(ans, currones + (zeros-currzeros));
			}
			System.out.println(ans);
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
