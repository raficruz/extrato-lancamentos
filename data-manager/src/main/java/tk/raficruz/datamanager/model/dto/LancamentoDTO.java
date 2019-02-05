package tk.raficruz.datamanager.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LancamentoDTO implements Serializable {

	private static final long serialVersionUID = 3911732980723700334L;

	private String dataLancamento;	//18/11/2016 
	private String descricao;		//Regular
	private String numero;			//67210807400
	private String situacao;		//Pago 
	private String dataConfirmacao;	//18/11/2016 
	private String dadosBancarios;	//BANCO ABCD S.A Ag 12 CC 0001231234
	private String valorFinal;		//R$ 28.714,00

}
