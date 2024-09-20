package sort;

public class Bubble {
    public static void iteration(int[] array){
        for (int i = 0; i<array.length-1; i++){
            if (array[i]>array[i+1]){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
    }
    public static boolean check(int[] array){
        boolean sorted = true;
        for (int i = 0; i<array.length-1; i++){
            if (array[i] > array[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}
