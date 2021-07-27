package br.com.zupacademy.thiago.casadocodigo.exception;

public class StandardError {

	private String campo;
	private String mensagem;
	
	public StandardError(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	
}
