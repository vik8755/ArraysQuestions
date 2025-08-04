import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static int[] twoSumBetter(int[] arr, int target){
        Map<Integer,Integer> dataHolder=new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int rem=target-arr[i];
            if(dataHolder.containsKey(rem)) return new int[]{dataHolder.get(rem),i};
            else dataHolder.put(arr[i],i);

        }
        return new int[]{};
    }

    public static int[] twoSumOptimal(int[] arr, int target){
        Arrays.sort(arr);
        int left =0;
        int right=arr.length-1;
        while (left<right){
            if(arr[left]+arr[right]==target)  return new int[]{left,right};
            else if (arr[left]+arr[right]<target) left++;
            else right--;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
       Arrays.stream(twoSumBetter(new int[]{ 2, 6,5,8,11},14)).forEach(System.out::println);
        Arrays.stream(twoSumOptimal(new int[]{ 2, 6,5,8,11},14)).forEach(System.out::println);

    }
}
