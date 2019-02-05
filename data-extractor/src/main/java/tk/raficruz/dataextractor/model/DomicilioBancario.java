package tk.raficruz.dataextractor.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioBancario implements Serializable {

	private static final long serialVersionUID = 3306578969826014693L;

	private Long codigoBanco;
	private Long numeroAgencia;
	private String numeroContaCorrente;
}
