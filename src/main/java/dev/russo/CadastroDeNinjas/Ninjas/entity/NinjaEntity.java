package dev.russo.CadastroDeNinjas.Ninjas.entity;

import dev.russo.CadastroDeNinjas.Missoes.entity.MissoesEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NinjaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesEntity missoes;

}
