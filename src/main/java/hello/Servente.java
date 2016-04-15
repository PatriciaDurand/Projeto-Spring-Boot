/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * Created by patriciadurand on 15/04/16.
 */
public class Servente extends Funcionario {

    private double insal;
    
    //Servente: classe derivada da classe Funcionario.
    //Um servente recebe um adicional de 5% a título de insalubridade
    public Servente(int codigo, String nome, double salarioBase, double insalubridade) {
        super(codigo, nome, salarioBase);
        insal = insalubridade;
    }

    @Override
    public double getSalarioLiquido() {
        double salario = super.getSalarioLiquido();
        insal = salario * 0.05;
        double novoSalario = salario + insal;
        return novoSalario;
        // ou return super.getSalarioLiquido() + getSalarioLiquido()*0.05;
    }
}