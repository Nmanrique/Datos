
public class Arbol {
	public String id;
	public String nombre;
	public String cedula;
	public String carrera;
	public String jornada;
	public String semestre;
	public Arbol right = null;
	public Arbol left = null;
	
	//zero-parameter constructor
	public Arbol(){}
	
	public Arbol(String id, String nombre, String cedula,String carrera,String jornada,String semestre) 
	{
		this.id=id;
		this.nombre=nombre;
		this.cedula=cedula;
		this.carrera=carrera;
		this.jornada=jornada;
		this.semestre=semestre;

		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public Arbol getRight() {
		return right;
	}
	public void setRight(Arbol right) {
		this.right = right;
	}
	public Arbol getLeft() {
		return left;
	}
	public void setLeft(Arbol left) {
		this.left = left;
	}
	public String toString()
	{
		return " ID: " + this.id + " NOMBRE: " + this.nombre + " CEDULA: " + this.cedula + " CARRERA : " + this.carrera
				 + " JORNADA : " + this.jornada + " SEMESTRE : " + this.semestre + "\n";
	}
	
}
