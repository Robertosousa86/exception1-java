package br.com.robertosousa.exception1.modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/aaaa");
	
	public Reserva() {

	}

	public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		super();
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	// os métodos setCheckIn e setCheckOut foram apagaos porque só podem ser
	// modificados através de métodos.
	
	public long duracao() {
		long diferenca = checkOut.getTime() - checkIn.getTime();
		return  TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); // converte milisecundos para dias.
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Número do quarto: " + numeroDoQuarto
				+", checkIn: " + sdf.format(checkIn)
				+ ", checkOut: " + sdf.format(checkOut)
				+ ", " 
				+ duracao() + " Noites";
	}

	

	
	
	
}
