package beans;

public class Detalle {
    private Integer idDet;
    private String serie;
    private String codigo;
    private String nombre;
    private Double precio;
    
    public Detalle(){
        super();
    }

    public Detalle(Integer idDet, String serie, String codigo, String nombre, Double precio) {
        super();
        this.idDet = idDet;
        this.serie = serie;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getIdDet() {
        return idDet;
    }

    public void setIdDet(Integer idDet) {
        this.idDet = idDet;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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
}
