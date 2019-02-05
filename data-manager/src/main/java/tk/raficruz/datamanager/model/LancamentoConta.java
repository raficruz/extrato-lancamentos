package tk.raficruz.datamanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name="TBL_LANCAMENTO_CONTA")
public class LancamentoConta implements Serializable {

	private static final long serialVersionUID = -3335511543882317253L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "total_controle_id")
	private TotalControleLancamento totalControleLancamento;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "controle_lancamento_id")
	private List<ControleLancamento> listaControleLancamento;

	@Column(name = "indice")
	private Long indice;

	@Column(name = "tamanho_pagina")
	private Long tamanhoPagina;

	@Column(name = "total_elements")
	private Long totalElements;
}
