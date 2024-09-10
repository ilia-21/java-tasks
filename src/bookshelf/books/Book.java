package bookshelf.books;

public class Book {
    private String title;
    private int pageCount;
    private Author author;

    public void setPageCount(int count) {
        if (count < 10) {
            System.out.println("Количество страниц не может быть меньше 10");
        } else {
            pageCount = count;
        }
    }
    public void setAuthor(Author author) {
        if (author == null) {
            throw  new IllegalArgumentException("author не может быть null");
        }
        this.author = author;
    }
    public int getPageCount() {
        return pageCount;
    }
    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Book(String title, int pageCount, Author author) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
    }
}
