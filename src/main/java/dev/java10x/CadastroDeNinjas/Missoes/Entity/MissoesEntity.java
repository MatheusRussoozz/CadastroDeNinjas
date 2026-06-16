package dev.java10x.CadastroDeNinjas.Missoes.Entity;

import dev.java10x.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    //@OneToMany Uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaEntity> ninjas;

}
