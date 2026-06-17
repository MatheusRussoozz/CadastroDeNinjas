package dev.java10x.CadastroDeNinjas.Missoes.Repository;

import dev.java10x.CadastroDeNinjas.Missoes.Entity.MissoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissoesRepository extends JpaRepository<MissoesEntity, Long> {
}
