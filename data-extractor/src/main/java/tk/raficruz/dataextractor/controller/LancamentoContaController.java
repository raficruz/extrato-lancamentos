package tk.raficruz.dataextractor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tk.raficruz.dataextractor.job.LancamentoContaMockJob;

@RestController
@RequestMapping("customer")
public class LancamentoContaController {

	@Autowired
	private LancamentoContaMockJob job;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void execute() {
		job.execute();
	}
}
