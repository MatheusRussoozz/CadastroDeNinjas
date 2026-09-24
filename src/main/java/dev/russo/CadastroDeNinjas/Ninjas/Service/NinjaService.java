package dev.russo.CadastroDeNinjas.Ninjas.Service;

import dev.russo.CadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.russo.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import dev.russo.CadastroDeNinjas.Ninjas.Mapper.NinjaMapper;
import dev.russo.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    public List<NinjaDTO> listarNinjas(){
        List<NinjaEntity> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::toDto)
                .collect(Collectors.toList());
    }

    //Listar ninja por ID
    public NinjaDTO  listarNinjaPorId(Long id){
        Optional<NinjaEntity> ninjaEntity = ninjaRepository.findById(id);
        return ninjaEntity.map(ninjaMapper::toDto).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaEntity ninjaEntity = ninjaMapper.toEntity(ninjaDTO);
        ninjaRepository.save(ninjaEntity);
        return ninjaMapper.toDto(ninjaEntity);
    }

    //Deletar ninja
    public Boolean deletarNinja(Long id){
        Optional<NinjaEntity> ninjaExiste = ninjaRepository.findById(id);

        if (ninjaExiste.isPresent()){
            ninjaRepository.deleteById(id);
            return true;

        }else {
            return false;
        }
    }

    // Atualizar Ninja
    public NinjaDTO atualizarNinjaPorId(Long id, NinjaDTO ninja) {
        Optional<NinjaEntity> ninjaEntity = ninjaRepository.findById(id);
        if (ninjaEntity.isPresent()) {
            NinjaEntity ninjaNovo = ninjaMapper.toEntity(ninja);
            ninjaNovo.setId(id);
            ninjaRepository.save(ninjaNovo);
            return ninjaMapper.toDto(ninjaNovo);
        }
        throw new RuntimeException("Ninja Não Encontrado");
    }
}
