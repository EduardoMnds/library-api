package com.eduardo.library.services;

import com.eduardo.library.models.LibraryModel;
import com.eduardo.library.repositories.LibraryRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
@Setter
public class LibraryService {

    private LibraryRepository libraryRepository;

    public LibraryModel save(LibraryModel libraryModel) {
        return libraryRepository.save(libraryModel);
    }
}
