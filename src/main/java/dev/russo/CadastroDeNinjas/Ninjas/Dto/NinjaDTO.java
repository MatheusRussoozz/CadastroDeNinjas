package dev.russo.CadastroDeNinjas.Ninjas.Dto;

import dev.russo.CadastroDeNinjas.Missoes.entity.MissoesEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {


    private Long id;
    private String nome;
    private String email;
    private String imUrl;
    private int idade;
    private String rank;
    private MissoesEntity missoes;



}
