package rest;
import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;

import rest.model.User;
import rest.dao.DaoUsers;
import java.util.ArrayList;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> findAll() {
      return DaoUsers.findAll();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id){
      try{
         return Response.ok(DaoUsers.find(id)).build();
      }catch(IndexOutOfBoundsException iobe){
         return Response.status(Status.NOT_FOUND).build();
      }

   }

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response addUser(User user, @Context UriInfo uriInfo) {
      User newUser = new User();
      UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		URI newUri = uriBuilder.path(String.valueOf(newUser.getId())).build();

		return Response.created(newUri).entity(newUser).build();

   }

}
