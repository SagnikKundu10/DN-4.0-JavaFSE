package org.example;

import org.example.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LibraryService libraryService = (LibraryService) context.getBean("libraryService");
        libraryService.showLibraryBook();
    }
}
