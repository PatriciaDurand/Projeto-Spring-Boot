package formulario.model;

import com.sun.org.apache.bcel.internal.util.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * Created by patriciadurand on 15/04/16.
 */

@Entity
@Table(name="Funcionario")
public class Funcionario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    @Column(name="Nome", nullable=false)
    public String nome;

    @Column(name="SalarioBase", nullable=false)
    public double salarioBase;

    public Funcionario() {
    }

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return (salarioBase);
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getSalarioLiquido() {
        double inss = salarioBase * 0.1;
        double ir = 0.0;
        if (salarioBase > 2000.0) {
            ir = (salarioBase - 2000.0) * 0.2;
        }
        return (salarioBase - inss - ir);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", salarioBase=" + salarioBase +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!((Funcionario) obj).getNome().equals(this.nome) ||
                ((Funcionario) obj).getCodigo()!=this.getCodigo() ||
                ((Funcionario) obj).getSalarioBase()!=this.getSalarioBase()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nome);
        return hash;
    }
}