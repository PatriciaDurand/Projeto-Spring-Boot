package formulario.dao;

import formulario.model.Funcionario;

import java.util.List;

/**
 * Created by patriciadurand on 18/04/16.
 */
public interface FuncionarioDAO {

    void salvar(Funcionario funcionario);

    List<Funcionario> listar();
}