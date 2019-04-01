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
    
    /**
     * Método para verificar se foi solicitado um mesa.
     * @param mesa
     * @return true ou false;
     */
    
    boolean temComanda(int mesa);
    
    /**
     * Método para salvar comanda.
     * @param comanda
     * @return true ou false;
     */
    
    boolean salvarComanda(Comanda comanda);
    /**
     * Método para atualizar comanda.
     * @param novacomanda
     * @param mesaVelha
     * @return true ou false;
     */
    boolean atualizarComanda(Comanda novacomanda, int mesaVelha);
    /**
     * Método para deletar mesa.
     * @param mesa
     * @return true ou false;
     */
    boolean deletaComanda(int mesa);
    /**
     * Método para lista comandas
     * @return 
     */
    Set<Comanda> getComanda();
}
