package tk.raficruz.datamanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.raficruz.datamanager.model.ControleLancamento;
import tk.raficruz.datamanager.model.dto.LancamentoDTO;
import tk.raficruz.datamanager.model.mapper.LancamentoContaMapper;
import tk.raficruz.datamanager.service.LancamentoService;

@RestController
@RequestMapping("lancamentos")
public class LancamentosController {

	@Autowired
	private LancamentoService service;

	@Autowired
	private LancamentoContaMapper mapper; 

	@Transactional(readOnly = true)
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<LancamentoDTO> ListarTodos( 
			@PageableDefault(sort = {"id"}, 
							 direction = Sort.Direction.ASC, 
							 page = 0, size = 100) Pageable pageable) {

		Page<ControleLancamento> lancamentos = service.listarTodos(pageable);
		return mapper.toPage(lancamentos, pageable);
	}

	@Transactional(readOnly = true)
	@GetMapping(value = "/json", produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<LancamentoDTO> listaEstatica ( 
			@PageableDefault(sort = {"id"}, 
							 direction = Sort.Direction.ASC, 
							 page = 0, size = 100) Pageable pageable) {

		Page<ControleLancamento> lancamentos = service.getJson(pageable);
		return mapper.toPage(lancamentos, pageable);
	}
}
