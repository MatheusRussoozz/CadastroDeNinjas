package dev.russo.CadastroDeNinjas.Missoes.Service;


import dev.russo.CadastroDeNinjas.Missoes.Dto.MissoesDto;
import dev.russo.CadastroDeNinjas.Missoes.Mapper.MissoesMapper;
import dev.russo.CadastroDeNinjas.Missoes.Repository.MissoesRepository;
import dev.russo.CadastroDeNinjas.Missoes.entity.MissoesEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    MissoesRepository missoesRepository;
    MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper){
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todas as missoes
    public List<MissoesDto> listarMissoes(){
        List<MissoesEntity> listaMissoes = missoesRepository.findAll();

        return listaMissoes.stream()
                .map(missoesMapper::toDto)
                .collect(Collectors.toList());

    }

    // Listar por id

    public MissoesDto listarMissaoPorId(Long id){
        Optional<MissoesEntity> missaoPesquisada = missoesRepository.findById(id);

            return missaoPesquisada.map(missoesMapper::toDto)
                    .orElse(null);

    }

    // Criar Missoes
    public MissoesDto criarMissao(MissoesDto missao){
         MissoesEntity missoesEntity = missoesMapper.toEntity(missao);
         missoesRepository.save(missoesEntity);
         return missoesMapper.toDto(missoesEntity);
    }

    // Atualizar missao
    public MissoesDto atualizarMissao(Long id, MissoesDto missoesDto){
        Optional<MissoesEntity> procurarMissao = missoesRepository.findById(id);
        if (procurarMissao.isPresent()){
           MissoesEntity missaoSalvar = missoesMapper.toEntity(missoesDto);
           missaoSalvar.setId(id);
           missoesRepository.save(missaoSalvar);
           return missoesMapper.toDto(missaoSalvar);
        }
        return null;
    }

    //Deletar Missao

    public void deletarMissao(Long id){
        Optional<MissoesEntity> buscaMissao = missoesRepository.findById(id);
        if (buscaMissao.isPresent()){
            missoesRepository.deleteById(id);
        }
        throw new RuntimeException("Missao não encotrada");
    }

}
