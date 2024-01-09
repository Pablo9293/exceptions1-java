package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException { // Propaga a exceção que nao esta sendo tratada
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print(" Numero do quarto:");
		int numero = sc.nextInt();
		System.out.print("Data de Entrada (dd/MM/yyyy):");
		Date dataDeEntrada = sdf.parse(sc.next()); // Entra com a data no formato de texto, e o SimpleDateFormat formata
		System.out.print("Data de Saida (dd/MM/yyyy):");
		Date dataDeSaida = sdf.parse(sc.next());

		Reserva reserva = new Reserva(numero, dataDeEntrada, dataDeSaida);
		System.out.println("Reserva: " + reserva);
		System.out.println();
		System.out.println("Atualize a data de reserva: ");
		System.out.print("Data de Entrada (dd/MM/yyyy):");
		dataDeEntrada = sdf.parse(sc.next()); // Entra com a data no formato de texto, e o SimpleDateFormat formata
		System.out.print("Data de Saida (dd/MM/yyyy):");
		dataDeSaida = sdf.parse(sc.next());

		String error = reserva.atualizaDatas(dataDeEntrada, dataDeSaida);
		if (error != null) {
			System.out.println("Erro na reserva: " + error);
		} else {
			System.out.println("Reserva: " + reserva);
		}

		// }

		sc.close(); // Problemas esta lógica esta no programa principal,o ideal seria ela estar na
					// reserva

	}
}
