package manager;

import beans.*;
import db.Conexion;

public class ManejadorDetalle {

    private Satisfaccion satis;
    public static final String INI_PAGE_REDIRECT = "home.xhtml?faces-redirect=true";

    public ManejadorDetalle() {
        satis = new Satisfaccion();
    }

    public String Excelente() {
        Satisfaccion s = new Satisfaccion(
                null,
                ManejadorVenta.serie,
                4
        );
        Conexion.getInstancia().agregar(s);
        ManejadorVenta.fchead.clear();
        ManejadorVenta.fcbody.clear();
        return INI_PAGE_REDIRECT;
    }
    public String Bueno() {
        Satisfaccion s = new Satisfaccion(
                null,
                ManejadorVenta.serie,
                3
        );
        Conexion.getInstancia().agregar(s);
        ManejadorVenta.fchead.clear();
        ManejadorVenta.fcbody.clear();
        return INI_PAGE_REDIRECT;
    }
    public String Regular() {
        Satisfaccion s = new Satisfaccion(
                null,
                ManejadorVenta.serie,
                2
        );
        Conexion.getInstancia().agregar(s);
        ManejadorVenta.fchead.clear();
        ManejadorVenta.fcbody.clear();
        return INI_PAGE_REDIRECT;
    }
    public String Malo() {
        Satisfaccion s = new Satisfaccion(
                null,
                ManejadorVenta.serie,
                1
        );
        Conexion.getInstancia().agregar(s);
        ManejadorVenta.fchead.clear();
        ManejadorVenta.fcbody.clear();
        return INI_PAGE_REDIRECT;
    }

}
