package exam;
import java.math.BigDecimal;
import java.util.Scanner;
public class MoneyTracker {
    static BigDecimal[] days = new BigDecimal[30];
    static BigDecimal total = new BigDecimal(0);
    static int[] max = {0,0};
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        mainMenu();
    }
    static void mainMenu(){
        System.out.println("Здравствуйте, что хотите сделать?");
        System.out.println("1 - Ввести расходы за один день");
        System.out.println("2 - Узнать траты за месяц");
        System.out.println("3 - Узнать саммую большую трату");
        System.out.println("4 - Открыть конвертер валюты");
        System.out.println("0 - Выйти");
        handleInput(input.nextInt());
    }
    static void handleInput(int option){
        if (option<0 && option>3){
            System.out.println("Выбрана неверная опция");
            mainMenu();
        }
        switch (option){
            case 1:
                spendingMenu();
                break;
            case 2:
                for(int i = 0; i<30;i++){
                    String text = days[i]==null ? "0" : days[i].toString();
                    System.out.println((i+1) + " день - " + text + "руб");
                }
                mainMenu();
            case 3:
                if(max[0]==0&&max[1]==0) {
                    System.out.println("Вы еще не ввели данные о ваших затратах");
                    mainMenu();
                } else {
                    System.out.println("Ваша самая большая трата: " + max[0] + " рублей в " + (max[1]+1) + " день");
                    mainMenu();
                }
            case 4:
                currencyConverter();
            case 0:
                System.out.println("До свидания!");
                System.exit(0);
        }
    }
    static void spendingMenu(){
        System.out.println("Введите день (1-30)");
        System.out.println("Введите 0 чтобы выйти в главное меню");
        int choice = input.nextInt();
        System.out.println("Введите траты за " + choice + " день");
        int spent = input.nextInt();
        if(choice<0 || choice > 30 || spent<0) {
            System.out.println("Неверное значение");
            spendingMenu();
        } else {
            if(choice==0){
                mainMenu();
            } else {
                dayInput(choice,spent);
            }
        }
    }
    static void dayInput(int day, int spent){
        day--;
        if(days[day]==null){
            days[day] = new BigDecimal(spent);
            updateMax(spent,day);
            System.out.println("Значение сохранено, введите 1 чтобы ввести трату за другой день или 0 чтобы вернуться в меню.");
            updateTotal();
            switch (input.nextInt()){
                case 1:
                    spendingMenu();
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    System.out.println("Неверное значение! Возврат в меню");
                    mainMenu();
            }
        } else {
            System.out.println("В " + day + " день уже введено значение, вы уверены что хотите его заменить? (д/н)");
            switch (input.nextLine()){
                case "д":
                    days[day] = new BigDecimal(spent);
                    updateMax(spent, day);
                    System.out.println("Значение сохранено, введите 1 чтобы ввести трату за другой день или 0 чтобы вернуться в меню.");
                    updateTotal();
                    switch (input.nextInt()){
                        case 1:
                            spendingMenu();
                            break;
                        case 0:
                            mainMenu();
                            break;
                        default:
                            System.out.println("Неверное значение! Возврат в меню");
                            mainMenu();
                    }
                    break;
                case "н":
                    spendingMenu();
                    break;
                default:
                    mainMenu();
                    break;
            }
        }
    }
    static void updateMax(int money, int day){
        if(max[0]<money) max[0] = money; max[1] = day;
    }
    static void updateTotal(){
        total = new BigDecimal(0);
        for(int i = 0; i<30;i++){
            total = total.add(days[i]);
        }
    }
    static void currencyConverter(){
        System.out.println("Выберите валюту: ");
        System.out.println("1 - Юани");
        System.out.println("2 - Доллары");
        System.out.println("3 - Евро");
        String currencyName = "";
        switch (input.nextInt()){
            case 1:
                total.multiply(new BigDecimal(0.0797));
                currencyName = "юанях";
            case 2:
                total.multiply(new BigDecimal(0.011));
                currencyName = "долларах";
            case 3 :
                total.multiply(new BigDecimal(0.0102));
                currencyName = "евро";
            default:
                System.out.println("Введено неверное значение!");
                currencyConverter();
        }
        System.out.println("Ваш новый баланс в "+currencyName+": " + total.toString());
    }
}