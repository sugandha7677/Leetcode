class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        
        return findSum(num);
        
    }
    int findSum(int num){
            
        int digitSum = 0;
        while(num > 0){
            digitSum += num % 10;
            num /= 10;
        }
        
        if(Integer.toString(digitSum).length() > 1) return findSum(digitSum);
        
        return digitSum;
    }
}