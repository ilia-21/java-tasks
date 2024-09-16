package array;

public class PersonFunctions {
    public void findPersons(String by, String value, Person[] array){
        if(by.equals("firstName")){
            for (Person person : array) {
                if (person.getFirstName().equals(value)) person.printInfo();
            }
        } else if(by.equals("lastName")){
            for (Person person : array) {
                if (person.getLastName().equals(value)) person.printInfo();
            }
        } else {
            System.out.println("Wrong argument");
        }
    }
    public static Person[] insertPerson(int i, Person person, Person[] array){
        for(i=i+1; i<array.length+1; i++){
            array[i-1] = array[i];
        }
        array[i] = person;
        return array;
    }
    public static Person[] deletePerson(int i, Person[] array){
        for(; i<array.length-1; i++){
            array[i] = array[i+1];
        }
        array[array.length-1] = null;
        return array;
    }
}
