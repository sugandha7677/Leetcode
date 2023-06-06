class Solution {
    
    public int compress(char[] chars) {
        
        int currIdx = 0;
        
        int idx = 0;
        
        while(idx < chars.length){
            char ch = chars[idx++];
            chars[currIdx++] = ch;
            int count = 1;
            
            while(idx < chars.length && chars[idx] == ch ){
                idx++;
                count++;
            }
            
            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[currIdx++] = c;
                }
            }
        }
        
        return currIdx;
        
    }
    
    
}