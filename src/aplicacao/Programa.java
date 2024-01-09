	package aplicacao;
	
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Scanner;
	
	import model.entities.Reserva;
import model.exceptions.DomainExceptions;
	
	public class Programa {
	
		public static void main(String[] args) { 
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
			System.out.print(" Numero do quarto:");
			int numero = sc.nextInt();
			System.out.print("Data de Entrada (dd/MM/yyyy):");
			Date dataDeEntrada = sdf.parse(sc.next()); // Entra com a data no formato de texto, e o SimpleDateFormat formata
			System.out.print("Data de Saida (dd/MM/yyyy):");
			Date dataDeSaida = sdf.parse(sc.next());
	        Reserva reserva = new Reserva(numero, dataDeEntrada, dataDeSaida); // Estanciando a reserva
			System.out.println("Reserva: " + reserva); // Mostra na tela
			//Ler os dados atualizados
			System.out.println();
			System.out.println("Atualize a data de reserva: ");
			System.out.print("Data de Entrada (dd/MM/yyyy):");
			dataDeEntrada = sdf.parse(sc.next()); // Entra com a data no formato de texto, e o SimpleDateFormat formata
			System.out.print("Data de Saida (dd/MM/yyyy):");
			dataDeSaida = sdf.parse(sc.next());
	
			reserva.atualizaDatas(dataDeEntrada, dataDeSaida);
			System.out.println("Reserva: " + reserva);
			}
			catch(ParseException e){
				System.out.println("Formato de data invalida!!!");
			}
			catch(DomainExceptions e) {
				System.out.println("Erro na reserva: " + e.getMessage());
			}
			catch(RuntimeException e) {
				System.out.println("Erro inesperado!!!");
			}
	
			sc.close(); // Problemas esta lógica esta no programa principal,o ideal seria ela estar na
						// reserva
	
		}
	}
