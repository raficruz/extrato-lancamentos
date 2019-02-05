package tk.raficruz.dataextractor.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MockUtil {
	private static final List<String> ALPHABET = new ArrayList<String>( 
														Arrays.asList(
															"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
															"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
															"W", "X", "Y", "Z") );

	public static Long getRandomLongValue(int tamanho) {
		String sValue = getRandomStringNumberValue(tamanho);
		return Long.parseLong(sValue);
	}

	public static String getRandomStringNumberValue(int tamanho) {
		Random gerador = new Random();
		Long generatedLong = gerador.nextLong();
		generatedLong = generatedLong < 0? (generatedLong * -1) : generatedLong;
		String sValue = String.valueOf(generatedLong);
		sValue = String.format("%18s", sValue).replace(' ', '0');
		return sValue.substring( 0, tamanho );
	}

	public static String getRandomIntegerValue(int tamanho) {
		Random gerador = new Random();
		Integer generatedInt = gerador.nextInt();
		generatedInt = generatedInt < 0? (generatedInt * -1) : generatedInt;
		String sValue = String.valueOf(generatedInt);
		sValue = String.format("%9s", sValue).replace(' ', '0');
		return sValue.substring( 0, tamanho );
	}

	public static Double getRandomDoubleValue(int tamanho) {
		String value = getRandomStringNumberValue(tamanho) + "." + getRandomStringNumberValue(2);
		return Double.parseDouble(value);
	}

	public static String getRandomNomeSituacaoRemessa() {
		return new Random().nextInt(2) == 1? "Pago" : "Pendente";
	}

	public static String getRandomNomeTipoOperacao() {
		return new Random().nextInt(2) == 1? "Regular" : "Irregular";
	}

	public static String getRandomString(int size, boolean includingSpaces) {
		Random gerador = new Random();
		StringBuilder sb = new StringBuilder();

		List<String> charsSet = ALPHABET;

		if(includingSpaces) {
			charsSet.add(" ");
		}

        for (int i = 0; i < size; ++i) {
            sb.append( charsSet.get( gerador.nextInt(charsSet.size()) ) );
        }

        return sb.toString().trim();
    }
}
