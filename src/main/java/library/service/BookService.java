package library.service;

import library.dao.BookDAO;
import library.model.Book;
import java.util.List;

public class BookService {
    private final BookDAO bookDAO;

    public BookService() {
        this.bookDAO = new BookDAO();
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    // Тут в майбутньому будуть методи updateBook, deleteBook, getBookById
}
