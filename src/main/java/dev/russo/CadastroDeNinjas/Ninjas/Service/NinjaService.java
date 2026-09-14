package dev.russo.CadastroDeNinjas.Ninjas.Service;

import dev.russo.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import dev.russo.CadastroDeNinjas.Ninjas.Repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
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

    public NinjaEntity criarNinja(NinjaEntity ninja){
        return ninjaRepository.save(ninja);
    }

}
