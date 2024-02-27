package game;

import java.util.Scanner;

import game.Classes.Entity;

public class Play {
    public static Scanner input = new Scanner(System.in);
    static int entityCap = 50;
    public static int[] entityCount = {0,0};
    String currentPage = "Main";
    public static Entity[] allies = new Entity[entityCap/2];
    public static Entity[] enemies = new Entity[entityCap/2];
    public static void printInfo(){
        System.out.printf("-------------Ход  %d-----------------------%n", Core.tickCount);
        System.out.printf("У вашего короля %d \uF155 и %d \uEB05%n", Core.king.getGold(), Core.king.getHP());
        System.out.println("У вражеского короля " + Core.enemy.getHP() + " \uEB05");
        System.out.println("------------------------------------------");
        System.out.println("Выберите ваше действие:");
        System.out.println("1 - Нанять шахтера ("+Allies.miner.getCost()+" \uF155) [Добыча: "+Allies.miner.getIncome()+" \uF155 за ход]");
        System.out.println("2 - Нанять пехотинца ("+Allies.rook.getCost()+" \uF155)");
        System.out.println("3 - Нанять рыцаря ("+Allies.knight.getCost()+" \uF155)");
        System.out.println("4 - Узнать информацию о нанятых ("+entityCount[0]+")");
        System.out.println("5 - Узнать информацию о силах противника ("+entityCount[1]+")");
        System.out.println("6 - Закончить ход");

        handleSelection(input.nextInt());
        System.out.printf("------------------------------------------%n%n");
    }
    public static void handleSelection(int selection){
        switch (selection){
            case 1:
                Core.buy(Allies.miner);
                break;
            case 2:
                Core.buy(Allies.rook);
                break;
            case 3:
                Core.buy(Allies.knight);
                break;
            case 4:
                printAllies();
                break;
            case 5:
                printEnemies();
                break;
            case 6:
                Core.tick();
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
    public static void printEnemies(){
        System.out.println("Информация о силах противника:");
        for(int i = 0;i<entityCount[1]; i++){
            System.out.println((i+1)+" - "+enemies[i].getName()  + " ("+enemies[i].getHP()+"HP)");
        }
    }
    public static void main(String[] args){
        Core.gameStart();
        printInfo();
    }

}
