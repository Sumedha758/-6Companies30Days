class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        if(m > n){
            return gcdOfStrings(str2, str1);
        }else if(m == 0){
            return str1;
        }else if(!(str1+str2).equals(str2+str1)){
            return "";
        }else{
            return gcdOfStrings(str1.substring(m), str2);
        }
    }
}
