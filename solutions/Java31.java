// 31. 수박수박수박수박수박수?

class Solution {
    public String solution(int n) {
        String str = "수박";
        
        return (n%2==1 ? str.repeat((n/2)) + "수" : str.repeat((n/2)));
    }
}