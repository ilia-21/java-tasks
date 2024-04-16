package fitness;

import fitness.types.Fitness;
import fitness.types.FitnessPass;

import java.util.Date;

public class Main {
    public static void main(String[] args){
        Fitness fitnessClub = new Fitness();
        System.out.println("Примеры");
        //Регистрация одноразовго
        FitnessPass asd = new FitnessPass("Иван", "Иванов", new Date(), new Date(), "oneDay");
    }
}