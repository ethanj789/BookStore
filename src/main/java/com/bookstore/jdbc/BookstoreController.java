package com.bookstore.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class BookstoreController
 */
@WebServlet("/BookstoreController")
public class BookstoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookstoreDBUtil bookstoreDB;
	
	@Resource(name = "jdbc/book_store")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			bookstoreDB = new BookstoreDBUtil(dataSource);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}	
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String req = request.getParameter("command");
			
			if (req == null) {
				req="LIST";
			}
			
			switch (req) {
			case "LIST":
				listBooks(request, response);
				break;
			case "ADD":
				addBook(request, response);
				break;
			case "GET":
				getBook(request, response);
				break;
			case "UPDATE":
				updateBook(request, response);
				break;
			case "DELETE":
				deleteBook(request, response);
				break;
			default:
				listBooks(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}


	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		bookstoreDB.deleteBook(Integer.parseInt(request.getParameter("id")));
		
		listBooks(request, response);
	}


	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		bookstoreDB.updateBook(new Book(request.getParameter("author"),request.getParameter("title"),Integer.parseInt(id), Double.parseDouble(request.getParameter("price"))));
		
		listBooks(request,response);
	}


	private void getBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Book put = bookstoreDB.getBook(request.getParameter("id"));
		
		request.setAttribute("BOOK", put);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-book-form.jsp");
		dispatcher.forward(request, response);
	}


	private void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		
		bookstoreDB.addBook(new Book(author, title, Double.parseDouble(price)));
		
		
		listBooks(request,response);
	}


	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Book> books = bookstoreDB.getBooks();
		request.setAttribute("Books", books);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/table.jsp");
		dispatcher.forward(request, response);
	}
}
