package tk.raficruz.datamanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.raficruz.datamanager.model.LancamentoConta;

@Repository
public interface LancamentoContaRepository extends JpaRepository<LancamentoConta, Long> {
}
