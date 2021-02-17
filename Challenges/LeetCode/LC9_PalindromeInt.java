public class LC9_PalindromeInt{
    // String
    public static boolean isPalindrome(int x) {
        String stringint = x + "";
        int i = 0;
        while(i < (stringint.length()/2)){
            if(stringint.charAt(i) != stringint.charAt(stringint.length()-1-i)){
                return false;
            }
            i++;
        }
        return true;
    }

    // Int
    public static boolean isPalindromeInt(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversedHalf = 0;
        while (reversedHalf < x){
            reversedHalf *= 10;
            reversedHalf += (x % 10);
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf/10;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
        System.out.println(isPalindrome(2147483647));

        System.out.println(isPalindromeInt(121));
        System.out.println(isPalindromeInt(-121));
        System.out.println(isPalindromeInt(10));
        System.out.println(isPalindromeInt(-101));
        System.out.println(isPalindromeInt(2147483647));
        System.out.println(isPalindromeInt(0));
    }
}