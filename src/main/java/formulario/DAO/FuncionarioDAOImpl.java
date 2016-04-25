package formulario.DAO;

import formulario.model.Funcionario;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by patriciadurand on 18/04/16.
 */

public class FuncionarioDAOImpl<T extends Serializable> implements FuncionarioDAO {

    private Session session = null;
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Funcionario funcionario) {
        session.beginTransaction();
        session.save(funcionario);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public List<Funcionario> listar() {
        session.beginTransaction();
        List funcionarios = session.createQuery("FROM Funcionario").list();
        session.getTransaction().commit();
        return funcionarios;
    }
}