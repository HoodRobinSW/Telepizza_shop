package Modelo;

public class Pizza {
    private int id;
    private String nombre;
    private int idPizza;
    private double precio;

    public Pizza(int id, String nombre, int idPizza, double precio) {
        setId(id);
        setNombre(nombre);
        setIdPizza(idPizza);
        setPrecio(precio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
