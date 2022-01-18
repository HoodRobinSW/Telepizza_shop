package Modelo;

public class Usuario {
    private int id;
    private String usuario;
    private String pass;
    private String address;
    private String email;
    private String phone;

    public Usuario(int id, String usuario, String pass, String address, String email, String phone) {
        setId(id);
        setUsuario(usuario);
        setPass(pass);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
