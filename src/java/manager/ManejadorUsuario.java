package manager;

import beans.Usuario;
import db.Conexion;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

@ManagedBean
public class ManejadorUsuario{
    public static final String USER_PAGE_REDIRECT = "user.xhtml?faces-redirect=true";

    private Usuario user = new Usuario();

    public Usuario getUsuario() {
        return user;
    }
    
    public void setUsuario(Usuario usuario) {
        this.user = usuario;
    }

    public String AddUsuario() throws IOException, ServletException {
            Usuario us = new Usuario(
                    null,
                    user.getNick(),
                    user.getNombre(),
                    user.getApellido(),
                    user.getContrasena()
            );
            Conexion.getInstancia().agregar(us);
            return USER_PAGE_REDIRECT;
    }
}