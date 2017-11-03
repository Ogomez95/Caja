package manager;

import beans.*;
import db.Conexion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
public class ManejadorAcceso {

   FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sesion = request.getSession(true);
    private Usuario user = new Usuario();
    private List<Object> usuarios = Conexion.getInstancia().hacerConsulta("From Usuario");
    private Producto pro = new Producto();
    private List<Object> productos = Conexion.getInstancia().hacerConsulta("From Producto");
    private List<Object> nivel = Conexion.getInstancia().hacerConsulta("From Satisfaccion");
    private List<Object> nivels = Conexion.getInstancia().hacerConsulta("From Satisfaccion where valor = 4");
    private List<Object> vendido = Conexion.getInstancia().hacerConsulta("From Factura");
    private Double ingresos;
    private Integer provendidos;
    
    public Usuario getUsuario() {
        return user;
    }

    public void setUsuario(Usuario usuario) {
        this.user = usuario;
    }

    public void verificarUsuario() throws IOException {
        Usuario usr = Conexion.getInstancia().autenticarUsuario(user.getNick(), user.getContrasena());
        if (usr.getIdUser() != null) {
            ArrayList<Factura> fc = (ArrayList) vendido;
            ingresos = 0.0;
            provendidos = 0;
            for (int i = 0; i<vendido.size(); i++){
                ingresos += fc.get(i).getTotal();
                provendidos += fc.get(i).getCantidad();
            }
            sesion.setAttribute("listaPersonas", usuarios);
            sesion.setAttribute("nPersonas", usuarios.size());
            sesion.setAttribute("listaProductos", productos);
            sesion.setAttribute("nProductos", productos.size());
            sesion.setAttribute("nivelsatis", ((double)nivels.size() / (double)nivel.size()) * 100);
            sesion.setAttribute("nclientes", nivel.size());
            sesion.setAttribute("ningresos", ingresos);
            sesion.setAttribute("nvendidos", provendidos);
            System.out.println(nivels.size() );
            System.out.println(nivel.size() );
            System.out.println(nivels.size() / nivel.size());
            context.getExternalContext().redirect("home.xhtml");
            
        } else {
            context.getExternalContext().redirect("index.xhtml");
        }
    }
    
}
