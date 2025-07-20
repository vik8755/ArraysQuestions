import java.util.Arrays;

public class ReturnMaxElement {
    public static int largestElement(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(largestElement(new int[]{3, 3, 6, 1}));
    }
}
