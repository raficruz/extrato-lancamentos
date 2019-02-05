package tk.raficruz.datamanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tk.raficruz.datamanager.model.ControleLancamento;
import tk.raficruz.datamanager.model.LancamentoConta;
import tk.raficruz.datamanager.repository.ControleLancamentoRepository;
import tk.raficruz.datamanager.service.LancamentoService;
import tk.raficruz.datamanager.util.FileUtil;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private ControleLancamentoRepository repository;

	@Override
	public Page<ControleLancamento> listarTodos(Pageable pageable) {
		return repository.listAll(pageable);
	}

	@Override
	public Page<ControleLancamento> getJson(Pageable pageable) {
		LancamentoConta lancamento = FileUtil.getControleLancamentoFromJson();
		return new PageImpl<ControleLancamento>( lancamento.getListaControleLancamento() );
	}

}
