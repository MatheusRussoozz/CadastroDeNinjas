package dev.russo.CadastroDeNinjas.Ninjas.Repository;

import dev.russo.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<NinjaEntity, Long> {
}
