package decimal;
import java.util.Scanner;

import decimal.Dato.TipoDato;

/**
 * Clase que maneja el flujo principal de la ejecución y funcionalidad de este programa. 
 * 
 * @author antonio
 *
 */
public class Main {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		String numero = ""; 
		boolean errorFlag = false;
		
		Dato dato = new Dato();
		Decimal decimal = new Decimal();
		Romano romano = new Romano();
		TipoDato tipo = TipoDato.NoExiste;
		
		do {
			System.out.print("Introduce un número decimal o romano: ");
			numero = in.next();
			
			tipo = dato.validarTipoDato(numero);
			
			switch (tipo) {
			case Decimal:
				if (dato.validarRangoDecimal(numero)) {
					numero = decimal.decimalToRomano(numero);
				} else {
					System.out.println("No se puede convertir. Los números romanos tienen un rango de 1 a 3999.\n\n");
					errorFlag = true;
				}
				break;
				
			case Romano:
				if (numero.length() <= 15) {
					numero = romano.romanoToDecimal(numero);
				} else {
					System.out.println("Número romano inválido.\n");
					errorFlag = true;
				}
				break;
				
			default:
				System.out.println("El número ingresado no corresponde a un número romano o en sistema decimal.\n\n");
				errorFlag = true;
				break;
			}
			
			if (errorFlag == false) {
				System.out.println("El número es equivalente a: " + numero + "\n\n");
			}
		
		} while(true);
	}
}
