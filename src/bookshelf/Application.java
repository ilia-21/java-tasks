package bookshelf;

import bookshelf.books.Author;
import bookshelf.books.Book;
import bookshelf.books.Shelf;

public class Application {

    public static void main(String[] args) {
        Author author1 = new Author("Александр", "Пушкин");
        Author author2 = new Author("Лев", "Толстой");
        Author author3 = new Author("Николай","Гоголь");

        Book book1 = new Book("Капитанская Дочка", 600, author1);
        Book book2 = new Book("Дубровский", 200, author1);
        Book book3 = new Book("Война и Мир", 2600, author2);
        Book book4 = new Book("Кавказкий Пленник", 400, author2);
        Book book5 = new Book("Анна Каренина", 120, author2);
        Book book6 = new Book("Мертвые души", 200, author3);
        Book book7 = new Book("Тарас Бульб", 100, author3);
        Book book8 = new Book("Тарас Бульб", 100, author3);

        Shelf shelf1 = new Shelf(4, "Синий");
        shelf1.addBook(book1).addBook(book2).addBook(book3).addBook(book4);
        Shelf shelf2 = new Shelf(3, "Черный");
        shelf2.addBook(book5).addBook(book6).addBook(book7);


    }
}
