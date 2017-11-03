package manager;

import beans.Producto;
import db.Conexion;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@ManagedBean
public class ManejadorProducto {
    
    public static final String PRODUCT_PAGE_REDIRECT = "product.xhtml?faces-redirect=true";

    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpSession sesion = request.getSession(true);
    
    private Producto pro = new Producto();
    private Part file1;
    private Part file2;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public Producto getProducto() {
        return pro;
    }

    public void setProducto(Producto producto) {
        this.pro = producto;
    }
    
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); 
            }
        }
        return null;
    }
    
    public String AddProduct() throws IOException, ServletException {
            Producto pr = new Producto(
                    null,
                    pro.getCodigo(),
                    pro.getNombre(),
                    pro.getPrecio(),
                    pro.getUnidad(),
                    getFilename(getFile1()),
                    getFilename(getFile2())
            );
            Conexion.getInstancia().agregar(pr);
            return PRODUCT_PAGE_REDIRECT;
    }

}
