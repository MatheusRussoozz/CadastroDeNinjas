package dev.russo.CadastroDeNinjas.Ninjas.Controller;

import dev.russo.CadastroDeNinjas.Ninjas.Dto.NinjaDTO;
import dev.russo.CadastroDeNinjas.Ninjas.Entity.NinjaEntity;
import dev.russo.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
           NinjaDTO ninjaDTO =  ninjaService.criarNinja(ninja);
           return ResponseEntity.status(HttpStatus.CREATED)
                   .body("Ninja Criado com sucesso: " + ninjaDTO.getNome() + " (ID): "+ ninjaDTO.getId());
        }

        // Mostrar Todos os Ninjas (Read)
        @GetMapping("/listar")
        public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas(){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninjaService.listarNinjas());

        }

        // Mostrar Ninja por id (Read)
        @GetMapping("/listar/{id}")
        public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjaPorId(id) != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninjaService.listarNinjaPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID: "+ id +" não encontrado");
        }
        }

        // Alterar dados do ninja (Update)
        @PutMapping("/atualizar/{id}")
        public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja ){
        if (ninjaService.listarNinjaPorId(id) != null){
            ninjaService.atualizarNinjaPorId(id, ninja);
            return ResponseEntity.status(HttpStatus.OK).body(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID: "+ id +" não encontrado");
        }
        }


        // Deletar Ninja (Delete)
        @DeleteMapping("/deletar/{id}")
        public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if (ninjaService.deletarNinja(id)){
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja com o ID: "+ id +  " deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID: "+ id + " não Encontrado");
        }
        }
}
