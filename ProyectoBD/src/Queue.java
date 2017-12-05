
public class Queue {

	private Estudiante front;
	public Queue()
	{
		front =new Estudiante();
	}
	
	public void enqueue (Estudiante element)
	{
		Estudiante temp = front;
		while(temp.getNext()!=null)
		{
			temp = temp.getNext();
		}
		temp.setNext(element);
		element.setNext(null);
	}
	
	public Estudiante dequeue()
	{
		Estudiante temp = front.getNext ();
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
		Estudiante temp=front.getNext();
		while(temp!=null)
		{
			System.out.println(temp.toString());
			temp= temp.getNext();
		}
		
	}
}

