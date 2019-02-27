/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Comanda;
import java.util.Set;

/**
 *
 * @author Juvenal Carlos Cardo
 */
public interface ComandaDao {
    
    boolean temComanda(int mesa);
    boolean salvarComanda(Comanda comanda);
    boolean atualizarComanda(Comanda novacomanda, int mesaVelha);
    boolean deletaComanda(int mesa);
    Set<Comanda> getComanda();
}
