package bookshelf.books;

public class Author {
    private String name;
    private String surname;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
    public void printFullName(){
        System.out.println(name + " " + surname);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public String getFullName(){
        return name + " " + surname;
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}
