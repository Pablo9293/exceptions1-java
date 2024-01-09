package model.exceptions;

public class DomainExceptions extends RuntimeException{// tem que tratar esta exceção
	private static final long serialVersionUID = 1L; // versao
	public DomainExceptions(String msg) {
		super(msg);
	}
	

}
