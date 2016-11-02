package co.sptnk.rest;

import co.sptnk.service.api.LibraryService;
import co.sptnk.service.api.dto.BookDto;
import co.sptnk.service.api.dto.response.FindResponse;

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
@Path("/lib")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class LibServiceRest {

    @EJB(lookup = "ejb:spt-service-ear/spt-service-impl/LibraryServiceImpl!co.sptnk.service.api.LibraryService")
    private LibraryService libraryService;

    @GET
    @Path("/ping")
    public String ping() {
        return "ping";
    }

    @POST
    @Path("/add")
    public Response createBook(BookDto dto) {
        return Response.ok().build();
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
        } catch (NotFoundException e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }
}
