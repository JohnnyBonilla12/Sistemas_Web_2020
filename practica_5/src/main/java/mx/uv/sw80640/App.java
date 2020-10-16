package mx.uv.sw80640;

import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        port(80);
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


        get("/", (request, response) -> "Hola desde Spark");
        
        get("/hola", (request, response) -> {
            System.out.println("Request: " + request.queryParams());
            System.out.println("Request: " + request.queryParams("PrmEmail"));
            System.out.println("Request: " + request.queryParams("PrmPassword"));
            return "Hola, " + request.queryParams("PrmEmail")+ " desde Spark";
        });

        get("/adios", (request, response) -> "Adios desde Spark");

        post("/adios", (request, response) -> {
            System.out.println("Request: " + request.queryParams());
            System.out.println("Request: " + request.queryParams("PrmEmail"));
            System.out.println("Request: " + request.queryParams("PrmPassword"));
            System.out.println("Request: " + request.body());
            System.out.println("Request: " + request.contentType());
            return "Adios, " + request.queryParams("PrmEmail")+ "desde Spark";
        });

        post("/adiosJson", (request, response) -> {
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(request.body());
            JsonObject peticion = arbol.getAsJsonObject();

            System.out.println("Request: " + peticion.get("PrmEmail"));
            System.out.println("Request: " + peticion.get("PrmPassword"));

            System.out.println("Request: " + request.body());
            System.out.println("Request: " + request.contentType());
            return "Adios, " + peticion.get("PrmEmail")+ " desde Spark";
        });
    }
}
