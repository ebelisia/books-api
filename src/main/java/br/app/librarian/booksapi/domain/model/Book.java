package br.app.librarian.booksapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "book", sequenceName = "SQ_BOOK", allocationSize = 1)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book")
    private Long id;
    private String name;
    private Integer pages;
    private String author;
    private String category;
    private ZonedDateTime publishedDate;
    private String publisher;
    private String language;
    private String description;
    private BigDecimal price;
}
