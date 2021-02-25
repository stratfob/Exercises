public class LC11_ContainerWithMostWater{

    //Naive
    public static int maxArea(int[] height){
        int maxSoFar = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int minOfHeights = Math.min(height[i],height[j]);
                maxSoFar = Math.max(maxSoFar, minOfHeights * (j-i));
            }
        }
        return maxSoFar;
    }

    //Improved
    public static int maxArea2(int[] height){
        int maxSoFar = 0;
        int pointerLeft = 0;
        int pointerRight = height.length-1;
        while (pointerLeft < pointerRight){
            int minOfHeights = Math.min(height[pointerLeft],height[pointerRight]);
            maxSoFar = Math.max(maxSoFar, minOfHeights * (pointerRight-pointerLeft));
            if(height[pointerLeft]<height[pointerRight]){
                pointerLeft++;
            }
            else{
                pointerRight--;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[] {1,1}));
        System.out.println(maxArea(new int[] {4,3,2,1,4}));
        System.out.println(maxArea(new int[] {1,2,1}));

        System.out.println(maxArea2(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea2(new int[] {1,1}));
        System.out.println(maxArea2(new int[] {4,3,2,1,4}));
        System.out.println(maxArea2(new int[] {1,2,1}));
    }
}