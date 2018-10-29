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
public class MatrizConstructorTest {
	private static Matriz matriz;

	@BeforeClass
	public static void beforeClass() throws Exception {
		matriz = new Matriz(4);
	}

	@Test(expected = Exception.class)
	public void isValidMatrizConstraintExcedTest() throws Exception {
		matriz = new Matriz(102);
	}

	@Test(expected = Exception.class)
	public void isValidMatrizConstraintTest() throws Exception {
		matriz = new Matriz(0);
	}
}
