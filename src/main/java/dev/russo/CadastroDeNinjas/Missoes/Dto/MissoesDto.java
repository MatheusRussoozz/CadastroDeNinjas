package dev.russo.CadastroDeNinjas.Missoes.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.russo.CadastroDeNinjas.Missoes.entity.MissoesEntity;
import dev.russo.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissoesDto {

    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaEntity> ninjas;

}
