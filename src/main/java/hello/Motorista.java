/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

/**
 *
 * Created by patriciadurand on 15/04/16.
 */
public class Motorista extends Funcionario {

    private long cartMotorista;

    //Motorista: classe derivada da classe Funcionario.
    //Para cada motorista é necessário armazenar o número da carteira de motorista.
    public Motorista(int codigo, String nome, double salarioBase, long cartMot) {
        super(codigo, nome, salarioBase);
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
