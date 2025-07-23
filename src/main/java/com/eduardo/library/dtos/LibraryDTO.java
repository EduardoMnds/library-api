package com.eduardo.library.dtos;

import com.eduardo.library.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibraryDTO {

    @NotBlank
    @Size(min = 1, max = 50)
    private String bookName;

    @NotBlank
    @Size(min = 1, max = 50)
    private String bookAuthor;

    @NotBlank
    @Size(min = 1, max = 200)
    private String bookDescription;

    @NotBlank
    @Size(min = 1, max = 50)
    private String bookPublisher;

    @NotBlank
    @Size(min = 1, max = 50)
    private String bookGenre;

    @NotBlank
    @Size(min = 1, max = 50)
    private String bookIsbn;

    @NotNull
    private Status bookStatus;

    @NotBlank
    @Size(min = 1, max = 50)
    private Date bookReleaseDate;
}
