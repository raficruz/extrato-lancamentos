package tk.raficruz.datamanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tk.raficruz.datamanager.model.ControleLancamento;

public interface ControleLancamentoRepository extends JpaRepository<ControleLancamento, Long> {

	@Query("SELECT cl FROM ControleLancamento cl")
	Page<ControleLancamento> listAll(Pageable pageable);
}
