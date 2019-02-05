package tk.raficruz.datamanager.util;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import tk.raficruz.datamanager.model.LancamentoConta;

public class FileUtil {

	public static LancamentoConta getControleLancamentoFromJson() {
		String jsonPath = FileUtil.class.getClassLoader().getResource("static/lancamento-conta-legado.json").getFile();
		File jsonFile = new File( jsonPath );
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonFile, LancamentoConta.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
