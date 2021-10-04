//we need to pay a amount with a fix coins, how many ways are there
		public static void dice2(int q,int[] arr,int[] dp,String path) {
			if(q==0) {
				System.out.println(path);
				return;
			}
			for(int i=0;i<arr.length;i++) {
				if(q-arr[i]>=0) {
					dice2(q-arr[i],arr,dp,path+arr[i]);
				}
			}
		}
		
		//we need to pay a amount with a fix coins, how many ways are there
		public static int dice2(int q,int[] arr,int[] dp) {
			if(q==0) {
				return 1;
			}
			int count=0;
			for(int i=0;i<arr.length;i++) {
				if(q-arr[i]>=0) {
					count+=dice2(q-arr[i],arr,dp);
				}
			}
			return count;
		}
		
		//we need to pay a amount with a fix coins, how many ways are there=== problem
		public static int dice2T(int q,int[] arr,int[] dp) {
			for(int i=q;i>=0;i--) {
				if(i==q) {
					dp[i]=1;
					continue;
				}
				int count=0;
				for(int j=0;j<arr.length;j++) {
					if(i+arr[j]<=q) {
						count+=dp[i+arr[j]];
					}
				}
				dp[i]=count;
			}
			return dp[0];
		}
			
		//board path=== going from 0 to ei, with a dice... no. of combination
		public static int boardPath_opti(int ei) {
	        LinkedList<Integer> ll = new LinkedList<>();

	        for (int si = 0; si <= ei; si++) {
	            if (si < 2) {
	                ll.addFirst(1);
	                continue;
	            }

	            if (ll.size() <= 6)
	                ll.addFirst(2 * ll.getFirst());
	            else {
	                ll.addFirst(2 * ll.getFirst() - ll.getLast());
	                ll.removeLast();
	            }
	        }

	        return ll.getFirst();
	    }
		
	//GoldMine
//	public static int max=0;
	public static int goldmine(int[][] mine,int sx,int sy,int[][] dp) {
		if(sy==mine[0].length-1) {
			return mine[sx][sy];
		}
		if(dp[sx][sy]!=0) {
			return dp[sx][sy];
		}
		int max=0;
		int a=Integer.MIN_VALUE;
		int b=Integer.MIN_VALUE;
		int c=Integer.MIN_VALUE;
		if(sx>0) {
			a=goldmine(mine,sx-1,sy+1,dp);
		}
		b=goldmine(mine,sx,sy+1,dp);
		if(sx<mine[0].length-1) {
			c=goldmine(mine,sx+1,sy+1,dp);
		}
		max=mine[sx][sy] + Math.max(a, Math.max(b, c));
		dp[sx][sy]=max;
		return max;
	}
