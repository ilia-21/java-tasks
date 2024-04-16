package fitness.types;
import java.util.Date;

public class FitnessPass {
    private String firstName;
    private String lastName;
    private int[] hours = {0,0};
    private Date registrationDate;
    private Date expiryDate;
    private String type;
    private boolean[] allowedRooms = new boolean[3];

    public FitnessPass(String firstName, String lastName, Date registrationDate, Date expiryDate, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.expiryDate = expiryDate;
        this.type = type;
        switch (type){
            case "oneDay":
                this.allowedRooms = new boolean[]{true, true, false};
                this.hours = new int[]{8, 22};
                Fitness.registerGymPass(this);
                Fitness.registerPoolPass(this);;
                break;
            case "daily":
                this.allowedRooms = new boolean[]{false, true, true};
                this.hours = new int[]{8, 16};
                Fitness.registerPoolPass(this);
                Fitness.registerGroupClassesPass(this);
                break;
            case "full":
                this.allowedRooms = new boolean[]{true, true, true};
                this.hours = new int[]{8, 22};
                Fitness.registerGymPass(this);
                Fitness.registerPoolPass(this);
                Fitness.registerGroupClassesPass(this);
                break;
            default:
                throw new RuntimeException("Недопустимый тип абонемента");
        }
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public boolean[] getAllowedRooms() {
        return allowedRooms;
    }
}
