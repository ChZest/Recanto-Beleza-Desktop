package dados;

/**
 * @author BIC-Jr Guia de Estilo
 */

public class DadosException extends Exception {
	
	public DadosException(String message) {
		super(message);
	}

	public DadosException(String message, Throwable cause) {
		super(message, cause);
	}

}
