package array;

public class ArrayFunctions {
    public static void printArray(int[] array){
        for(int i = 0; i<array.length; i++){
            System.out.print(i+": "+array[i]+", ");
            if(i%10==0 && i!=0) System.out.print("\n");
        }
        System.out.print("\n");
    }
    public static int find(int what, int[] array){
        for(int i = 0; i<array.length;i++){
            if(array[i]==what) return i;
        }
        return 0;
    }
    public static int[] delete(int i, int[] array){
        for(; i<array.length-1; i++){
            array[i] = array[i+1];
        }
        array[array.length-1] = 0;
        return array;
    }
    public static int[] insert(int i, int what, int[] array){
        for(i=i+1; i<array.length+1; i++){
            array[i-1] = array[i];
        }
        array[i] = what;
        return array;
    }
}
