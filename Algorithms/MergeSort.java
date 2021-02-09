public class MergeSort {
    public static void mergeSort(int[] array){
        int[] spareArray = new int[array.length];
        mergeSort(array, spareArray, 0, array.length-1);
    }

    public static void mergeSort(int[] array, int[] spareArray, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(array, spareArray, low, mid);
            mergeSort(array, spareArray, mid+1, high);
            merge(array, spareArray, low, mid, high);
        }
    }

    public static void merge(int[] array, int[] spareArray, int low, int mid, int high){
        for (int i = low; i <= high; i++) {
            spareArray[i] = array[i];
        }

        int currentLeft = low;
        int currentRight = mid + 1;
        int index = low;

        while(currentLeft <= mid && currentRight <= high){
            if(spareArray[currentLeft] <= spareArray[currentRight]){
                array[index] = spareArray[currentLeft];
                currentLeft++;
            }
            else{
                array[index] = spareArray[currentRight];
                currentRight++;
            }
            index++;
        }

        for (int i = 0; i <= (mid - currentLeft); i++) {
            array[index+i] = spareArray[currentLeft + i];
        }
    }


    public static void main(String[] args) {
        int[] a = {9,5,7,10,3,1,8,6,4,2};
        int[] b = {10,9,8,7,6,5,4,3,2,1};
        int[] c = {1,2,3,4,5,6,7,8,9,10};
        mergeSort(a);
        mergeSort(b);
        mergeSort(c);
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
