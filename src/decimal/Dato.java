package decimal;

/**
 * Clase que contiene propiedades de validación y tipos correspondientes a 
 * los sistemas numéricos que se pueden convertir en este programa. 
 * 
 * @author antonio
 *
 */
public class Dato {
	
	/**
	 * 
	 * @param dato
	 * @return
	 */
	public boolean validarRangoDecimal(String dato) {
		int numero = Integer.parseInt(dato);
		return numero > 0 && numero < 4000;
	}
	
	public boolean validarFormatoDato(String dato, String[] formatoValido) {
		int validarFormato = 0;
		
		for(String caracter : formatoValido) {
			for(int i = 0; i < dato.length(); i++) {
				if (dato.toUpperCase().substring(i, i + 1).equals(caracter)) {
					validarFormato++;
				}
			}
		}
		
		return validarFormato == dato.length();
	}
	
	/**
	 * 
	 * @param dato
	 * @return
	 */
	public TipoDato validarTipoDato(String dato) {
		
		String[] datoRomanoValido = {"I", "V", "X", "L", "C", "D", "M"};
		String[] datoDecimalValido = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		
		if (validarFormatoDato(dato, datoDecimalValido)) {
			return TipoDato.Decimal;
		} else if (validarFormatoDato(dato, datoRomanoValido)) {
			return TipoDato.Romano;
		}
		
		return TipoDato.NoExiste;
	}
	
	/**
	 * 
	 * @author antonio
	 *
	 */
	public enum TipoDato {
		Decimal,
		Romano,
		NoExiste
	}
}