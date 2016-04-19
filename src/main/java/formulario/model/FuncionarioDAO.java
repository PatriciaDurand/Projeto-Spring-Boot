package formulario.model;

import java.util.ArrayList;

/**
 * Created by patriciadurand on 18/04/16.
 */
public interface FuncionarioDAO {

    public void savar(Funcionario funcionario);

    public ArrayList<Funcionario> listar();
}
