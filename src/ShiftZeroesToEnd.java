import java.util.Arrays;

public class ShiftZeroesToEnd {
    public static int[] moveZeroesToEndBruteforce(int[] arr){
       int[] nonZeroArr= Arrays.stream(arr).filter(x->x!=0).toArray();
       for (int i=0;i<arr.length;i++){
           if(i<nonZeroArr.length) {
               arr[i]=nonZeroArr[i];
           }
           else arr[i]=0;
       }
       return arr;
    }

    public static int[] moveZeroesToEndOptimal(int[] arr) {
        /*int leftPointer=0;
        int rightPointer=1;

        while (rightPointer<arr.length){
            // Or we can find first the index of first zero then start from there.
            if (arr[leftPointer]!=0){
                leftPointer++;
                rightPointer++;
            } else if (arr[rightPointer]==0) {
                rightPointer++;
            } else {
                arr[leftPointer]=arr[rightPointer];
                arr[rightPointer]=0;
                leftPointer++;
                rightPointer++;
            }
        }*/
        // 2nd way of doing this.
        int j=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==0) {
                j=i;
                break;
            }
        }
        // Now Start the swaping.
        for (int i=j+1;i<arr.length;i++){
            if(arr[i]!=0){
                arr[j]=arr[i];
                arr[i]=0;
                j++;
            }
        }
      return arr;
    }

        public static void main(String[] args) {
Arrays.stream(moveZeroesToEndBruteforce(new int[]{1,0,2,3,2,0,0,4,5,1})).forEach(System.out::print);
            System.out.println();
            Arrays.stream(moveZeroesToEndOptimal(new int[]{1,0,2,3,2,0,0,4,5,1})).forEach(System.out::print);

    }
}
