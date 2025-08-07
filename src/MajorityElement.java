import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MajorityElement {
    public static int majorityElementBruteForce(int[] arr){
        int length=arr.length;
        for (int i=0;i<length;i++){
            int count=1;
            for (int j=i+1;j<length;j++){
                if(count>=length/2) return arr[i];
                if(arr[i]==arr[j]) count++;
            }
        }
        return -1;
    }
    public static int majorityElementBetter(int[] arr){
        Map<Integer, Long> map= Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for (Map.Entry<Integer,Long> entry:map.entrySet()){
            if(entry.getValue()>=arr.length/2) return entry.getKey();
        }
        return  -1;
    }
    // Moore's Voting Algorithm.
    public static int majorityElementOptimal(int[] arr){
        int element=arr[0];
        int count=1;
        for(int i=1;i<arr.length;i++){
            if (element==arr[i]) count++;
            else if (count==0) {
                element=arr[i];
                count=1;

            }
            else count--;
        }
        // We need to verify if the element is the majority element or not.
        int verifyCount=0;
        for(int i=0;i<arr.length;i++){
            if(element==arr[i]) verifyCount++;
        }
        return verifyCount>arr.length/2?element:-1;

    }

    public static void main(String[] args) {
        System.out.println(majorityElementBruteForce(new int[]{1,1,2,3,4,3,3,1,3,3,3}));
        System.out.println(majorityElementBetter(new int[]{1,1,2,3,4,3,3,1,3,3,3}));
        System.out.println(majorityElementOptimal(new int[]{7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5}));
        System.out.println(majorityElementOptimal(new int[] {2,2,1,1,1,2,2}));

    }
}
