/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * Created by patriciadurand on 15/04/16.
 */
public class MestreObra extends Servente {

    private int numFuncionario;
    
    //MestreDeObras: classe derivada da classe Servente.
    //Para cada mestre de obras é necessário armazenar quantos funcionarios estão sob sua supervisão.
    //Um mestre de obras ganha um adicional de 10% para cada grupo de 10 funcionários que estão sob seu comando.
    public MestreObra(int codigo, String nome, double salarioBase, double insalubridade, int func) {
        super(codigo, nome, salarioBase, insalubridade);
        numFuncionario = func;

    }

    public int getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(int numFuncionario) {
        if(numFuncionario<0)
            numFuncionario=0;
        this.numFuncionario = numFuncionario;
    }

    @Override
    public double getSalarioLiquido() {
        double adic = (numFuncionario/10) * 0.1 * super.getSalarioBase();
        return super.getSalarioLiquido() + adic;
    }

    @Override
    public String toString() {
        return super.toString() + "Total de Funcionarios " + numFuncionario;
    }
    
    
}
