public class BitManipulation {

    public static boolean getBit(int num, int i){
        return ((num & (1<<i)) != 0);
    }

    public static int setBit(int num, int i){
        return (num | (1<<i));
    }

    public static int clearBit(int num, int i){
        return (num & ~(1<<i));
    }

    public static void main(String[] args) {
        int num = 0b10111;
        System.out.println(getBit(num,4));
        System.out.println(setBit(num,3));
        System.out.println(clearBit(num,4));
    }
}
