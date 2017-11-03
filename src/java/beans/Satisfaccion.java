package beans;

public class Satisfaccion {
    private Integer idSat;
    private String serie;
    private Integer valor;
    
    public Satisfaccion(){
        super();
    }

    public Satisfaccion(Integer idSat, String serie, Integer valor) {
        super();
        this.idSat = idSat;
        this.serie = serie;
        this.valor = valor;
    }

    public Integer getIdSat() {
        return idSat;
    }

    public void setIdSat(Integer idSat) {
        this.idSat = idSat;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
