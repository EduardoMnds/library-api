package com.eduardo.library.models;


import com.eduardo.library.enums.library.Status;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EMG_LIBRARY")
public class LibraryModel {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOOK_ID")
    private long id;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "BOOK_AUTHOR")
    private String bookAuthor;

    @Column(name = "BOOK_DESCRIPTION")
    private String bookDescription;

    @Column(name = "BOOK_PUBLISHER")
    private String bookPublisher;

    @Column(name = "BOOK_GENRE")
    private String bookGenre;

    @Column(name = "BOOK_ISBN")
    private String bookIsbn;

    @Column(name = "BOOK_STATUS")
    @Enumerated(EnumType.STRING)
    private Status bookStatus;

    @Column(name = "BOOK_RELEASE_DATE")
    private Date bookReleaseDate;

    @Column(name = "INSERT_DATETIME")
    private LocalDateTime insertDateTime;

    @Column(name = "UPDATE_DATETIME")
    private LocalDateTime updateDateTime;
}
