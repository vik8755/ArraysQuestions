import java.util.HashMap;

public class LongestSubArrayWithSumKPositive {
    public static int longestSubArrayBrute(int[] arr, int k){
        int length=0;
        for (int i=0;i<arr.length;i++){
            int sum=0;
            for (int j=i;j<arr.length;j++){
                sum+=arr[i];
                if(sum==k) length=Math.max(length,j-i+1);
            }
        }
        return length;

    }

    public static int longestSubArrayBetter(int[] arr, int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixSum=0;
        int length=0;
                for (int i=0;i<arr.length;i++){
                    prefixSum+=arr[i];
                    if(prefixSum==k){
                        length=i+1;
                        map.put(prefixSum,i);
                    }
                    int rem=prefixSum-k;
                    if (map.containsKey(rem)) {
                        length=Math.max(length,i-map.get(rem));

                    }
                    // this will not update if our array contains 0. Hence,
                    // gives the correct results for 0's.
                    if(!map.containsValue(prefixSum)){
                        map.put(prefixSum,i);
                    }

                }
                return length;

    }

    public static int longestSubArrayOptimal(int[] arr, int k){
        int left=0;
        int right=0;
        int sum =0;
        int length=0;
        while (right<arr.length ){
            sum+=arr[right];
            while (left<=right&&sum>k){
                sum-=arr[left];
                left++;
            }
           if(sum==k){
               length=Math.max(length,right-left+1);
               right++;
           }
            else {
                right++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
       System.out.println(longestSubArrayBrute(new int[]{1,2,3,1,1,1,1,4,2,3},3));
        System.out.println(longestSubArrayBetter(new int[]{1,2,3,1,1,1,1,4,2,3},3));
        System.out.println(longestSubArrayOptimal(new int[]{1,2,3,1,1,1,1,4,2,3},3));
        System.out.println(longestSubArrayOptimal(new int[]{1,2,3,1,1,1,1,3,3},6));

    }
}
