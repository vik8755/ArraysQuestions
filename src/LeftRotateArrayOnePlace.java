import java.util.Arrays;

public class LeftRotateArrayOnePlace {
    public static int[] leftRotatedArray(int[] arr) {
        int firstElement = arr[0];
        for (int i = 1; i < arr.length; i++) arr[i - 1] = arr[i];
        arr[arr.length - 1] = firstElement;
        return arr;
    }

    public static void main(String[] args) {

        Arrays.stream(leftRotatedArray(new int[]{1,2,3,4,5,6,7,8,9,10})).forEach(System.out::println);
    }
}