package rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import rest.model.User;
import rest.dao.DaoUsers;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8081/api/v1/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in rest package
        final ResourceConfig rc = new ResourceConfig().packages("rest").register(rest.CORSResponseFilter.class);

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

      DaoUsers.save(new User(0, "example", "example@gmail.com"));
      DaoUsers.save(new User(0, "example2", "example2@gmail.com"));

        final HttpServer server = startServer();
        System.out.println(String.format("Jersey comenzó con WADL disponible en: "
                + "%sapplication.wadl\nPara detener la ejecucion precione enter.", BASE_URI));
        System.in.read();
        server.stop();

    }
}
