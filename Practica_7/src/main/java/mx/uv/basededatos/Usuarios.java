package mx.uv.basededatos;

public class Usuarios{
    private String id;
    private String email;
    private String password;

    public Usuarios(String id, String email, String password){
        this.setID(id);
        this.setEmail(email);
        this.setPassword(password);
    }

    public void setID(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}