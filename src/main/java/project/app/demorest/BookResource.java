package project.app.demorest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	@POST
	@Path("/book")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Book addBook(Book b) {
		br.createBook(b);
		
		return b;
	}
	
}
