package co.sptnk.rest;

import co.sptnk.service.api.LibraryService;
import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.api.dto.criteria.SearchCriteriaBook;
import co.sptnk.service.api.dto.response.AddOrUpdateResponse;
import co.sptnk.service.api.dto.response.FindResponse;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by evseevvd on 02.11.16.
 *
 * рест для библиотеки.
 */
@Path("/libserv")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class LibServiceRest implements Serializable{

    @EJB(lookup = "ejb:spt-service-ear/spt-service-impl/LibraryService!co.sptnk.service.api.LibraryService")
    private LibraryService libraryService;

    @GET
    @Path("/ping")
    public String ping() {
        return "ping";
    }

    @POST
    @Path("/add")
    public Response createBook(BookDto dto) {
        try {
            AddOrUpdateResponse response = libraryService.addOrUpdateBook(dto);
            return Response.ok().entity(response).build();
        } catch (IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        } catch (InstantiationException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/remove/{id}")
    public Response removeBook(@PathParam("id") String id) {
        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        try {
            libraryService.deleteBook(bookDto);
            return Response.ok().entity("Book deleted "+id).build();
        } catch (IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        } catch (InstantiationException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/get/{id}")
    public Response getBook(@PathParam("id") String id) {
        try {
            FindResponse response = libraryService.getBook(id);
            return Response.ok().entity(response).build();
        } catch (IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        } catch (InstantiationException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/search")
    public Response searchBooks (SearchCriteriaBook criteria) {
        try {
            FindResponse response = libraryService.findBooks(criteria);
            return Response.ok().entity(response).build();
        } catch (IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        } catch (InstantiationException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
