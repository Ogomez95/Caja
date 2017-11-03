package beans;

public class Venta {
    private Integer idVenta;
    private String producto;
    private String nombre;
    private Double precio;
    
    public Venta(){
        super();
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Venta(Integer idVenta, String producto, String nombre, Double precio) {
        this.idVenta = idVenta;
        this.producto = producto;
        this.nombre = nombre;
        this.precio = precio;
    }
}
