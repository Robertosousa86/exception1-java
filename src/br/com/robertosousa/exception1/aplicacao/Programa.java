package br.com.robertosousa.exception1.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import br.com.robertosousa.exception1.modelo.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto:  ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data de check-in(dd/MM/yyyy): ");
		Date checkIn = sf.parse(sc.next());
		System.out.print("Data de check-out(dd/MM/yyyy): ");
		Date checkOut = sf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de check-out deve ser posterior a data de check-in");
		} else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.print("Digite a data para atualizara reserva: ");
			System.out.print("Data de check-in(dd/MM/yyyy): ");
			checkIn = sf.parse(sc.next());
			System.out.print("Data de check-out(dd/MM/yyyy): ");
			checkOut = sf.parse(sc.next());

			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println(
						"Erro na reserva: As datas das reservas para atualização devem ser posteriores a data atual.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data de check-out deve ser anterior a data de check-in");
			} else {
				reserva.atualizarDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();
	}

}
