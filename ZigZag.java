class Solution {
    public String convert(String s, int numRows) {
    
        char[] c=s.toCharArray();
        StringBuilder sb[]=new StringBuilder[numRows];
        
        
        for(int i=0;i<numRows;i++){
            sb[i]=new StringBuilder();
        }
        
        int i=0;
        int len=s.length();
        while(i<s.length()){
            
            for(int id=0;id<numRows && i<len;id++){
                
                sb[id].append(c[i]);
                i++;
            }
            for(int id=numRows-2;id>=1 &&i<len;id--){
                sb[id].append(c[i]);
                i++;
            }
        }
        for(int j=1;j<sb.length;j++){
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }
}