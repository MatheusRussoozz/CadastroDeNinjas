package dev.russo.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

        @GetMapping("/boasvindas")
        public String boasVindas(){
            return "Essa é minha primeira mensagem nessa rota";
        }

        // Adicionar Ninja (Create)
        @PostMapping("/criar")
        public String criarNinja(){
            return "Ninja Criado";
        }

        // Mostrar Todos os Ninjas (Read)
        @GetMapping("/listar")
        public String mostrarTodosOsNinjas(){
            return "Mostrar Ninja";
        }

        // Mostrar Ninja por id (Read)
        @GetMapping("/listarID")
        public String mostrarTodosOsNinjasPorId(){
            return "Mostrar Ninja por id";
        }

        // Alterar dados do ninja (Update)
        @PutMapping("/alterarID")
        public String alterarNinjaPorId(){
            return "Alterar ninja por id";
        }

        // Deletar Ninja (Delete)
        @DeleteMapping("/deletarID")
        public String deletarNinjaPorId(){
            return "Ninja deletado por id";
        }
}
