package Model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String author;
    private String publication;
    private String category;
    private int pages;
    private int price;

    private String created_timestamp;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", category='" + category + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", created_timestamp='" + created_timestamp + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(String created_timestamp) {
        this.created_timestamp = created_timestamp;
    }

    public Book(String name, String author, String publication, String category, int pages, int price, String created_timestamp) {
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.category = category;
        this.pages = pages;
        this.price = price;
        this.created_timestamp = created_timestamp;
    }
}
