import java.util.Arrays;

public class LeftRotateArrayDPlaces {
    public static int[] shiftDPlacesBruteForce(int[] arr, int d){
        int length=arr.length;
        // We know that if we rotate original array by d=length places
        // then we got the original array so for large d we need to calculate small d.

        d=d%length;
        int[] temp=new int[d];
        for (int i=0;i<d;i++){
            temp[i]=arr[i];
        }
        for(int i=d;i<length;i++){
            arr[i-d]=arr[i];
        }

        for (int i=length-d;i<length;i++){
            arr[i]=temp[i-(length-d)];
        }
        return arr;
    }

    public static int[] shiftDPlacesOptimal(int[] arr, int d) {
        // Reverse the array upto d-1.
        reverse(arr,0,d-1);
        //Reverse the array from D+1 to end.
        reverse(arr,d,arr.length-1);
        return reverse(arr,0,arr.length-1);

    }

     static int[] reverse(int[] arr,int left, int right){
        while (left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        return arr;
     }
        public static void main(String[] args) {

        Arrays.stream(shiftDPlacesBruteForce(new int[]{1,2,3,4,5,6,7,8,9,10},2)).forEach(System.out::print);
            System.out.println();
            Arrays.stream(shiftDPlacesOptimal(new int[]{1,2,3,4,5,6,7,8,9,10},2)).forEach(System.out::print);

        }
}
