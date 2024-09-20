package sort;

public class Main {
    public static void printArray(int[] array){
        for (int j : array) {
            System.out.print(j + ", ");
            //if(i%10==0 && i!=0) System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] array = new int[20];

        for(int i = 0; i<array.length; i++){
            array[i] = (int) Math.floor(Math.random()*100);
        }
        System.out.println("Starting: ");
        printArray(array);
        for (int i = 0;!Bubble.check(array);i++){
            Bubble.iteration(array);
            System.out.println("Iteration: "+i);
            printArray(array);
        }
        System.out.println("Sorted: ");
        printArray(array);
    }
}
