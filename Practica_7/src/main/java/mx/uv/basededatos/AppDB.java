package mx.uv.basededatos;

import static spark.Spark.*;


import com.google.gson.Gson;
//import java.util.HashMap;
//import java.util.Map;
import java.util.UUID;

public class AppDB
{
    private static Gson gson = new Gson();
    //private static Map<String, Usuarios> usuarios = new HashMap<>();

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


        get("/usuarios", (req, res) -> gson.toJson(DAO.dameUsuarios()));

        post("/usuarios", (req, res) -> {
            String query = req.body();
            System.out.println( "Peticion: " + query);
            Usuarios u = gson.fromJson(query, Usuarios.class);
            String id = UUID.randomUUID().toString();
            u.setID(id);
            return DAO.crearUsuarios(u);
        });

        System.out.println( "Hello World!" );
    }
}
