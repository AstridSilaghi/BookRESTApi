package project.app.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType; 

@Path("books")
public class BookResource {

	BookRepository br = new BookRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Book> getBooks() {

		return br.getBooks();
	}

	@GET
	@Path("/book/{title}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book getBookByTitle(@PathParam("title") String title) {

		return br.getBook(title);
	}
	
	@GET
	@Path("/bookid/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book getBookByTitle(@PathParam("id") int id) {

		return br.getBookId(id);
	}
	
	@POST
	@Path("/book")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book addBook(Book b) {
		br.createBook(b);
		
		return b;
	}
	
	@PUT
	@Path("/book")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book updateBook(Book b) {
		if(br.getBook(b.getTitle()) == null) {
			br.createBook(b);
		} else {
			br.update(b);
		}
		
		return b;
	}
	
	@DELETE
	@Path("/book/{title}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book deleteBook(@PathParam("title") String title) {
		Book b = br.getBook(title);
		
		if(b.getTitle() != null) {
			br.delete(title);
		}
		return b;
	}
}
