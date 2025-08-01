import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public static List<Integer> intersectionOfArrayOptimal(int[] arrLeft, int[] arrRight) {
       int leftLength=arrLeft.length;
        int rightLength=arrRight.length;
        int left=0;
        int right=0;
        List<Integer> intersection=new ArrayList<>();
        while (left<leftLength&&right<rightLength){
            if(arrLeft[left]==arrRight[right]){
                intersection.add(arrLeft[left]);
                left++;
                right++;
            } else if (arrLeft[left]<arrRight[right]) {
                left++;

            }else right++;

        }
return intersection;

    }

    public static void main(String[] args) {


        intersectionOfArrayOptimal(new int[]{1, 2, 2,3,3, 4, 5, 6}, new int[]{2, 3, 3, 5,6,6, 7}).forEach(System.out::print);
    }
}
