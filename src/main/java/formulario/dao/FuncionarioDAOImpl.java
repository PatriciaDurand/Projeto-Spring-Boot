package formulario.dao;

import formulario.model.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by patriciadurand on 18/04/16.
 */

@Repository("FuncionarioDAO")
@Transactional
public class FuncionarioDAOImpl extends AbstractDao<Integer, Funcionario> implements FuncionarioDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void salvar(Funcionario funcionario) {
        getSession().persist(funcionario);
    }

    @Override
    public List<Funcionario> listar() {
        Criteria criteria = createEntityCriteria();
        List<Funcionario> funcionarios = (List<Funcionario>) criteria.list();
        return funcionarios;
    }

    @Override
    public Funcionario buscarPorCodigo(int codigo){
        List<Funcionario> funcionarios = listar();

        for (Funcionario f : funcionarios) {
            if (f.getCodigo() == codigo) {
                return f;
            }
        }
        return null;
    }

    @Override
    public void deletar(int codigo) {
        Funcionario funcionario = buscarPorCodigo(codigo);
        getSession().delete(funcionario);
    }
}