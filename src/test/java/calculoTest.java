import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.expertaart.Calculo;

public class calculoTest {
	private static Calculo calculo;
	
	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("Antes de todas");
		calculo = new Calculo();
	}
	
	@Before
	public void before()
	{
		System.out.println("Antes de cada una");
	}
	
	@Test
	public void isGreaterTest()
	{
		System.out.println("La Prueba");
		assertTrue("Num 1 no es mayor que Num 2: " , calculo.isGreater(4, 3));
	}
	
	@Test
	public void isMinorTest()
	{
		System.out.println("La Prueba");
		assertFalse("Num 1 no es mayor que Num 2: " , calculo.isGreater(2, 3));
	}
	
	@Test
	public void isEqualTest()
	{
		System.out.println("La Prueba");
		assertFalse("Num 1 no es mayor que Num 2: " , calculo.isGreater(3, 3));
	}
	
	@After
	public void after()
	{
		System.out.println("Despues de cada una");
	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("Despues de todas");
	}
	

}
