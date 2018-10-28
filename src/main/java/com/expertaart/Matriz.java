package com.expertaart;

/**
 * @author gcastillo
 *
 */
public class Matriz {
	private int[][][] matrizData;
	private int lado = 0;

	public enum status {
		SUCCESS, ERROR
	}

	/**
	 * 
	 * Siendo N el tamaño de la matriz 
	 * 1 <= N <= 100 
	 * 1 <= x1 <= x2 <= N 
	 * 1 <= y1 <= y2 <= N 
	 * 1 <= z1 <= z2 <= N 
	 * 1 <= x,y,z <= N 
	 * Siendo W el valor de una celda
	 * 
	 * @param lado
	 * 
	 *            Constructor Matriz cubica con el lado especificado en eel
	 *            parametro lado
	 * @throws Exception
	 */
	public Matriz(int lado) throws Exception {
		matrizData = null;

		if (!(lado >= 1 && lado <= 100)) {
			throw new Exception("Lado debe estar entre 0 y 100");
		}
		this.lado = lado;
		matrizData = new int[lado][lado][lado];
	}

	/**
	 * @param comando
	 *            Comando para ejecutar
	 */
	public resultMatriz execute(String comando) {

		String[] parametros = comando.split(" ");

		if (parametros.length < 1) {
			return new resultMatriz(Matriz.status.ERROR, 0);
		}

		if ("UPDATE".equals(parametros[0])) {
			return Update(parametros);

		} else if ("QUERY".equals(parametros[0])) {
			return Query(parametros);
		}

		return new resultMatriz(Matriz.status.ERROR, 0);

	}

	public String printMatriz() {

		String resultado = "";

		for (int i = 0; i <= this.lado; i++) {
			for (int j = 0; j <= this.lado; j++) {
				for (int h = 0; h <= this.lado; h++) {
					resultado += resultado + matrizData + System.lineSeparator();
				}
			}
		}
		return resultado;
	}

	private resultMatriz Query(String[] parametros) {
		if (parametros.length < 1) {
			return new resultMatriz(Matriz.status.ERROR, 0);
		}

		return new resultMatriz(Matriz.status.ERROR, 0);
	}

	private resultMatriz Update(String[] parametros) {
		int x;
		int y;
		int z;
		int w;

		if (parametros.length <= 5) {

			try {
				x = Integer.parseInt(parametros[1]);
				y = Integer.parseInt(parametros[2]);
				z = Integer.parseInt(parametros[3]);
				w = Integer.parseInt(parametros[4]);

				if (x > 0 && x <= lado && y > 0 && y <= lado && z > 0 && z <= lado) {

					matrizData[x][y][z] = w;
				}
				return new resultMatriz(Matriz.status.SUCCESS, matrizData[x][y][z]);

			} catch (Exception e) {
				return new resultMatriz(Matriz.status.ERROR, 0);
			}
		}

		return new resultMatriz(Matriz.status.ERROR, 0);
	}

}
