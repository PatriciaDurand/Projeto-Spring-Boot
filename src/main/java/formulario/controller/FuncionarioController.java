package formulario.controller;

/**
 * Created by patriciadurand on 14/04/16.
 */

import formulario.Funcionario;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class FuncionarioController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/cadastro")
    public String adicionaFuncionario(@ModelAttribute("form") Funcionario funcionario, Model model) {
        model.addAttribute("name", funcionario.getNome());
        model.addAttribute("salario", funcionario.getSalarioBase());
        return "Funcionario";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FuncionarioController.class, args);
    }
}

