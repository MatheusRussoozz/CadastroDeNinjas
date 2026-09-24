package dev.russo.CadastroDeNinjas.Missoes.Controller;

import dev.russo.CadastroDeNinjas.Missoes.Dto.MissoesDto;
import dev.russo.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;
    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDto>> listarMissoes(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(missoesService.listarMissoes());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorId(@PathVariable Long id){
        if (missoesService.listarMissaoPorId(id) != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(missoesService.listarMissaoPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão no id: " + id + " foi encontrada.");
        }
    }



    @PostMapping("/criar")
    public ResponseEntity<MissoesDto> criarMissao(@RequestBody MissoesDto missoesDto){
        missoesService.criarMissao(missoesDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(missoesDto);
    }


    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDto missoesDto){
        if (missoesService.listarMissaoPorId(id) != null){
            missoesService.atualizarMissao(id, missoesDto);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missao de id: " + id + " foi atualizada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão no id: " + id + " foi encontrada.");
        }
    }

    @DeleteMapping ("/deletar/{id}")
    public ResponseEntity<?> DeletarMissao(@PathVariable Long id){
        if (missoesService.deletarMissao(id)){
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missao de id: " + id + " foi deletada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma missão no id: " + id + " foi encontrada.");
        }
    }
    }
