public class ReverseInteger_7 {

    public static int reverse(int x){
        long result = 0;
        while(Math.abs(x) > 0){
            result*=10;
            result+=(x%10);
            x /= 10;
        }
        if (Math.abs(result) > Integer.MAX_VALUE){
            return 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1000000052));
    }
}
