package dev.russo.CadastroDeNinjas.Missoes.Repository;

import dev.russo.CadastroDeNinjas.Missoes.entity.MissoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissoesRepository extends JpaRepository<MissoesEntity, Long> {
}
