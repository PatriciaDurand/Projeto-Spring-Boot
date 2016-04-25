package formulario.dao;

import formulario.model.Funcionario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by patriciadurand on 18/04/16.
 */

@Repository("FuncionarioDAO")
public class FuncionarioDAOImpl extends AbstractDao<Integer, Funcionario> implements FuncionarioDAO {

    ArrayList<Funcionario> lista = new ArrayList<Funcionario>();

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public void salvar(Funcionario funcionario) {
        lista.add(funcionario);
        //sessionFactory.getCurrentSession().persist(funcionario);
    }

    @Override
    @Transactional
    public List<Funcionario> listar() {
//        Criteria criteria = createEntityCriteria();
//        List<Funcionario> funcionarios = (List<Funcionario>) criteria.list();
//        return funcionarios;
        return lista;
    }
}