public class ZigZagConversion_6{

    // Naive
    public static String convert(String s, int numRows){
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }
        String[] myArray = new String[numRows];
        int direction = 1;
        int row = 0;
        for (int i = 0; i < s.length(); i += 1) {
            if(myArray[row] == null){
                myArray[row] = "";
            }
            myArray[row] = myArray[row] + s.charAt(i); 
            
            row += direction;
            if(row == 0 || row == numRows-1){
                direction *= -1;
            }
        }
        String string = "";
        for (int i = 0; i < numRows; i++) {
            string += myArray[i];
        }
        return string;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 2));
    }

}