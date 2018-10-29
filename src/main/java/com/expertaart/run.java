package com.expertaart;

import static org.junit.Assert.assertTrue;

public class run {
	static Matriz matriz;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("=== Experta ART ===");
		System.out.println("=== Test ===");
		
		try {
			matriz = new Matriz(4);
			
			execute("UPDATE 2 2 2 4");
			execute("QUERY 1 1 1 3 3 3");
			execute("UPDATE 1 1 1 23");
			execute("QUERY 2 2 2 4 4 4");
			execute("QUERY 1 1 1 3 3 3");
			execute("UPDATE 2 2 2 1");
			execute("QUERY 1 1 1 1 1 1");
			execute("QUERY 1 1 1 2 2 2");
			execute("QUERY 2 2 2 2 2 2");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		System.out.println("Done.");
	}
	
	static private void execute(String comando)
	{
		resultMatriz res = matriz.execute(comando);
		if(comando.length()>16)
		{
		    System.out.println(comando + "\t->\t" + res.toString());
		}
		else
		{
			System.out.println(comando + "\t\t->\t" + res.toString());
		}
	}

}
