package decimal;

public class Romano {
	
	/**
	 * 
	 * @param cadenaRomano
	 * @return
	 */
	private String validarLongitud(String cadenaRomano) {
		String numero = cadenaRomano;
		
		int longitud = cadenaRomano.length();
		int multiploInf = longitud / 4;		
		int multiploSup = multiploInf + 1;	
		int multiploSupLen = 4 * multiploSup;
		
		if (longitud % 4 != 0) {			
			for(int i = longitud; i < multiploSupLen + 4; i++) {
				numero = numero + '0';
			}
		} else {
			numero = numero + "0000";
		}
		
		return numero;
	}
	
	/**
	 * 
	 * @param numero
	 * @return
	 */
	public String romanoToDecimal(String numero) {
		int i;
		String segmento;
		String retorno;
		String decimal = "";
		TipoDigito flag = TipoDigito.Millar;
		
		numero = validarLongitud(numero).toUpperCase();
		
		i = numero.length() - 3;
		
		try {
			for (int begin = 0; begin <= i - 1 ; begin++) {
				for (int end = 4; end > 0; end--) {
					
					segmento = numero.substring(begin, begin + end);
					
					switch (flag) {
					case Millar:
						retorno = millaresToDecimal(segmento);
						
						if (!retorno.equals("")) { // Coincidió
							flag = TipoDigito.Centena;
							decimal = decimal + retorno;
							begin = begin + end;
							end = 5;
							
						} else if (end == 1 && decimal.equals("")) { // No coincidió
							flag = TipoDigito.Centena;
							begin = -1;
						}
						break;
						
					case Centena:
						retorno = centenasToDecimal(segmento);
						
						if (!retorno.equals("")) { // Coincidió
							flag = TipoDigito.Decena;
							decimal = decimal + retorno;
							begin = begin + end;
							end = 5;
							
						} else if (end == 1 && retorno.equals("")) { // No Coincidió
							flag = TipoDigito.Decena;
							begin = begin - 1;
							if (!decimal.equals("") && decimal.length() == 1) { // pero ya hubo millar 
								decimal = decimal + '0';
							}
						}
						break;
						
					case Decena:
						retorno = decenasToDecimal(segmento);
						
						if (!retorno.equals("")) { // Coincidió
							flag = TipoDigito.Unidad;
							decimal = decimal + retorno;
							begin = begin + end;
							end = 5;
							
						} else if (end == 1 && retorno.equals("")) { // No Coincidió
							flag = TipoDigito.Unidad;
							
							if (!decimal.equals("") && decimal.length() <= 2) { // pero ya hubo millar o centena 
								decimal = decimal + '0';
								begin--;
							} else {
								begin = -1;
							}
						}
						break;
						
					case Unidad:
						retorno = unidadesToDecimal(segmento);
						
						if (!retorno.equals("")) { // Coincidió
							flag = TipoDigito.None;
							decimal = decimal + retorno;
							begin = begin + end;
							end = 5;
							
						} else if (end == 1 && retorno.equals("")) { // No Coincidió
							if (!decimal.equals("") && decimal.length() <= 3) { // pero ya hubo millar, centena o decena 
								flag = TipoDigito.None;
								decimal = decimal + '0';
							}
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			
		}
		
		return decimal;
	}
	
	/**
	 * 
	 * @param unidad
	 * @return
	 */
	private String unidadesToDecimal(String unidad) {
		switch (unidad) {
		case "I":
			return "1";
		case "II":
			return "2";
		case "III":
			return "3";
		case "IV":
			return "4";
		case "V":
			return "5";
		case "VI":
			return "6";
		case "VII":
			return "7";
		case "VIII":
			return "8";
		case "IX":
			return "9";
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param decena
	 * @return
	 */
	private String decenasToDecimal(String decena) {
		switch (decena) {
		case "X":
			return "1";
		case "XX":
			return "2";
		case "XXX":
			return "3";
		case "XL":
			return "4";
		case "L":
			return "5";
		case "LX":
			return "6";
		case "LXX":
			return "7";
		case "LXXX":
			return "8";
		case "XC":
			return "9";
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param centena
	 * @return
	 */
	private String centenasToDecimal(String centena) {
		switch (centena) {
		case "C":
			return "1";
		case "CC":
			return "2";
		case "CCC":
			return "3";
		case "CD":
			return "4";
		case "D":
			return "5";
		case "DC":
			return "6";
		case "DCC":
			return "7";
		case "DCCC":
			return "8";
		case "CM":
			return "9";
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param millar
	 * @return
	 */
	private String millaresToDecimal(String millar) {
		switch (millar) {
		case "M":
			return "1";
		case "MM":
			return "2";
		case "MMM":
			return "3";
		default:
			return "";
		}
	}
	
	private enum TipoDigito {
		Millar, Centena, Decena, Unidad, None
	}
}
