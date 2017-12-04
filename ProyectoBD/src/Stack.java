
public class Stack {
	private Estudiante top;
	
	public Stack ()
	{
		top=new Estudiante();
	}
	
	public void push (Estudiante element)
	{
		element.setNext (top.getNext());
		top.setNext(element);
	}
	
	public Estudiante pop ()
	{
		Estudiante temp = top.getNext();
		top.setNext(top.getNext().getNext());
		return temp;
	}
	
	public boolean isEmpty()
	{
		if(top.getNext()==null)
		{
			return true;
		}else{
			return false;
		}
	}
	public void doNotPrint()
	{
		Estudiante temp=top.getNext();
		while(temp!=null)
		{
			System.out.println(temp.getId());
		}
		
	}
		
}
