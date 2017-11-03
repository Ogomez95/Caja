package beans;

public class Factura {
    private Integer idFac;
    private String serie;
    private String nombre;
    private String nit;
    private Integer cantidad;
    private Double total;
    private Double efectivo;
    private Double cambio;

    public Factura(Integer idFac, String serie, String nombre, String nit, Integer cantidad, Double total, Double efectivo, Double cambio) {
        this.idFac = idFac;
        this.serie = serie;
        this.nombre = nombre;
        this.nit = nit;
        this.cantidad = cantidad;
        this.total = total;
        this.efectivo = efectivo;
        this.cambio = cambio;
    }
    
    public Factura(){
        super();
    }

    public Integer getIdFac() {
        return idFac;
    }

    public void setIdFac(Integer idFac) {
        this.idFac = idFac;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Double efectivo) {
        this.efectivo = efectivo;
    }

    public Double getCambio() {
        return cambio;
    }

    public void setCambio(Double cambio) {
        this.cambio = cambio;
    }

    
}
