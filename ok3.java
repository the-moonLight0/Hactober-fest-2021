//left , down and diagonal are allowed memorization
	public static int Paths2(int sx,int sy,int ex,int ey,int[][] dp) {
		if(sx==ex && sy==ey) {
			return 1;
		}
		int count=0;
		if(dp[sx][sy]!=0) {
			return dp[sx][sy];
		}
		if(sx+1<=ex) {
			count+=Paths2(sx+1,sy,ex,ey,dp);
		}
		if(sy+1<=ey) {
			count+=Paths2(sx,sy+1,ex,ey,dp);
		}
		if(sy+1<=ey && sx+1<=ex) {
			count+=Paths2(sx+1,sy+1,ex,ey,dp);
		}
		dp[sx][sy]=count;
		return count;
	}
	
	//left , down and diagonal are allowed tabulation
		public static int Paths2T(int sx,int sy,int ex,int ey,int[][] dp) {
			for(sx=ex;sx>=0;sx--) {
				for(sy=ey;sy>=0;sy--) {
					if(sx==ex && sy==ey) {
						dp[sx][sy]=1;
						continue;
					}
					int count=0;
					if(sx+1<=ex) {
						count+=dp[sx+1][sy];
					}
					if(sy+1<=ey) {
						count+=dp[sx][sy+1];
					}
					if(sy+1<=ey && sx+1<=ex) {
						count+=dp[sx+1][sy+1];
					}
					dp[sx][sy]=count;
				}
			}
			return dp[0][0];
		}
	
	
	//left and down moves are allowed in jumps
	public static int Paths3(int sx,int sy,int ex,int ey,int[][] dp) {
		if(sx==ex && sy==ey) {
			return 1;
		}
		if(dp[sx][sy]!=0) {
			return dp[sx][sy];
		}
		int count=0;
		
		for(int i=1;i<=ex;i++) {
			if(sx+i<=ex) {
				count+=Paths3(sx+i,sy,ex,ey,dp);
			}
		}
		for(int i=1;i<=ey;i++) {
			if(sy+i<=ey ) {
				count+=Paths3(sx,sy+i,ex,ey,dp);
			}
		}
		
		dp[sx][sy]=count;	
		return count;
	}
	
	//left and down moves are allowed in jumps tabulation
		public static int Paths3T(int sx,int sy,int ex,int ey,int[][] dp) {
			for(sx=ex;sx>=0;sx--) {
				for(sy=ey;sy>=0;sy--) {
					if(sx==ex && sy==ey) {
						dp[sx][sy]=1;
						continue;
					}
					int count=0;
					
					for(int i=1;i<=ex;i++) {
						if(sx+i<=ex) {
							count+=dp[sx+i][sy];
						}
					}
					for(int i=1;i<=ey;i++) {
						if(sy+i<=ey ) {
							count+=dp[sx][sy+i];
						}
					}
					dp[sx][sy]=count;	
				}
			}
			return dp[0][0];
		}
