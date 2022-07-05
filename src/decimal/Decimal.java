package decimal;

public class Decimal {
	
	/**
	 * 
	 * @param numero
	 * @return
	 */
	public String decimalToRomano(String numero) {
		String romano = "";
		
		numero = validarLongitud(numero);
		
		for(int i = numero.length(); i > 0; i--) {	
			switch (i) {
			case 1:
				romano = millaresToRomano(numero.substring(i - 1, i)) + romano;
				break;
			case 2:
				romano = centenasToRomano(numero.substring(i - 1, i)) + romano;
				break;
			case 3:
				romano = decenasToRomano(numero.substring(i - 1, i)) + romano;
				break;
			case 4:
				romano = unidadesToRomano(numero.substring(i - 1, i)) + romano;
				break;
			}
		}
		
		return romano;
	}
	
	/**
	 * 
	 * @param unidad
	 * @return
	 */
	private String unidadesToRomano(String unidad) {
		switch (unidad) {
		case "1":
			return "I";
		case "2":
			return "II";
		case "3":
			return "III";
		case "4":
			return "IV";
		case "5":
			return "V";
		case "6":
			return "VI";
		case "7":
			return "VII";
		case "8":
			return "VIII";
		case "9":
			return "IX";
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param decena
	 * @return
	 */
	private String decenasToRomano(String decena) {
		switch (decena) {
		case "1":
			return "X";
		case "2":
			return "XX";
		case "3":
			return "XXX";
		case "4":
			return "XL";
		case "5":
			return "L";
		case "6":
			return "LX";
		case "7":
			return "LXX";
		case "8":
			return "LXXX";
		case "9":
			return "XC";
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param centena
	 * @return
	 */
	private String centenasToRomano(String centena) {
		switch (centena) {
		case "1":
			return "C";
		case "2":
			return "CC";
		case "3":
			return "CCC";
		case "4":
			return "CD";
		case "5":
			return "D";
		case "6":
			return "DC";
		case "7":
			return "DCC";
		case "8":
			return "DCCC";
		case "9":
			return "CM";
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param millar
	 * @return
	 */
	private String millaresToRomano(String millar) {
		switch (millar) {
		case "1":
			return "M";
		case "2":
			return "MM";
		case "3":
			return "MMM";
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param cadenaDecimal
	 * @return
	 */
	private String validarLongitud(String cadenaDecimal) {
		int longitud = cadenaDecimal.length();
		String numero = cadenaDecimal;
		
		if (longitud != 4) {
			for(int i = longitud; i < 4; i++) {
				numero = '0' + numero;
			}
		}
		
		return numero;
	}
}
