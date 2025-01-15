package br.com.jmdev.literalura.model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Author author;
    private String title;
    private int downloads;
    @ElementCollection
    private List<String> languages;

    public Book(){}

    public Book(String title, Author author, List<String> languages, int downloads) {
        this.title = title;
        this.author = author;
        this.languages = languages;
        this.downloads = downloads;
    }

    public static Book fromBookData(BookData bookData, Author author) {
        return new Book(
                bookData.title(),
                author,
                bookData.languages(),
                bookData.downloads());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Livro: " +
                "\nTitulo: " + title +
                "\nAutor: " + author.getName() +
                "\nIdiomas: " + languages +
                "\nDownloads: " + downloads;
    }
}
