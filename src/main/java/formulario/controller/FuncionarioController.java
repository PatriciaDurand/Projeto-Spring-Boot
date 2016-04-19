package formulario.controller;

/**
 * Created by patriciadurand on 14/04/16.
 */

import formulario.model.Funcionario;
import formulario.model.FuncionarioDAO;
import formulario.model.FuncionarioDAOImpl;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class FuncionarioController {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAOImpl();

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        //return "index";
        return "Hello World!";
    }

    @RequestMapping(value = "/cadastro")
    public String cadastrarFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "Funcionario";
    }

    @RequestMapping(value = "/adicionafuncionario", method = RequestMethod.POST)
    public String adicionaFuncionario(Funcionario funcionario, Model model) {
        if (funcionario.getNome() != null && funcionario.getSalarioBase() >= 0) {
            //funcionarioDAO.savar(new Funcionario(nome,salario));
            funcionarioDAO.savar(funcionario);
        }
        return "redirect:/cadastro";
    }

    @RequestMapping(value = "/lista", method=RequestMethod.GET)
    public String listarFuncionario(Model model) {
        model.addAttribute("lista", funcionarioDAO.listar());
        return "ListaFuncionarios";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FuncionarioController.class, args);
    }
}

