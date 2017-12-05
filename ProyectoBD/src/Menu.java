import java.io.*;

public class Menu {
	static Queue que = new Queue();
	static Estudiante head = new Estudiante();
	static BufferedReader br= new BufferedReader  (new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	static Arbol root = null;

	public static void main(String[] args) throws IOException
	{	int opcW=1;
		iniciar();
		
		while (opcW!=0){
			bw.write("Base de datos "+"\n");
			bw.write("Opciones "+"\n");
			bw.write("1. Listar Estudiantes"+"\n");
			bw.write("11. Listar Arbol"+"\n");
			bw.write("2. Agregar "+"\n");
			bw.write("3. Eliminar "+"\n");
			bw.write("4. Editar "+"\n");
			bw.write("5. Buscar "+"\n");
			bw.write("6. Proyectos "+"\n");
			bw.write("0. Salir "+"\n");
			bw.flush();
			int opc = Integer.parseInt(br.readLine());
			switch (opc)
			{
			case 1:
				printList();
				break;
			case 11:
				if(root == null)
				{
					bw.write("VACIO "+"\n");
					bw.flush();
				}else
				System.out.println(inorder (root,""));
				break;
			case 2:
				bw.write("VA A AGREGAR UN ESTUDIANTE "+"\n");
				bw.flush();

				String datos[]= new String[6];
				datos=datosNuevos();
	       	 	Estudiante nodo = new Estudiante(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5]);
	       	 	addNodeAtEnd(nodo);
				break;
			case 3:
				bw.write("VA A BORRAR UN ESTUDIANTE "+"\n");
				bw.flush();
				String idB = br.readLine();
				Borrar(idB);
				break;
			case 4:
				bw.write("VA A BUSCAR UN ESTUDIANTE "+"\n");
				bw.write("Ingrese Id "+"\n");
				bw.flush();
				String id = br.readLine();
				Editar(id);
				break;
			case 5:
				caseCinco();
				break;
			case 6:
				caseCinco();
					break;
			case 0:
				FileWriter fichero = null;
		        PrintWriter pw = null;
		        try
		        {
		            fichero = new FileWriter("d:/BD.txt");
		            pw = new PrintWriter(fichero);
		        	 System.out.println("tama;o "+ getSize());
		            		Estudiante temp = head;
		        			while(temp.getNext()!=null)
		        			{
		        				temp = temp.getNext();
		        				pw.println(temp.getId()+","+temp.getNombre()+","+temp.getCedula()+","+temp.getCarrera()+
		        						","+temp.getJornada()+","+temp.getSemestre());
		        			}
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		           try {
		           if (null != fichero)
		              fichero.close();
		           } catch (Exception e2) {
		              e2.printStackTrace();
		           }
		        }
		        opcW=0;
				break;
			default:
				break;
			}
		}
	}
	public static String[] datosNuevos()  throws IOException
	{	int variable;
		boolean op = true;
		String temp="";
		String datos[]= new String[6];
		bw.write(" INGRESE LOS DATOS A CONTINUACION: "+"\n");
		int numeroAleatorio = (int) (Math.random()*10000+1);
		datos[0] = String.valueOf(numeroAleatorio);
		bw.write("Nombre: "+"\n");
		bw.flush();
		datos[1] =br.readLine();
		bw.write("Cedula: "+"\n");
		bw.flush();
		datos[2] =br.readLine();
		datos[3] = carrera ();
		datos[4] = jornada();
		datos[5]=semestre();
			
		return datos;
	}
	public static String semestre() throws IOException
	{
		String cad ="";
		boolean op= true;
		while (op)
		{
			int variable = 0;
			
			bw.write("Semestre: "+"\n");
			bw.write("1. Primero: "+"\n");
			bw.write("2. Segundo: "+"\n");
			bw.write("3. Tercero: "+"\n");
			bw.write("4. Cuarto: "+"\n");
			bw.write("5. Quinto: "+"\n");
			bw.write("6. Sexto: "+"\n");
			bw.write("7. Septimo: "+"\n");
			bw.write("8. Octavo: "+"\n");
			bw.write("9. Noveno: "+"\n");
			bw.write("10. Decimo: "+"\n");
			bw.flush();
			variable =Integer.parseInt(br.readLine());
			switch (variable)
			{
				case 1:
					cad ="primero";
					op=false;
					break;
				case 2:
					cad ="segundo";
					op=false;
					break;
				case 3:
					cad ="tercero";
					op=false;
					break;
				case 4:
					cad ="cuarto";
					op=false;
					break;
				case 5:
					cad ="quinto";
					op=false;
					break;
				case 6:
					cad ="sexto";
					op=false;
					break;
				case 7:
					cad ="septimo";
					op=false;
					break;
				case 8:
					cad ="octavo";
					op=false;
					break;
				case 9:
					cad ="noveno";
					op=false;
					break;
				case 10:
					cad ="decimo";
					op=false;
					break;
			}
		}
		return cad;
	}
	public static String jornada() throws IOException
	{
		String cad ="";
		boolean op= true;
		while (op)
		{
			int variable = 0;
			bw.write("Jornada: "+"\n");
			bw.write("1. Mañana: "+"\n");
			bw.write("2. Tarde: "+"\n");
			bw.write("3. Noche: "+"\n");
			bw.flush();
			variable =Integer.parseInt(br.readLine());
			switch (variable)
			{
			case 1:
				cad ="mañana";
				op=false;
				break;
			case 2:
				cad ="tarde";
				op=false;
				break;
			case 3:
				cad="noche";
				op=false;
				break;
			}
		}
		return cad;

	}
	public static String carrera() throws IOException
	{
		String cad ="";
		boolean op= true;
		while (op)
		{
			int variable = 0;
			bw.write("Carrera: "+"\n");
			bw.write("1. Sistemas "+"\n");
			bw.write("2. Informatica "+"\n");
			bw.write("3. Idiomas "+"\n");
			bw.write("4. Redes "+"\n");
			bw.write("5. Licenciado deportes "+"\n");
			bw.write("6. Finanzas "+"\n");
			bw.flush();
			variable =Integer.parseInt(br.readLine());
			switch (variable)
			{
				case 1:
					cad ="sistemas";
					op=false;
					break;
				case 2:
					cad ="informatica";
					op=false;
					break;
				case 3:
					cad ="idiomas";
					op=false;
					break;
				case 4:
					cad="redes";
					op=false;
					break;
				case 5:
					cad ="licenciado deportes";
					op=false;
					break;
				case 6:
					cad ="finanzas";
					op=false;
					break;
			}
		}
		return cad;
	}
	public static void iniciar()
	{
		BufferedReader br= null;
		File archivo = null;
	    FileReader fr = null;

	      try {
	         archivo = new File ("d:/BD.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea;
	         while((linea=br.readLine())!=null)
	         {
	        	 String datos [] = linea.split(",");
	        	 Estudiante nodo = new Estudiante(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5]);
	        	 addNodeAtEnd(nodo);
	         }
	     		
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}

	public static int getSize() 
	{
		int cont=0;
		Estudiante temp = head.next;
		while (temp != null)
		{
			temp=temp.next;	
			cont++;
		}
		return cont;
	}
	public static void addNodeAtEnd(Estudiante nodo)
	{
			Estudiante temp = head;
			while(temp.getNext()!=null)
			{
				temp = temp.getNext();
			}
			temp.setNext(nodo);
	}
	public static void printList() 
	{
		Estudiante temp =head.next;
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		try
		{
			while (temp != null)
			{
				bw.write(temp.toString());
				temp=temp.next;	
			}
			
			bw.flush();
		}
		catch(IOException e){}
	}
	public static void Editar(String id) throws IOException
	{
			Estudiante temp = head;
			for(int j=0;j<=getSize();j++)
			{
				String comparar= temp.getId();
				if(id.equals(comparar))
				{
					boolean edit = true;
					String nuevoDato;
					while (edit)
					{
						bw.write("VA A EDITAR ESTE ESTUDIANTE : "+"\n");
						bw.write(temp.toString());
						bw.write("QUE PARAMETRO VA A EDITAR?  "+"\n");
						bw.write("1. Nombre "+"\n");
						bw.write("2. Identificacion "+"\n");
						bw.write("3. Carrera "+"\n");
						bw.write("4. Jornada "+"\n");
						bw.write("5. Semestre "+"\n");
						bw.flush();
						int editar = Integer.parseInt(br.readLine());
						switch (editar)
						{
							case 1:
								bw.flush();
								nuevoDato= br.readLine();
								temp.setNombre(nuevoDato);
								edit = false;
								break;
							case 2:
								bw.flush();
								nuevoDato= br.readLine();
								temp.setCedula(nuevoDato);
								edit = false;
								break;
							case 3:
								String car=carrera();
								temp.setCarrera(car);
								edit = false;
								break;
							case 4:
								String jor=jornada();
								temp.setJornada(jor);
								edit = false;
								break;
							case 5:
								String sem=semestre();
								temp.setSemestre(sem);
								edit = false;
								break;
						}
					}
				}
				temp = temp.getNext();
			}
	}
	public static void Borrar(String id) throws IOException
	{

			Estudiante temp = head;
			for(int j=0;j<=getSize();j++)
			{
				String comparar= temp.next.getId();
				if(id.equals(comparar))
				{
					bw.write("Borro este estudiante : "+"\n");
					bw.write(temp.next.toString());
					temp.next=temp.next.next;
					break;
				}
				temp = temp.getNext();
			}
	}
	public static void Buscar(int parametro ,String buscar) throws IOException
	{
		bw.write("VA A Buscar ESTE parametro : "+parametro+"\n");
		Estudiante temp = head.getNext();

		switch(parametro)
		{
			case 1:
				for(int j=0;j<getSize();j++)
				{
					String comparar= temp.getId();
					bw.write("VA A Buscar comparar ESTE id : "+temp.getId()+"\n");
					if(buscar.equals(comparar))
					{
						bw.write(temp.toString());

						break;
					}else
					temp = temp.getNext();
				}
				break;
			case 2:
				for(int j=0;j<getSize();j++)
				{
					String comparar= temp.getNombre();
					bw.write("VA A Buscar comparar ESTE id : "+temp.getNombre()+"\n");
					if(buscar.equals(comparar))
					{
						bw.write(temp.toString());

						break;
					}else
					temp = temp.getNext();
				}
				break;
			case 3:
				for(int j=0;j<getSize();j++)
				{
					String comparar= temp.getCedula();
					bw.write("VA A Buscar comparar ESTE id : "+temp.getCedula()+"\n");
					if(buscar.equals(comparar))
					{
						bw.write(temp.toString());

					break;
					}else
					temp = temp.getNext();
				}
				break;
		}
			
	}
	public static Arbol Arbol(int opc,String buscar) throws IOException
	{
		Arbol found = null;
		Estudiante temp = head.getNext();

		switch(opc){
			case 1 :
				root=null;
				for(int j=0;j<getSize();j++)
				{
					insertArbolId(temp.getId(),temp.getNombre(),temp.getCedula(),temp.getCarrera(),
							temp.getJornada(),temp.getSemestre());
					temp = temp.getNext();
				}
				found = searchArbol(opc,buscar);
			break;
			case 2 :
				root=null;
				for(int j=0;j<getSize();j++)
				{
					insertArbolName(temp.getId(),temp.getNombre(),temp.getCedula(),temp.getCarrera(),
							temp.getJornada(),temp.getSemestre());
					temp = temp.getNext();
				}
				found = searchArbol(opc,buscar);
				break;
			case 3 :
				root=null;
				for(int j=0;j<getSize();j++)
				{
					insertArbolCedula(temp.getId(),temp.getNombre(),temp.getCedula(),temp.getCarrera(),
							temp.getJornada(),temp.getSemestre());
					temp = temp.getNext();
				}
				found = searchArbol(opc,buscar);
				break;
		}
    	return found;
		
	}
	public static void insertArbolName(String id,String nombre, String cedula, String carrera, String jornada , String semestre)
    {	
        Arbol node = new Arbol(id,nombre,cedula,carrera,jornada,semestre);
        if(root == null)
        {
            root = node;
        }
        else
        {
        	Arbol temp = root;
        	Arbol parent = null;
            boolean left = false;   
            while(temp != null)
            {
                parent = temp;
                int letra = (temp.getNombre().charAt(0));
                int letra2 = nombre.charAt(0);
                if(letra2 < letra)
                {
                    temp = temp.getLeft();
                    left = true;
                }
                else
                {
                    temp = temp.getRight();
                    left = false;

                }
            }
            if(left)
            parent.setLeft(node);
            else
            parent.setRight(node);
        }
    }
	public static void insertArbolId(String id,String nombre, String cedula, String carrera, String jornada , String semestre)
    {	
        Arbol node = new Arbol(id,nombre,cedula,carrera,jornada,semestre);
        if(root == null)
        {
            root = node;
        }
        else
        {
        	Arbol temp = root;
        	Arbol parent = null;
            boolean left = false;   
            while(temp != null)
            {
                parent = temp;
                int letra = (temp.getId().charAt(0));
                int letra2 = id.charAt(0);
                if(letra2 < letra)
                {
                    temp = temp.getLeft();
                    left = true;
                }
                else
                {
                    temp = temp.getRight();
                    left = false;

                }
            }
            if(left)
            parent.setLeft(node);
            else
            parent.setRight(node);
        }
    }
	public static void insertArbolCedula(String id,String nombre, String cedula, String carrera, String jornada , String semestre)
    {	
        Arbol node = new Arbol(id,nombre,cedula,carrera,jornada,semestre);
        if(root == null)
        {
            root = node;
        }
        else
        {
        	Arbol temp = root;
        	Arbol parent = null;
            boolean left = false;   
            while(temp != null)
            {
                parent = temp;
                int letra = (temp.getCedula().charAt(0));
                int letra2 = cedula.charAt(0);
                if(letra2 < letra)
                {
                    temp = temp.getLeft();
                    left = true;
                }
                else
                {
                    temp = temp.getRight();
                    left = false;

                }
            }
            if(left)
            parent.setLeft(node);
            else
            parent.setRight(node);
        }
    }
	static Arbol searchArbol (int parameter , String value)
	    {
	     
		 switch(parameter)
		 {
		 	case 1:
		 		 if(root.getId()==value)
			     	{
			     		return root;
			     	}
			     	else
			     	{
			       	 Arbol temp = root;
					

			     		while(temp != null && !temp.getId().equals(value) )
			     		{
			     			int letra = (temp.getId().charAt(0));
			                int letra2 = value.charAt(0);
			 	    		if(letra2 < letra )
			 	    		{
			     				temp=temp.getLeft();
			     				
			     			}else
			                 {
			                     temp = temp.getRight();
			                 }
			     		}
			     		if (temp == null)
			     		{
			     			return null;
			     		}
			     		else 
			     		{
			     			return temp;
			     		}
			     	}
		 	case 2:
		 		 if(root.getNombre()==value)
			     	{
			     		return root;
			     	}
			     	else
			     	{
			       	 Arbol temp = root;
					

			     		while(temp != null && !temp.getNombre().equals(value) )
			     		{
			     			int letra = (temp.getNombre().charAt(0));
			                int letra2 = value.charAt(0);
			 	    		if(letra2 < letra )
			 	    		{
			     				temp=temp.getLeft();
			     				
			     			}else
			                 {
			                     temp = temp.getRight();
			                 }
			     		}
			     		if (temp == null)
			     		{
			     			return null;
			     		}
			     		else 
			     		{
			     			return temp;
			     		}
			     	}
		 	
		 	case 3:
		 		 if(root.getCedula()==value)
			     	{
			     		return root;
			     	}
			     	else
			     	{
			       	 Arbol temp = root;
					

			     		while(temp != null && !temp.getCedula().equals(value) )
			     		{
			     			int letra = (temp.getCedula().charAt(0));
			                int letra2 = value.charAt(0);
			 	    		if(letra2 < letra )
			 	    		{
			     				temp=temp.getLeft();
			     				
			     			}else
			                 {
			                     temp = temp.getRight();
			                 }
			     		}
			     		if (temp == null)
			     		{
			     			return null;
			     		}
			     		else 
			     		{
			     			return temp;
			     		}
			     	}
		 }
		 
			return null;
	
	    }
	static String inorder(Arbol subroot, String list)
    {
        if(subroot.getLeft() != null)
          list = inorder(subroot.getLeft(),list);
        
        list += "/" + subroot.toString();
        
        if(subroot.getRight() != null)
          list = inorder(subroot.getRight(),list);
        
        return list;
    }
	static void caseCinco()throws IOException
	{
		Arbol search = new Arbol();
		bw.write("Por cual criterio buscara "+"\n");
		bw.write("1. ID"+"\n");
		bw.write("2. NOMBRE "+"\n");
		bw.write("3. CEDULA "+"\n");
		bw.write("4. JORNADA "+"\n");
		bw.write("5. CARRERA "+"\n");
		bw.write("6. SEMESTRE "+"\n");
		bw.flush();
		int opc2 = Integer.parseInt(br.readLine());
		if(opc2==4 || opc2==5 || opc2==6  )
		{
			Estudiante temp = head.getNext();
			Queue que = null;
			int var ;
			switch(opc2)
			{
			case 4: 
				bw.write("1. Mañana: "+"\n");
				bw.write("2. Tarde: "+"\n");
				bw.write("3. Noche: "+"\n");
				bw.flush();
				var =Integer.parseInt(br.readLine());
				switch (var)
				{
				case 1:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getJornada().equals("mañana"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 2:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getJornada().equals("tarde"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 3:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getJornada().equals("noche"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
			}
				break;
			//Aqui comparo por carrera
			case 5:
				bw.write("Carrera: "+"\n");
				bw.write("1. Sistemas "+"\n");
				bw.write("2. Informatica "+"\n");
				bw.write("3. Idiomas "+"\n");
				bw.write("4. Redes "+"\n");
				bw.write("5. Licenciado deportes "+"\n");
				bw.write("6. Finanzas "+"\n");
				bw.flush();
				var =Integer.parseInt(br.readLine());
				switch (var)
				{
				case 1:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getCarrera().equals("sistemas"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 2:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getCarrera().equals("informatica"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 3:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getCarrera().equals("idiomas"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 4:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getCarrera().equals("redes"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 5:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getCarrera().equals("licenciado deportes"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 6:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getCarrera().equals("finanzas"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
			}
				break;
			//Aqui comparo por semestre
			case 6:
				bw.write("Semestre: "+"\n");
				bw.write("1. Primero: "+"\n");
				bw.write("2. Segundo: "+"\n");
				bw.write("3. Tercero: "+"\n");
				bw.write("4. Cuarto: "+"\n");
				bw.write("5. Quinto: "+"\n");
				bw.write("6. Sexto: "+"\n");
				bw.write("7. Septimo: "+"\n");
				bw.write("8. Octavo: "+"\n");
				bw.write("9. Noveno: "+"\n");
				bw.write("10. Decimo: "+"\n");
				bw.flush();
				var =Integer.parseInt(br.readLine());
				switch (var)
				{
				case 1:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("primero"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 2:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("segundo"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 3:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("tercero"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 4:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("cuarto"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 5:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("quinto"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 6:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("sexto"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 7:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("septimo"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 8:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("octavo"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 9:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("noveno"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
				case 10:
					for(int j=1;j<=getSize();j++)
					{	
						if (que == null)
						{
						que= new Queue ();
						}
						if(temp.getSemestre().equals("decimo"))
						{
							que.enqueue(new Estudiante (temp.getId(),temp.getNombre(),temp.getCedula(),
									temp.getCarrera(),temp.getJornada(),temp.getSemestre()));
						}
						temp = temp.getNext();
					}
					que.doNotPrint();
					break;
			}
				break;
		}
		
		}else
		{
			bw.write("Ingrese parametro "+"\n");
			bw.flush();
			String buscar = br.readLine();
			search = Arbol(opc2,buscar);
			if(search == null )
			{
				System.out.println("NO EXISTE");
			}else
			System.out.println(search.toString());
			bw.flush();
		}
		
	}
	
	
}
