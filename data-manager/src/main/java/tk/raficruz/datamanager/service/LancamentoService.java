package tk.raficruz.datamanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tk.raficruz.datamanager.model.ControleLancamento;

public interface LancamentoService {
	Page<ControleLancamento> listarTodos(Pageable pageable);
	Page<ControleLancamento> getJson(Pageable pageable);
}
