package manager;

import beans.*;
import db.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
public class ManejadorVenta {

    public static final String DETALLE_PAGE_REDIRECT = "detalle.xhtml?faces-redirect=true";
    public static ArrayList<Venta> listaArray;
    public static ArrayList listav;
    public static List<Object> fchead;
    public static List<Object> fcbody;
    public Venta nodo;
    private String codigo;
    public static String serie;
    public static String nombref;
    public static String nitf;
    public static double efectivo;
    public static double sub;
    public static double vuelto;
    public static double total;
    public Factura factura;
    public Detalle detalle;

    public String getNombref() {
        return nombref;
    }

    public void setNombref(String nombref) {
        this.nombref = nombref;
    }

    public String getNitf() {
        return nitf;
    }

    public void setNitf(String nitf) {
        this.nitf = nitf;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public ManejadorVenta() {
        nodo = new Venta();
        factura = new Factura();
        detalle = new Detalle();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sesion = request.getSession(true);

    public String AddRegistro() {
        if ("".equals(getCodigo())) {
        } else {
            List<Object> pp = Conexion.getInstancia().hacerConsulta("From Producto " + " where codigo = '" + getCodigo() + "'");
            Producto pr = (Producto) pp.get(0);
            Producto p = (Producto) Conexion.getInstancia().Buscar(Producto.class, pr.getIdPro());
            listav = (ArrayList) sesion.getAttribute("listaventas");

            //comprueba si ya existe y si no la crea
            if (listav == null) {
                listav = new ArrayList();
                sesion.setAttribute("listaventas", listav);
            }

            total = 0;
            nodo.setIdVenta(1);
            nodo.setProducto(getCodigo());
            nodo.setNombre(p.getNombre());
            nodo.setPrecio(p.getPrecio());

            listav.add(nodo);

            listaArray = listav;

            for (int i = 0; i < listav.size(); i++) {
                total += listaArray.get(i).getPrecio();
            }

            sesion.setAttribute("tt", total);
            sub = total;

            setCodigo(null);
        }

        return null;
    }

    public String Vuelto() {
        if (getEfectivo() > sub) {
            sesion.setAttribute("cambio", getEfectivo() - sub);
            vuelto = getEfectivo() - sub;
            efectivo = getEfectivo();
        } else {
            sesion.setAttribute("cambio", "Efectivo menor a total");
            vuelto = 0;
            efectivo = 0;
        }
        return null;
    }

    public String DatosCliente() {
        sesion.setAttribute("nombrefac", getNombref());
        sesion.setAttribute("nitfac", getNitf());
        return null;
    }

    public String Save() {
        Integer s = Conexion.getInstancia().hacerConsulta("From Factura").size();
        serie = "N" + s + 1;
        Factura f = new Factura(
                null,
                "N" + s + 1,
                nombref,
                nitf,
                listaArray.size(),
                total,
                efectivo,
                vuelto
        );
        Conexion.getInstancia().agregar(f);

        for (int i = 0; i < listav.size(); i++) {
            Detalle d = new Detalle(
                    null,
                    "N" + s + 1,
                    listaArray.get(i).getProducto(),
                    listaArray.get(i).getNombre(),
                    listaArray.get(i).getPrecio()
            );
            Conexion.getInstancia().agregar(d);
        }

        fchead = Conexion.getInstancia().hacerConsulta("From Factura where serie='" + serie + "'");
        fcbody = Conexion.getInstancia().hacerConsulta("From Detalle where serie='" + serie + "'");

        sesion.setAttribute("fhead", fchead);
        sesion.setAttribute("fbody", fcbody);
        sesion.setAttribute("fserie", serie);

        listav.clear();
        listaArray.clear();
        sesion.setAttribute("nombrefac", "");
        sesion.setAttribute("nitfac", "");
        sesion.setAttribute("tt", 0);
        sesion.setAttribute("cambio", 0);
        setEfectivo(0);
        setNitf("");
        setNombref("");

        return DETALLE_PAGE_REDIRECT;
    }

}
