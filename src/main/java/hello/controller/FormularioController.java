package hello.controller;

/**
 * Created by patriciadurand on 14/04/16.
 */

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class FormularioController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/cadastro" )
    public String adicionaFuncionario(Model model) {
        model.addAttribute("name", "Patricia");
        model.addAttribute("salario", "Patricia");
        return "Formulario";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FormularioController.class, args);
    }
}

