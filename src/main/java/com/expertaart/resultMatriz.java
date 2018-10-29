package com.expertaart;

public class resultMatriz {
	Matriz.status status;
	int value;
	
	public resultMatriz(Matriz.status status, int value) {
		// TODO Auto-generated constructor stub
		
		this.status = status;
		this.value = value;
	}
	
	public String toString()
	{
		return this.status.toString() + " / " + value;
	}

}
