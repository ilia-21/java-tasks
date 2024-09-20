package array;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];

        for(int i = 0; i<array.length; i++){
            array[i] = (int) Math.floor(Math.random()*100);
        }
        ArrayFunctions.printArray(array);
        int found = ArrayFunctions.find(69, array);
    }
}

