import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOnlyAppearOnce {
    public static int appearOnlyOnceBrute(int[] arr){

        for(int i=0;i<arr.length;i++){
            int count=0;
            for (int j=0;j<arr.length;j++){
                if (arr[i]==arr[j]) count++;
            }
            if (count==1) return arr[i];
        }
        return -1;
    }

    public static int appearOnlyOnceBetter(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int j : arr) {
            int value = map.getOrDefault(arr[j], 0);
            map.put(arr[j], value + 1);
        }
        Map.Entry<Integer,Integer> entry =map.entrySet().stream().filter(x->x.getValue()==1).findFirst().get();
    return entry.getKey();
    }

    public static int appearOnlyOnceOptimal(int[] arr){
        int xor=0;
        // As we know 1^1=0 so those numbers appears twice that xor is 0
        for (int num:arr){
            xor=xor^num;
        }
        return xor;
    }

    public static void main(String[] args) {
     System.out.println(appearOnlyOnceBrute(new int[]{1,1,2,3,3,4,4,5,5}));
        System.out.println(appearOnlyOnceBetter(new int[]{1,1,2,3,3,4,4,5,5}));
        System.out.println(appearOnlyOnceOptimal(new int[]{1,1,2,3,3,4,4,5,5}));


    }
}
