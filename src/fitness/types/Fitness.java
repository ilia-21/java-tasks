package fitness.types;
import java.util.Date;

public class Fitness {
    private static FitnessPass[] gymPasses;
    private static int gymCount = 0;
    private static FitnessPass[] poolPasses;
    private static int poolCount = 0;
    private static FitnessPass[] groupClassesPasses;
    private static int groupClassesCount = 0;
    final static int CAP = 20;

    public Fitness() {
        this.gymPasses = new FitnessPass[CAP];
        this.poolPasses = new FitnessPass[CAP];
        this.groupClassesPasses = new FitnessPass[CAP];
        System.out.println("asd"+gymPasses[0]);
    }

    public static void registerGymPass(FitnessPass pass) {
        if (canRegisterPass(pass, "gym")) {
            getGymPasses()[getGymCount()] = pass;
            setGymCount(getGymCount()+1);
            System.out.println("Зарегестрирован абонемент в тренажерный зал для клиента " + pass.getFirstName() + " " + pass.getLastName());
        }
    }

    public static void registerPoolPass(FitnessPass pass) {
        if (canRegisterPass(pass, "pool")) {
            getPoolPasses()[getPoolCount()] = pass;
            setPoolCount(getPoolCount()+1);
            System.out.println("Зарегестрирован абонемент в бассейн для клиента " + pass.getFirstName() + " " + pass.getLastName());
        }
    }

    public static void registerGroupClassesPass(FitnessPass pass) {
        if (canRegisterPass(pass, "groupClasses")) {
            getGroupClassesPasses()[getGroupClassesCount()] = pass;
            setGroupClassesCount(getGroupClassesCount()+1);
            System.out.println("Зарегестрирован абонемент на груповые занятия для клиента " + pass.getFirstName() + " " + pass.getLastName());
        }
    }

    private static boolean canRegisterPass(FitnessPass pass, String where) {
        Date currentDate = new Date();
        int referenced = 0;
        switch (where){
            case "gym":
                referenced = gymCount;
            case "pool":
                referenced = poolCount;
            case "groupClasses":
                referenced = groupClassesCount;
        }
        if (referenced >= CAP) {
            System.out.println("Нельзя зарегестрировать абонемент для " + pass.getFirstName() + " " + pass.getLastName() + ". На указанной зоне нет мест.");
            return false;
        }
        return true;
    }

    public boolean canComeIn(FitnessPass pass, String zone) {
        //Проверка на просроченность
        if(pass.getExpiryDate().before(new Date())){
            System.out.println("Этот абонемент просрочен");
            return false;
        }
        //Проверка на допуск к зоне
        switch (zone) {
            case "gym":
                if(!pass.getAllowedRooms()[0]) {
                    System.out.println("Этот абонемент не имеет пропуска в тренажерный зал");
                    return false;
                }
            case "pool":
                if(!pass.getAllowedRooms()[1]) {
                    System.out.println("Этот абонемент не имеет пропуска в бассейн");
                    return false;
                }
            case "groupClasses":
                if(!pass.getAllowedRooms()[2]) {
                    System.out.println("Этот абонемент не имеет пропуска на групповые занятия");
                    return false;
                }
        }
        return true;
    }

    public void printVisitors(){
        System.out.println("Зарегестрированные в тренажерном зале:");
        for (int i = 0; i<gymCount; i++){
            System.out.println("  " + gymPasses[i].getFirstName() + " " + gymPasses[i].getLastName());
        }
        System.out.println("Зарегестрированные в бассейне:");
        for (int i = 0; i<poolCount; i++){
            System.out.println("  " + poolPasses[i].getFirstName() + " " + poolPasses[i].getLastName());
        }

        System.out.println("Зарегестрированные на груповых занятиях:");
        for (int i = 0; i<groupClassesCount; i++){
            System.out.println("  " + groupClassesPasses[i].getFirstName() + " " + groupClassesPasses[i].getLastName());
        }
    }
    public static FitnessPass[] getGymPasses() {
        return gymPasses;
    }

    public static int getGymCount() {
        return gymCount;
    }

    public static FitnessPass[] getPoolPasses() {
        return poolPasses;
    }

    public static int getPoolCount() {
        return poolCount;
    }

    public static FitnessPass[] getGroupClassesPasses() {
        return groupClassesPasses;
    }

    public static int getGroupClassesCount() {
        return groupClassesCount;
    }

    public static void setGymPasses(FitnessPass[] gymPasses) {
        Fitness.gymPasses = gymPasses;
    }

    public static void setGymCount(int gymCount) {
        Fitness.gymCount = gymCount;
    }

    public static void setPoolPasses(FitnessPass[] poolPasses) {
        Fitness.poolPasses = poolPasses;
    }

    public static void setPoolCount(int poolCount) {
        Fitness.poolCount = poolCount;
    }

    public static void setGroupClassesPasses(FitnessPass[] groupClassesPasses) {
        Fitness.groupClassesPasses = groupClassesPasses;
    }

    public static void setGroupClassesCount(int groupClassesCount) {
        Fitness.groupClassesCount = groupClassesCount;
    }
}