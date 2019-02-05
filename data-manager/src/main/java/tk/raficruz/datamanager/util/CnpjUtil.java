package tk.raficruz.datamanager.util;

public class CnpjUtil {

	public static String calculaDVs(String CNPJ) {

		char dig13, dig14;
		int sm, resto, num, peso;

		// Calculo do 1o. Digito Verificador
		sm = 0;
		peso = 2;
		for (int index = 11; index >= 0; index--) {
			num = (int) (CNPJ.charAt(index) - 48);
			sm = sm + (num * peso);
			peso = peso + 1;

			if (peso == 10) {
				peso = 2;
			}
		}

		resto = sm % 11;

		if ((resto == 0) || (resto == 1)) {
			dig13 = '0';
		} else {
			dig13 = (char) ((11 - resto) + 48);
		}

		// Calculo do 2o. Digito Verificador
		sm = 0;
		peso = 2;

		for (int index = 12; index >= 0; index--) {
			num = (int) (CNPJ.charAt(index) - 48);
			sm = sm + (num * peso);
			peso = peso + 1;

			if (peso == 10) {
				peso = 2;
			}
		}

		resto = sm % 11;
		if ((resto == 0) || (resto == 1)) {
			dig14 = '0';
		} else {
			dig14 = (char) ((11 - resto) + 48);
		}

		return Character.toString(dig13).concat(Character.toString(dig14));

	}

}
