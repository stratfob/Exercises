public class BinarySearch{

    public static int binarySearch(int[] a, int x){
        int low = 0;
        int high = a.length - 1;
        int mid;
        
        while(low <= high){
            mid = (low + high) / 2;
            if(a[mid] < x) {
                low = mid + 1;
            } else if(a[mid] > x){
                high = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] a, int x, int low, int high){
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if(mid >= a.length) return -1;
        if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
        } else {
            return mid;
        }
    } 

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(array,5));
        System.out.println(binarySearchRecursive(array,5, 0, array.length));
        System.out.println(binarySearch(array,11));
        System.out.println(binarySearchRecursive(array,11, 0, array.length));
        System.out.println(binarySearch(array,-5));
        System.out.println(binarySearchRecursive(array,-5, 0, array.length));
    }
}