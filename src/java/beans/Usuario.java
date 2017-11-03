package beans;

public class Usuario {

        private Integer idUser;
        private String nick;
	private String nombre;
	private String apellido;
	private String contrasena;
	public Usuario(Integer idUser, String nick, String nombre, String apellido, String contrasena) {
		super();
		this.idUser = idUser;
                this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasena = contrasena;
	}
	public Usuario() {
            super();
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
        public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
                
	} 
}
