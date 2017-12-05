public class Proyectos {
	public String id;
	public String nombreP;
	public String descripcion;
	public String calificacion;
	public String observaciones;
	public Proyectos next=null;

	public Proyectos (){}
	public Proyectos(String id, String nombreP, String descrip,String califi,String observ) 
	{
		this.id=id;
		this.nombreP=nombreP;
		this.descripcion=descrip;
		this.calificacion=califi;
		this.observaciones=observ;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreP() {
		return nombreP;
	}
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Proyectos getNext() {
		return next;
	}
	public void setNext(Proyectos next) {
		this.next = next;
	}
	public String toString()
	{
		return " ID: " + this.id + " NOMBRE PROYECTO: " + this.nombreP + " DESCRIPCION : " + this.descripcion +
				" CALIFICAION : " + this.calificacion+ " OBSERVACIONES: " + this.observaciones+ "\n";
	}


}
