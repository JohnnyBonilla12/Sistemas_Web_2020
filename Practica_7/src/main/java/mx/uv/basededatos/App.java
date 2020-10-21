package mx.uv.basededatos;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * Hello world!
 *
 */
public class App 
{
    private static Gson gson = new Gson();
    private static Map<String, Usuarios> usuarios = new HashMap<>();

    public static void main( String[] args )
    {
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));


        get("/usuarios", (req, res) -> gson.toJson(usuarios.values() ));

        post("/usuarios", (req, res) -> {
            String query = req.body();
            System.out.println( "Peticion: " + query);
            Usuarios u = gson.fromJson(query, Usuarios.class);
            String id = UUID.randomUUID().toString();
            u.setID(id);
            usuarios.put(id, u);
            return "Se creo el Usuario con ID: " + id;
        });

        System.out.println( "Hello World!" );
    }
}
