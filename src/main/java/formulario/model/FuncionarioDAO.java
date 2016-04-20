package formulario.model;

import java.util.List;

/**
 * Created by patriciadurand on 18/04/16.
 */
public interface FuncionarioDAO {

    void salvar(Funcionario funcionario);

    List<Funcionario> listar();
}