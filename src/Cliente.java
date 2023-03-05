import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class Cliente {

	public static void main(String[] args) throws IOException{
		
		String operacion="";
		Scanner input= new Scanner (System.in);
		
		Socket miSocket= new Socket("localhost", 9999);
		DataOutputStream flujoSalida= new DataOutputStream(miSocket.getOutputStream());
		
		
		while(operacion.length()!= 3) {
			System.out.print("Introduce la operación: ");
			operacion= input.next();
		}
		
		flujoSalida.writeUTF(operacion);
		
		flujoSalida.close();
		
		miSocket.close();
	}
}
