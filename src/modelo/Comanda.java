/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lancchonete.entindades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public class Comanda {

    private List<Pedido> pedidos;
    private double totalAtual;
    private LocalDateTime data;

    public Comanda() {
    }

    public Comanda(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        calcTotalAtual();
        this.data = LocalDateTime.now();
    }

    private void calcTotalAtual() {
        for (int i = 0; i < pedidos.size(); i++) {

            this.totalAtual += pedidos.get(i).getSubRotal();
        }
    }

    @Override
    public String toString() {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Comanda{" + "pedidos=" + pedidos + ", totalAtual=" + totalAtual + ", data=" + data.format(formatter) + '}';
    }
    

}
