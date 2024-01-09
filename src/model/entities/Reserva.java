package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
private Integer numeroDoQuarto;
private Date dataDeEntrada;
private Date dataDeSaida;
private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//Criando construtor com argumentos
public Reserva(Integer numeroDoQuarto, Date datadeEntrada, Date dataDeSaida) {
	
	this.numeroDoQuarto = numeroDoQuarto;
	this.dataDeEntrada = datadeEntrada;
	this.dataDeSaida = dataDeSaida;
}
public Integer getNumeroDoQuarto() {
	return numeroDoQuarto;
}
public void setNumeroDoQuarto(Integer numeroDoQuarto) {
	this.numeroDoQuarto = numeroDoQuarto;
}
public Date getDatadeEntrada() {
	return dataDeEntrada;
}

public Date getDataDeSaida() {
	return dataDeSaida;
}
public long duracao() {
	long dif = dataDeSaida.getTime() - dataDeEntrada.getTime();
	return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
}
public String atualizaDatas(Date dataDeEntrada , Date dataDeSaida) {
	Date agora = new Date(); // Cria uma data deste momento
	if (dataDeEntrada.before(agora) || dataDeSaida.before(agora)) {
		return "Erro na reserva: As datas para atualizacao tem que ser datas futuras!!!";
	}
	if (!dataDeSaida.after(dataDeEntrada)) {
		return "Erro na reserva:data de saida tem que ser depois da data de entrada!!!";
	}
	this.dataDeEntrada = dataDeEntrada; // Passando pelos if sem erro executa as atualizaçoes de entrada e saida
	this.dataDeSaida = dataDeSaida;
	return null; // Não deu erro
}
@Override // Pois o toString e uma sobreposicao
public String toString() {
	   return " Quarto "
			   + numeroDoQuarto
			   + ", entrada:"
			   + sdf.format(dataDeEntrada)
			   + ", saida:"
			   + sdf.format(dataDeSaida)
			   + " , "
			   + duracao()
			   + " noites ";
			   
	
}






}
