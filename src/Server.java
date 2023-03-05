import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class Server {

	public static void main (String[] args) throws IOException{
		
		char[] operacion;
		int operandoUno, operandoDos, resultado=0;
		String simbolo="";
		
		
		ServerSocket servidor= new ServerSocket(9999);
		
		Socket miSocket= servidor.accept();
		
		DataInputStream flujoEntrada= new DataInputStream(miSocket.getInputStream());
		
		operacion= flujoEntrada.readUTF().toCharArray();
		
		operandoUno=Integer.parseInt(String.valueOf(operacion[0]));
		operandoDos=Integer.parseInt(String.valueOf(operacion[2]));
		
		if(operacion[1]=='+') {
			resultado= operandoUno + operandoDos;
		}
		if(operacion[1]=='-') {
			resultado= operandoUno - operandoDos;
		}
		if(operacion[1]=='*') {
			resultado= operandoUno * operandoDos;
		}

		System.out.println("El resultado es: " + resultado);
		
		flujoEntrada.close();
		
		miSocket.close();
		
	}
}
