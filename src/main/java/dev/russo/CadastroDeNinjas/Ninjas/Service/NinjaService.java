package dev.russo.CadastroDeNinjas.Ninjas.Service;

import dev.russo.CadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.russo.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import dev.russo.CadastroDeNinjas.Ninjas.Mapper.NinjaMapper;
import dev.russo.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas

    public List<NinjaEntity> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar ninja por ID
    public NinjaEntity listarNinjaPorId(Long id){
        Optional<NinjaEntity> ninjaEntity = ninjaRepository.findById(id);

        return ninjaEntity.orElse(null);
    }

    // Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaEntity ninjaEntity = ninjaMapper.toEntity(ninjaDTO);
        ninjaRepository.save(ninjaEntity);
        return ninjaMapper.toDto(ninjaEntity);
    }

    //Deletar ninja
    public void deletarNinja(Long id){
        Optional<NinjaEntity> ninjaExiste = ninjaRepository.findById(id);

        if (ninjaExiste.isPresent()){
            ninjaRepository.deleteById(id);
        }else {
            throw new RuntimeException("Ninja Não Encontrado");
        }
    }

    // Atualizar Ninja
    public NinjaEntity atualizarNinjaPorId(Long id, NinjaEntity ninja) {

        if (ninjaRepository.existsById(id)){
            ninja.setId(id);
            ninjaRepository.save(ninja);
        }
        return null;
    }

}
