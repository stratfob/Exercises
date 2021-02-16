
public class LC8_atoi {
    public static int myAtoi(String s){
        String trim = s.trim();
        int i = 0;
        
        try{
            if(trim.charAt(i) == '+' || trim.charAt(i) == '-') i++;
            while(i < trim.length() && trim.charAt(i) >= '0' && trim.charAt(i) <= '9'){
                i++;
            }
            trim = trim.substring(0, i);
            double l = Double.parseDouble(trim);
            if (l > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else if (l < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            else{
                return (int) l;
            }
        }
        catch(Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("      -42"));
        System.out.println(myAtoi("42 with words"));
        System.out.println(myAtoi("words with 42"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("91283472332"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi("  -0012a42"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("21474836460"));
    }
}
