package dev.russo.CadastroDeNinjas.Missoes.entity;

import dev.russo.CadastroDeNinjas.Ninjas.entity.NinjaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MissoesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaEntity> ninjas;


}
