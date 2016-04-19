package formulario.model;

import java.util.ArrayList;

/**
 * Created by patriciadurand on 18/04/16.
 */
public class FuncionarioDAOImpl implements FuncionarioDAO {

    ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

    @Override
    public void savar(Funcionario funcionario) {
        lista.add(funcionario);
    }

    @Override
    public ArrayList<Funcionario> listar() {
      return lista;
    }
}
