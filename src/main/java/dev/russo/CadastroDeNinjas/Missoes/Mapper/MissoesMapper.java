package dev.russo.CadastroDeNinjas.Missoes.Mapper;

import dev.russo.CadastroDeNinjas.Missoes.Dto.MissoesDto;
import dev.russo.CadastroDeNinjas.Missoes.entity.MissoesEntity;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesEntity toEntity(MissoesDto missoesDto){
        MissoesEntity missoesEntity = new MissoesEntity();

        missoesEntity.setId(missoesDto.getId());
        missoesEntity.setNome(missoesDto.getNome());
        missoesEntity.setDificuldade(missoesDto.getDificuldade());
        missoesEntity.setNinjas(missoesDto.getNinjas());

        return missoesEntity;
    }

    public MissoesDto toDto(MissoesEntity missoesEntity){
        MissoesDto missoesDto = new MissoesDto();

        missoesDto.setId(missoesEntity.getId());
        missoesDto.setNome(missoesEntity.getNome());
        missoesDto.setDificuldade(missoesEntity.getDificuldade());
        missoesDto.setNinjas(missoesEntity.getNinjas());

        return missoesDto;
    }

}
