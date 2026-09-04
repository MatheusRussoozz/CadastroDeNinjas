package dev.russo.CadastroDeNinjas.Ninjas.Entity;

import dev.russo.CadastroDeNinjas.Missoes.entity.MissoesEntity;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesEntity missoes;

}
