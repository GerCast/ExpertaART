/**
 * 
 */
package com.expertaart;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author gcastillo
 *
 */
public class MatrizTest {
	private static Matriz matriz;

	@Before
	public  void before() throws Exception {
		matriz = new Matriz(4);
	}

	
	@Test
	public void executeTestGeneral()
	{
		resultMatriz res = matriz.execute("UPDATE 2 2 2 4");
		assertTrue(res.status == Matriz.status.SUCCESS);
		res = matriz.execute("QUERY 1 1 1 3 3 3");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 4);

		res = matriz.execute("UPDATE 1 1 1 23");
		assertTrue(res.status == Matriz.status.SUCCESS);
		res = matriz.execute("QUERY 2 2 2 4 4 4");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 4);
		res = matriz.execute("QUERY 1 1 1 3 3 3");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 27);

		res = matriz.execute("UPDATE 2 2 2 1");
		assertTrue(res.status == Matriz.status.SUCCESS);
		res = matriz.execute("QUERY 1 1 1 1 1 1");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 23);
		res = matriz.execute("QUERY 1 1 1 2 2 2");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 24);
		res = matriz.execute("QUERY 2 2 2 2 2 2");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 1);
	
	}
	/**
	 * 
	 */
	@Test
	public void executeTest() {
		resultMatriz res = matriz.execute("UPDATE 2 2 2 4");
		assertTrue(res.status == Matriz.status.SUCCESS);
		res = matriz.execute("QUERY 1 1 1 3 3 3");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 4);
	}

	@Test
	public void executeTest2() {
		resultMatriz res = matriz.execute("UPDATE 1 1 1 23");
		assertTrue(res.status == Matriz.status.SUCCESS);
		res = matriz.execute("QUERY 2 2 2 4 4 4");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 0);
		res = matriz.execute("QUERY 1 1 1 3 3 3");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 23);
	}

	@Test
	public void executeTest3() {
		resultMatriz res = matriz.execute("UPDATE 2 2 2 1");
		assertTrue(res.status == Matriz.status.SUCCESS);
		res = matriz.execute("QUERY 1 1 1 1 1 1");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 0);
		res = matriz.execute("QUERY 1 1 1 2 2 2");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 1);
		res = matriz.execute("QUERY 2 2 2 2 2 2");
		assertTrue(res.status == Matriz.status.SUCCESS && res.value == 1);
	}

	/**
	 * W debe ser mayor que cero
	 */
	@Test
	public void executeExecuteValidationWLessThanTest() {
		// W debe ser mayor que cero
		resultMatriz res = matriz.execute("UPDATE 2 2 2 -127");
		assertTrue(res.status == Matriz.status.ERROR);
	}
	
	@Test
	public void executeExecuteValidationWGreaterThanTest() {
		// W debe ser mayor que cero
		resultMatriz res = matriz.execute("UPDATE 2 2 2 127");
		assertTrue(res.status == Matriz.status.ERROR);
	}

	@Test
	public void executeExecuteValidationLessThanNTest() {

		// W debe ser menor igual que cien
		resultMatriz res = matriz.execute("UPDATE 2 2 2 102");
		assertTrue(res.status == Matriz.status.SUCCESS);
	}

	@Test
	public void executeExecuteValidationGreaterFourParametersTest() {

		// UPDATE debe tener 4 parametros
		resultMatriz res = matriz.execute("UPDATE 2 2 2 102 4");
		assertTrue(res.status == Matriz.status.ERROR);
	}

	@Test
	public void executeExecuteValidationLessFourParametersTest() {

		// UPDATE debe tener 4 parametros
		resultMatriz res = matriz.execute("UPDATE 2 2 2");
		assertTrue(res.status == Matriz.status.ERROR);
	}
	
	@Test
	public void executeExecuteValidationTest() {

		// UPDATE x < N
		resultMatriz res = matriz.execute("UPDATE 2 5 2 4");
		assertTrue(res.status == Matriz.status.ERROR);
	}
	
	@Test
	public void executeExecuteValidationTest2() {

		// UPDATE y < N
		resultMatriz res = matriz.execute("UPDATE 5 2 2 4");
		assertTrue(res.status == Matriz.status.ERROR);
	}
	
	@Test
	public void executeExecuteValidationTest3() {

		// UPDATE z < N
		resultMatriz res = matriz.execute("UPDATE 2 2 5 4");
		assertTrue(res.status == Matriz.status.ERROR);
	}

	@Test
	public void executeExecuteValidationQUERYTest1() {
		// W debe ser mayor que cero
		//resultMatriz res = matriz.execute("UPDATE 2 2 2 4");
		//assertTrue(res.status == Matriz.status.SUCCESS);
		resultMatriz res = matriz.execute("QUERY 1 1 1 3 3 ");
		assertTrue(res.status == Matriz.status.ERROR);
	}
	
	@Test
	public void executeExecuteValidationQUERYTest2() {
		// W debe ser mayor que cero
		//resultMatriz res = matriz.execute("UPDATE 2 2 2 4");
		//assertTrue(res.status == Matriz.status.SUCCESS);
		resultMatriz res = matriz.execute("QUERY 1 1");
		assertTrue(res.status == Matriz.status.ERROR);
	}

	@Test
	public void executeExecuteValidationQUERYTest3() {
		// W debe ser mayor que cero
		//resultMatriz res = matriz.execute("UPDATE 2 2 2 4");
		//assertTrue(res.status == Matriz.status.SUCCESS);
		resultMatriz res = matriz.execute("QUERY 1 1 1 3 3 300");
		assertTrue(res.status == Matriz.status.ERROR);
	}
}
