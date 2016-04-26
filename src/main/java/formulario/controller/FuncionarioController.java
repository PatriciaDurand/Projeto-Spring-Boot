package formulario.controller;

/**
 * Created by patriciadurand on 14/04/16.
 */

import formulario.dao.FuncionarioDAO;
import formulario.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/cadastro")
    public String cadastrarFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "CadastroFuncionario";
    }

    @RequestMapping(value = "/adicionafuncionario", method = RequestMethod.POST)
    public String adicionaFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() != null && funcionario.getSalarioBase() >= 0) {
            funcionarioDAO.salvar(funcionario);
        }
        return "redirect:/cadastro";
    }

    @RequestMapping(value = "/lista", method=RequestMethod.GET)
    public String listarFuncionario(Model model) {
        model.addAttribute("lista", funcionarioDAO.listar());
        return "ListaFuncionarios";
    }

}