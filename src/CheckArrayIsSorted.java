public class CheckArrayIsSorted {
    public static boolean isArraySorted(Integer[] arr){

        boolean isArraySorted=true;
        for (int arrIndex=0;arrIndex<arr.length-1;arrIndex++){
            if (arr[arrIndex]>arr[arrIndex+1]){
                isArraySorted=false;
                break;
            }
        }
        return isArraySorted;
    }
    public static void main(String[] args) {
        System.out.println(
                isArraySorted(new Integer[]{1,2,2,33,5,9,11,55}) ?
                        "Array is sorted":"Array is not sorted" );
    }
}
