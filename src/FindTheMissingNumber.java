public class FindTheMissingNumber {
    public static int findMissingNumUsingSum(int[] arr, int n){
        int sum=n*(n+1)/2;
        for (int i=0;i<n-1;i++){
            sum=sum-arr[i];
        }
        return sum;
    }

    public static int findMissingNumUsingXor(int[] arr, int n){
        int xor1=0;
        int xor2=0;
        for (int i=0;i<n-1;i++){
            xor1=xor1^arr[i];
            xor2=xor2^(i+1);
        }
        // we need to xor with n as well as it is done till n-1;
        xor2=xor2^n;
return xor1^xor2;
    }

    public static void main(String[] args) {
        System.out.println(findMissingNumUsingSum(new int[]{1, 2, 4, 5},5));
        System.out.println(findMissingNumUsingXor(new int[]{1, 2, 4, 5},5));

    }
}
