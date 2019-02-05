package tk.raficruz.dataextractor.model;

import java.io.Serializable;
import java.util.List;

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
public class LancamentoConta implements Serializable {

	private static final long serialVersionUID = -3335511543882317253L;

	private TotalControleLancamento totalControleLancamento;
	private List<ControleLancamento> listaControleLancamento;
	private Long indice;
	private Long tamanhoPagina;
	private Long totalElements;
}
