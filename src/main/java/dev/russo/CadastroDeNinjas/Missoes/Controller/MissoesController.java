package dev.russo.CadastroDeNinjas.Missoes.Controller;

import dev.russo.CadastroDeNinjas.Missoes.Dto.MissoesDto;
import dev.russo.CadastroDeNinjas.Missoes.Service.MissoesService;
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
    public List<MissoesDto> listarMissoes(){
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissoesDto listarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }
    @PostMapping("/criar")
    public MissoesDto criarMissao(@RequestBody MissoesDto missoesDto){
        return missoesService.criarMissao(missoesDto);
    }


    @PutMapping("/atualizar/{id}")
    public MissoesDto atualizarMissao(@PathVariable Long id, @RequestBody MissoesDto missoesDto){
        return missoesService.atualizarMissao(id, missoesDto);
    }

    @DeleteMapping ("/deletar/{id}")
    public void DeletarMissao(@PathVariable Long id){
        missoesService.deletarMissao(id);
    }
}
