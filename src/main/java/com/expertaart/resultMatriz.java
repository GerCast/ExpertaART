package com.expertaart;

public class resultMatriz {
	public enum statusResult {
		SUCCESS, ERROR
	}
	
	public static statusResult status;
	
	int value;
	
	public resultMatriz(statusResult status, int value) {
		// TODO Auto-generated constructor stub
		
		this.status = status;
		this.value = value;
	}
	
	public String toString()
	{
		return this.status.toString() + " / " + value;
	}

}
