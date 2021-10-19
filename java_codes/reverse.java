public int reverse(int input) {
        int reverse = 0 ;
        int pop;
        
        while(input != 0){
            //get last number 123 = 3
            pop = input % 10;
            
            //get front number 123 = 12
            input /= 10;
            
            //validte if bigger than int 32bit
            if(reverse > Integer.MAX_VALUE /10){
                return 0;
            }
            
            //validate if smaller than int 32bit
            if(reverse < Integer.MIN_VALUE /10){
                return 0;
            }
            
            
            //0 * 10 = 0 + 3 = 3
            //3 * 10 = 30 + 2 = 32
            //32 * 10 = 320 + 1 = 321 
            reverse = (reverse * 10) + pop;        
        }
        

      return reverse;    
        
    }
