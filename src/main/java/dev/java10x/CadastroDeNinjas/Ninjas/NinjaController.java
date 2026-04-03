package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

@RestController //mapea o arquivo e fala q é um controller
@RequestMapping("/ninjas") // junto com o RestController, mapa das rotas no mesmo lugar
public class NinjaController {

        @GetMapping("/boasvindas") //pega informaçoes⬇
        public String boasVindas(){

            return "Essa é minha primeira mensagem nessa rota";
        }

        //Adicionar ninja (CREATE)
        @PostMapping("/criar")
        public String criarNinja(){
                return "Ninja criado";
        }


        // Mostrar todos os Ninjas (READ)
        @GetMapping("/listar")
        public String mostrarTodosOsNinjas(){
            return "Mostrar Ninja";
        }

        // Mostrar ninja por ID (READ)
        @GetMapping("/listarID")
        public String mostrarTodosOsNinjasPorId(){
            return "Mostar Ninja por ID";
        }

        // Alterar dados dos ninjas (UPDATE)
        @PutMapping("/alterarID")
        public String alterarNinjaPorId(){
            return "Alterar Ninja por ID";
        }

        // Deletar Ninja (DELETE)
        @DeleteMapping("/deletarID")
        public String deletarNinjaPorId(){
            return "Ninja deletado por Id";
        }
}
