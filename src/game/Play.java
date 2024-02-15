package game;

import java.nio.file.LinkPermission;
import java.util.Scanner;

import game.Allies.Knight;
import game.Allies.Miner;
import game.Allies.Rook;
import game.Classes.Entity;
import game.Classes.King;

public class Play {
    public static Scanner input = new Scanner(System.in);
    static int entityCap = 50;
    public static int[] entityCount = {0,0};
    String currentPage = "Main";
    public static Entity[] allies = new Entity[entityCap/2];
    public static Entity[] enemies = new Entity[entityCap/2];
    public static void printInfo(){
        System.out.printf("У вашего короля %d золота и %d здоровья.%n", Core.gold, King.getHP());
        System.out.println("Выберите ваше действие:");
        System.out.println("1 - Нанять шахтера (100 Золота)");
        System.out.println("2 - Нанять пехотинца (10 Золота)");
        System.out.println("3 - Нанять рыцаря (50 Золота)");
        System.out.println("4 - Узнать информацию о нанятых ("+entityCount[0]+")");
        System.out.println("5 - Узнать информацию о силах противника");
        System.out.println(game.Allies.Knight.knight.getName());
        handleSelection(input.nextInt());
    }
    public static void handleSelection(int selection){
        switch (selection){
            case 1:
                Core.buy(Miner.miner);
                break;
            case 2:
                Core.buy(Rook.rook);
                break;
            case 3:
                Core.buy(Knight.knight);
                break;
            case 4:
                printAllies();
                break;
        }
        printInfo();
    }
    public static void printAllies(){
        System.out.println("Информация о ваших силах:");
        for(int i = 0;i<entityCount[0]; i++){
            System.out.println((i+1)+" - "+allies[i].getName() + " ("+allies[i].getHP()+"HP)");
        }
    }
    public static void main(String[] args){
        Core.gameStart();
        printInfo();
    }

}
