package dev.java10x.CadastroDeNinjas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //mapea o arquivo e fala q é um controller
@RequestMapping // junto com o RestController, mapa das rotas no mesmo lugar
public class Controller {

        @GetMapping("/boasvindas") //pega informaçoes⬇
        public String boasVindas(){

            return "Essa é minha primeira mensagem nessa rota";
        }

}
