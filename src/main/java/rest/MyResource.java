package rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import rest.model.User;
import rest.dao.DaoUsers;
import java.util.Map;
import java.util.HashMap;


@Path("myresource")
//@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response addUser(User user) {
      return Response.status(Status.CREATED).entity(DaoUsers.save(user)).build();
   }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
      return Response.ok(DaoUsers.findAll().values()).header("Access-Control-Allow-Origin", "*").build();      
   }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id){
      try{
         if(DaoUsers.find(id) != null){
            return Response.ok(DaoUsers.find(id)).build();
         }else{
            return Response.status(Status.NOT_FOUND).build();
         }
      }catch(NullPointerException npe){
         return Response.status(Status.NOT_FOUND).build();
      }catch(ClassCastException cce){
         return Response.status(Status.INTERNAL_SERVER_ERROR).build();
      }

   }

   @Path("{id}")
   @DELETE
   @Produces(MediaType.APPLICATION_JSON) // Lo puse por que no sabia que devolvia
   public Response removeUser (@PathParam("id") int id){
      if(DaoUsers.delete(id))
         return Response.noContent().build();
      else
         return Response.status(Status.NOT_FOUND).build();
   }

   @Path("{id}")
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response UpdateUser(@PathParam("id") int id, User user){
      if(DaoUsers.update(user, id) != null)
         return Response.ok(DaoUsers.update(user, id)).build();
      else
         return Response.status(Status.NOT_FOUND).build();
   }


}
