//Fibo using memorization
	public static int fibo(int n,int[] dp) {
		if(n==0 || n==1) {
			return n;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		int ans= fibo(n-1,dp) + fibo(n-2,dp);
		dp[n]=ans;
		return ans;
	}
	
	//Fibo using tabulation
		public static int fiboT(int n,int[] dp) {
			for(int i=0;i<n;i++) {
				if(i<=1) {
					dp[i] = n;
					continue;
				}
				int ans= dp[i-1] + dp[i-2];
				dp[i]=ans;
			}
			return dp[n];
		}
	
	//Fibo using Iteration
	public static int FiboOpti(int n) {
		int a=0;
		int b=1;
		for(int i=0;i<n;i++) {
			int sum=a+b;
			a=b;
			b=sum;
		}
		return a;
	}
	
	
	
	//two moves are allowed memorization
	public static int Paths(int sx,int sy,int ex,int ey,int[][] dp) {
		if(sx==ex && sy==ey) {
			return 1;
		}
		int count=0;
		if(dp[sx][sy]!=0) {
			return dp[sx][sy];
		}
		if(sx+1<=ex) {
			count+=Paths(sx+1,sy,ex,ey,dp);
		}
		if(sy+1<=ey) {
			count+=Paths(sx,sy+1,ex,ey,dp);
		}
		dp[sx][sy]=count;
		return count;
	}
