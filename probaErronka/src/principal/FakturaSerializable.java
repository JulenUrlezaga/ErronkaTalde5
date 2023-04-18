package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Klaseak.Faktura;

public class FakturaSerializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Faktura f = new Faktura();
		try {
			FileOutputStream fos = new FileOutputStream("Fakturak.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// lo grabo
			oos.writeObject(f);

			// cierro los recursos abiertos
			oos.close();
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Despu�s lee los datos del Fecha desde fechas.dat y

		try {
			FileInputStream fis = new FileInputStream("fakturak.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// convierte los bytes le�dos en un objeto de la clase Fecha
			f = (Faktura) ois.readObject();

			// muestra el valor del Fecha le�do por pantalla.
			System.out.println("Fecha leido: " + f);
			// cierro los recursos abiertos
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnfe) {
			// si el archivo complejos.dat no est� creado
			System.out.println("Error archivo fechas.dat No encontrado.");
		} catch (IOException ioe) {
			// si se produce otro error de Entrada / Salida
			System.out.println("Error de Entrada / Salida");
		} catch (ClassNotFoundException cnfe) {
			// si se produce un error de Clase No Encontrada
			System.out.println("Error Clase No Encontrada");
		}
	}

}
