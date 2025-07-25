public class RemoveDuplicates {
    public static int numberOfUniqueElements(Integer[ ] arr){
        int leftPointer=0;
        int rightPointer=1;
        int uniqueCount=0;
        while (rightPointer<arr.length){
            if (arr[leftPointer]!=arr[rightPointer]){
                leftPointer++;
                arr[leftPointer]=arr[rightPointer];
                rightPointer++;
                uniqueCount++;
            }
            else rightPointer++;
        }
        return uniqueCount;

    }

    public static void main(String[] args) {
        System.out.println(numberOfUniqueElements(new Integer[]{1,1,2,2,5,5,9,11,55}));
    }
}
