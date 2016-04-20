/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario.standby;

import formulario.model.Funcionario;

/**
 *
 * Created by patriciadurand on 15/04/16.
 */
public class Motorista extends Funcionario {

    private long cartMotorista;

    //Motorista: classe derivada da classe Funcionario.
    //Para cada motorista é necessário armazenar o número da carteira de motorista.
    public Motorista(String nome, double salarioBase, long cartMot) {
        super(nome, salarioBase);
        cartMotorista = cartMot;
    }

    public void setCartMotorista(long cartMotorista) {
        this.cartMotorista = cartMotorista;
    }

    public long getCartMotorista() {
        return cartMotorista;
    }

    @Override
    public String toString() {
        return super.toString() + "cartMotorista=" + cartMotorista + '}';
    }
}
