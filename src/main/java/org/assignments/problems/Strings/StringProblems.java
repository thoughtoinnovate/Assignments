class StringProblems {
    
    public static String countCharsString(String input){
        String result ="";
        
        char prev='\0';
        int count=0;
        
        for(int i=0;i<input.length();i++){
            if(prev==input.charAt(i)){
                count++;
            }else{
                if(count>1){
                    result=result+count+String.valueOf(prev);
                    
                }else{
                    result=result+String.valueOf(prev);
                }
                prev=input.charAt(i);
                count=1;
            }
            
            if(i==input.length()-1){
                result+=(count>1)?count+String.valueOf(prev):String.valueOf(prev);   
            }
            
            
            
        }
        
        
        return result;
        
        
    }
    
    public static void main(String args[]) {
     String input = "abbaadda";
     System.out.println(countCharsString(input));
    }
}
