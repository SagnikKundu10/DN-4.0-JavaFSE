package org.example.service;

import org.example.repository.LibraryRepository;
import org.example.repository.LoggerService;

public class LibraryService {
    private LibraryRepository libraryRepository;   // Setter injection
    private LoggerService loggerService;           // Constructor injection

    // Constructor Injection
    public LibraryService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    // Setter Injection
    public void setLibraryRepository(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void showLibraryBook() {
        loggerService.log("Getting book details from repository...");
        System.out.println(libraryRepository.getBook());
    }
}
