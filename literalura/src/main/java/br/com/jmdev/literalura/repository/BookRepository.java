package br.com.jmdev.literalura.repository;

import br.com.jmdev.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguagesContainingIgnoreCase(String lang);
}
