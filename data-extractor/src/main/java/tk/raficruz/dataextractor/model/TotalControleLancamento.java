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
public class TotalControleLancamento implements Serializable {

	private static final long serialVersionUID = -3171277930476181978L;

	private Long quantidadeLancamentos;
	private Long quantidadeRemessas;
	private Double valorLancamentos;
}
