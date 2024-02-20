package game;
import game.Classes.Entity;

public class Allies {
    public static Entity miner = new Entity(
            true,
            10,
            10,
            0,
            0,
            100,
            0,
            "Шахтер"
    );

    public static void main(String[] args) {
        System.out.println(miner.getName());
    }
    public static Entity knight = new Entity(
            true,
            20,
            0,
            10,
            50,
            50,
            0,
            "Рыцарь"
    );
    public static Entity rook = new Entity(
            true,
            10,
            0,
            5,
            0,
            10,
            0,
            "Пехотинец"
    );
}
