package formulario.controller;

/**
 * Created by patriciadurand on 14/04/16.
 */

import formulario.model.Funcionario;
import formulario.model.FuncionarioDAO;
import formulario.model.FuncionarioDAOImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class FuncionarioController {

    private FuncionarioDAO funcionarioDAO = null;
    Session session = null;

    @RequestMapping("/")
    public String home(Model model) {
        Configuration cfg = new Configuration().configure();
        //Entidades do modelo sendo adicionadas na configuração
        cfg.addAnnotatedClass(Funcionario.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();
        funcionarioDAO = new FuncionarioDAOImpl<Funcionario>(session);

        return "index";
        //return "Hello World!";
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

    public static void main(String[] args) {
        SpringApplication.run(FuncionarioController.class, args);
    }

}