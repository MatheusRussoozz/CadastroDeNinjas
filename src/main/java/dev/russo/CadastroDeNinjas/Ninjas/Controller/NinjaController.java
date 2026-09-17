package dev.russo.CadastroDeNinjas.Ninjas.Controller;

import dev.russo.CadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.russo.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import dev.russo.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
        public String boasVindas(){
            return "Essa é minha primeira mensagem nessa rota";
        }

        // Adicionar Ninja (Create)
        @PostMapping("/criar")
        public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
            return ninjaService.criarNinja(ninja);
        }

        // Mostrar Todos os Ninjas (Read)
        @GetMapping("/listar")
        public List<NinjaEntity> mostrarTodosOsNinjas(){
            return ninjaService.listarNinjas();
        }

        // Mostrar Ninja por id (Read)
        @GetMapping("/listar/{id}")
        public NinjaEntity listarNinjaPorId(@PathVariable Long id){
            return ninjaService.listarNinjaPorId(id);
        }

        // Alterar dados do ninja (Update)
        @PutMapping("/atualizar/{id}")
        public NinjaEntity alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaEntity ninja ){
            return ninjaService.atualizarNinjaPorId(id, ninja);
        }


        // Deletar Ninja (Delete)
        @DeleteMapping("/deletar/{id}")
        public void deletarNinjaPorId(@PathVariable Long id){
            ninjaService.deletarNinja(id);
        }
}
