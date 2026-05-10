package library.controller; // Зверни увагу на свій пакет

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import library.model.Book;
import library.service.BookService;

import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookController extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() {
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                request.getRequestDispatcher("/book-form.jsp").forward(request, response);
                break;
            case "edit":
                int idToEdit = Integer.parseInt(request.getParameter("id"));
                Book existingBook = bookService.getBookById(idToEdit);
                request.setAttribute("book", existingBook);
                request.getRequestDispatcher("/book-form.jsp").forward(request, response);
                break;
            case "delete":
                int idToDelete = Integer.parseInt(request.getParameter("id"));
                bookService.deleteBook(idToDelete);
                response.sendRedirect("books");
                break;
            default:
                List<Book> listBooks = bookService.getAllBooks();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/book-list.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            int year = Integer.parseInt(request.getParameter("publishedYear"));
            int libraryId = Integer.parseInt(request.getParameter("libraryId"));

            Book newBook = new Book(0, title, author, year, libraryId);
            bookService.addBook(newBook);
            response.sendRedirect("books");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            int year = Integer.parseInt(request.getParameter("publishedYear"));
            int libraryId = Integer.parseInt(request.getParameter("libraryId"));

            Book updatedBook = new Book(id, title, author, year, libraryId);
            bookService.updateBook(updatedBook);
            response.sendRedirect("books");
        }
    }
}
