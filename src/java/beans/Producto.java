package beans;

public class Producto {
        private Integer idPro;
        private String codigo;
	private String nombre;
	private Double precio;
        private String unidad;
        private String imagen;
        private String barra;
        
    public Producto(){
        super();
    }

    public Producto(Integer idPro, String codigo, String nombre, Double precio, String unidad, String imagen, String barra) {
        super();
        this.idPro = idPro;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.unidad = unidad;
        this.imagen = imagen;
        this.barra = barra;
    }

    public Integer getIdPro() {
        return idPro;
    }

    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }
        
}
