package dev.russo.CadastroDeNinjas.Ninjas.Mapper;


import dev.russo.CadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.russo.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaEntity toEntity(NinjaDTO ninjaDTO){
        NinjaEntity ninjaEntity = new NinjaEntity();
        ninjaEntity.setId(ninjaDTO.getId());
        ninjaEntity.setNome(ninjaDTO.getNome());
        ninjaEntity.setEmail(ninjaDTO.getEmail());
        ninjaEntity.setImUrl(ninjaDTO.getImUrl());
        ninjaEntity.setIdade(ninjaDTO.getIdade());
        ninjaEntity.setRank(ninjaDTO.getRank());
        ninjaEntity.setMissoes(ninjaDTO.getMissoes());

        return ninjaEntity;
    }

    public NinjaDTO toDto(NinjaEntity ninjaEntity){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaEntity.getId());
        ninjaDTO.setNome(ninjaEntity.getNome());
        ninjaDTO.setEmail(ninjaEntity.getEmail());
        ninjaDTO.setImUrl(ninjaEntity.getImUrl());
        ninjaDTO.setIdade(ninjaEntity.getIdade());
        ninjaDTO.setRank(ninjaEntity.getRank());
        ninjaDTO.setMissoes(ninjaEntity.getMissoes());

        return ninjaDTO;
    }


}
