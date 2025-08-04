import java.util.Arrays;

public class SortAnArrayOf01and2 {
    public static int[] sortBetter(int[] arr){
        int countOf0=0,countOf1=0,countOf2=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==0) countOf0++;
            else if (arr[i]==1) countOf1++;
            else countOf2++;
        }

        for (int i=0;i<countOf0;i++) arr[i]=0;
        for (int i=countOf0;i<countOf0+countOf1;i++) arr[i]=1;
        for (int i=countOf0+countOf1;i<countOf0+countOf1+countOf2;i++) arr[i]=2;
        return arr;
    }
    public static int[] sortOptimal(int[] arr){
       int left=0;
       int mid=0;
       int right=arr.length-1;
       while (mid<=right){
           if(arr[mid]==0){
               swap(arr,left,mid);
               left++;
               mid++;
           } else if (arr[mid]==1) mid++;
           else {
               swap(arr,mid,right);
               right--;
           }
       }
       return arr;
    }
    public static void swap(int[] arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        Arrays.stream(sortBetter(new int[]{0,1, 2,0, 1,2,1,2,0,0,0,1})).forEach(System.out::println);
        Arrays.stream(sortOptimal(new int[]{0,1, 2,0, 1,2,1,2,0,0,0,1})).forEach(System.out::println);

    }
}
