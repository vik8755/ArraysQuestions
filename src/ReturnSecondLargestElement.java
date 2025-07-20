public class ReturnSecondLargestElement {
    public static int secondLargestElement(int[] nums) {
        int max=nums[0];
        int sMax=0;
        for (int i=0;i<nums.length;i++){
            if(max<nums[i]){
                sMax=max;
                max=nums[i];
            }
        }
        return sMax;

    }

    public static void main(String[] args) {

        System.out.println(secondLargestElement(new int[]{3, 3, 6, 1}));
}
}
