public class QuickSort {

    public static void quicksort(int[] array){
        quicksortRecursive(array, 0, array.length-1);
    }

    public static void quicksortRecursive(int[] array, int left, int right){
       int partitionIndex = partition(array, left, right);

        if(left < partitionIndex-1){
            quicksortRecursive(array, left, partitionIndex-1);
        }
        if(right > partitionIndex+1){
            quicksortRecursive(array, partitionIndex+1, right);
        }

    }

    public static int partition(int[] array, int left, int right){
        int pivot = array[right];
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if(array[i] <= pivot){
                swapElements(array, i, partitionIndex++);
            }
        }
        swapElements(array, partitionIndex, right);
        return partitionIndex;
    }

    public static void swapElements(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {9,5,7,10,3,1,8,6,4,2};
        int[] b = {10,9,8,7,6,5,4,3,2,1};
        int[] c = {1,2,3,4,5,6,7,8,9,10};
        quicksort(a);
        quicksort(b);
        quicksort(c);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", "); 
        }  
        System.out.println("");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + ", "); 
        }
        System.out.println("");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + ", "); 
        }
    }
}
