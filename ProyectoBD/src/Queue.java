
public class Queue {

	private Proyectos front;
	public Queue()
	{
		front =new Proyectos();
	}
	
	public void enqueue (Proyectos element)
	{
		Proyectos temp = front;
		while(temp.getNext()!=null)
		{
			temp = temp.getNext();
		}
		temp.setNext(element);
		element.setNext(null);
	}
	
	public Proyectos dequeue()
	{
		Proyectos temp = front.getNext ();
		front.setNext(front.getNext().getNext());
		return temp;
	}
	public boolean isEmpty()
	{
		if(front.getNext()==null)
		{
			return true;
		}else{
			return false;
		}
	}
	public void doNotPrint()
	{
		Proyectos temp=front.getNext();
		while(temp!=null)
		{
			System.out.println(temp.toString());
			temp= temp.getNext();
		}
		
	}
	public String print()
	{
		String cadena="";
		Proyectos temp=front.getNext();
		while(temp!=null)
		{
			cadena=cadena+(temp.getId()+","+temp.getNombreP()+","+temp.getDescripcion()+","
					+temp.getCalificacion()+","+temp.getObservaciones()+ "\n");
			temp= temp.getNext();
		}
		return cadena;
		
	}
}

