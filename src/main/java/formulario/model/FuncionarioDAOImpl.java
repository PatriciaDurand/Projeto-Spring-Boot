package formulario.model;

import org.hibernate.Session;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by patriciadurand on 18/04/16.
 */
public class FuncionarioDAOImpl<T extends Serializable> implements FuncionarioDAO  {

    List<Funcionario> lista;
    private Session session = null;

    public FuncionarioDAOImpl(Session session) {
        this.session = session;
        lista = new ArrayList<Funcionario>();
    }

    @Override
    public void salvar(Funcionario funcionario) {
        session.beginTransaction();
        session.save(funcionario);
        session.getTransaction().commit();
        lista.add(funcionario);
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