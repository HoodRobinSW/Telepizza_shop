package Modelo;

public class Entrante {
    private int id;
    private String tipo;
    private String descripcion;
    private double precio;

    public Entrante(int id, String tipo, String descripcion, double precio) {
        setId(id);
        setTipo(tipo);
        setDescripcion(descripcion);
        setPrecio(precio);
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
