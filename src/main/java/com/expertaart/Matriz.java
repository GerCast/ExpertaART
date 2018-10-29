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

		if (parametros.length > 0) {

			if ("UPDATE".equals(parametros[0])) {
				return Update(parametros);

			} else if ("QUERY".equals(parametros[0])) {
				return Query(parametros);
			}
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

	/**
	 * Query Command
	 * @param parametros
	 * 4 parameters example ( QUERY x1 y1 z1 x2 y2 z2) 
	 * @return
	 */
	private resultMatriz Query(String[] parametros) {
		int x;
		int y;
		int z;
		int x2;
		int y2;
		int z2;
		int w;

		if (parametros.length == 7) {
			try {
				x = Integer.parseInt(parametros[1]);
				y = Integer.parseInt(parametros[2]);
				z = Integer.parseInt(parametros[3]);
				x2 = Integer.parseInt(parametros[4]);
				y2 = Integer.parseInt(parametros[5]);
				z2 = Integer.parseInt(parametros[6]);
				w = 0;

				if (x > 0 && x <= x2 && y > 0 && y <= y2 && z > 0 && z <= z2) {

					for (int i = x; i <= x2; i++) {
						for (int j = y; j <= y2; j++) {
							for (int h = z; h <= z2; h++) {
								w = w + matrizData[i-1][j-1][h-1];
							}
						}
					}

					return new resultMatriz(Matriz.status.SUCCESS, w);
				}
			} catch (Exception e) {
				return new resultMatriz(Matriz.status.ERROR, 0);
			}
		}

		return new resultMatriz(Matriz.status.ERROR, 0);
	}

	/**
	 * UPDATE Command
	 * @param parametros
	 * 4 parameters example ( UPDATE x y z W), x,y,z coordinates, W = value
	 * @return
	 */
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

				if (x > 0 && x <= lado && y > 0 && y <= lado && z > 0 && z <= lado && w > -127 && w <= 126) {

					matrizData[x-1][y-1][z-1] = w;
					return new resultMatriz(Matriz.status.SUCCESS, matrizData[x-1][y-1][z-1]);
				}
				

			} catch (Exception e) {
				return new resultMatriz(Matriz.status.ERROR, 0);
			}
		}

		return new resultMatriz(Matriz.status.ERROR, 0);
	}

}
