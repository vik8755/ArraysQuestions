public class MaxCountOfOnes {
    public static int maxCountOfOne(int[] arr){
        int count=0; int max=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==1)count++;
            else if (count>max) {
                max=count;
                count=0;
            }
        }
        return Math.max(count,max);
    }

    public static void main(String[] args) {
        System.out.println(maxCountOfOne(new int[]{1,1,0,1,1,1,0,0,1,1,1,1}));
    }
}
