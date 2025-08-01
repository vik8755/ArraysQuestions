import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class UnionOfTwoSortedArrays {

    public static int[] unionOfArrayBruteForce(int[] arra, int[] arrb ){
        int lenghtA=arra.length;
        int lenghtB =arrb.length;
        LinkedHashSet<Integer> temp=new LinkedHashSet<>(Math.max(lenghtA, lenghtB));
        for (int i=0;i<lenghtA;i++){
            temp.add(arra[i]);
        }
        for (int i=0;i<lenghtB;i++){
            temp.add(arrb[i]);
        }
        // Sort it at the end or use TreeSet.
        return temp.stream().mapToInt(Integer::intValue).sorted().toArray();

    }
    public static List<Integer> unionOfArrayOptimal(int[] arra, int[] arrb ) {
        int lenghtA=arra.length;
        int lenghtB =arrb.length;
        int left=0;
        int right=0;
        List<Integer> union=new ArrayList<>();
        while (left<lenghtA && right<lenghtB){
            if(arra[left]<arrb[right]){
                if (union.contains(arra[left])) left++;
                else {
                    union.add(arra[left]);
                    left++;
                }
            }
            else {
                if (union.contains(arrb[right])) right++;
                else{
                    union.add(arrb[right]);
                    right++;
                }
            }
        }
        while (left<lenghtA){
            if (union.contains(arra[left])) left++;
            else {
                union.add(arra[left]);
                left++;
            }
        }
        while (right<lenghtB){
            if (union.contains(arrb[right])) right++;
            else {
                union.add(arrb[right]);
                right++;
            }
        }
        return union;
    }

        public static void main(String[] args) {
       Arrays.stream(unionOfArrayBruteForce(new int[]{1,1,3,4,5,6},new int[]{2,2,9,4,9})).forEach(System.out::print);
            System.out.println();
            unionOfArrayOptimal(new int[]{1,1,3,4,5,6},new int[]{2,2,9,4,9}).forEach(System.out::print);

    }
}
