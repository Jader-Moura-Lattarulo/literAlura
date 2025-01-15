package br.com.jmdev.literalura.repository;

import br.com.jmdev.literalura.model.Author;
import br.com.jmdev.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameContainingIgnoreCase(String name);

    @Query("SELECT b FROM Author a JOIN a.books b WHERE a.name ILIKE %:name")
    List<Book> searchBookByAuthor(String name);
}
