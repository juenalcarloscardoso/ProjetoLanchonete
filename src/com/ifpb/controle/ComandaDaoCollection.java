/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.controle;

import com.ifpb.modelo.Comanda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juvenal Carlos Cardoso
 */
public class ComandaDaoCollection implements ComandaDao {
    private Set<Comanda> comandas;
    private File arquivo;
    
    
    /**
     * Construtor do arquivo e da comanda
     * @throws IOException /
     */
    public ComandaDaoCollection () throws IOException{
        comandas = new HashSet<>();
        arquivo = new File("Comandas");
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }
    /**
     * Método para verificar se foi solicitado uma mesa.
     * @param mesa da Lnchonete
     * @return true ou false;
     */
    @Override
    public boolean temComanda(int mesa){
       Set<Comanda> comandas = null;
        try {
            comandas = getComandas();
        } catch (IOException ex) {
            Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Comanda c: comandas){
            if(c.getNumMesa()== mesa){
                return true;
            }
                  
           
        }
        /*Comanda auxliar = new Comanda( mesa);
        if(comandas.contains(mesa)){
            return true;
        }else{
         return false;
      
        }
       */
        return false;
        
    }
    
     /**
     * Método para salvar comanda.
     * @param comanda representa acomanda aberta
     * @return true ou false;
     */
    @Override
     public boolean salvarComanda(Comanda comanda){
         Set<Comanda> comandas = null;
        try {
            comandas = getComandas();
        } catch (IOException ex) {
            Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
        int mesa = comanda.getNumMesa();
        if(temComanda(mesa)) return false;
        else if(comandas.add(comanda)){
             try {
                 atualizarArquivo(comandas);
             } catch (IOException ex) {
                 Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
             }
            return true;
        } else return false;
     }
     
    /**
     * Método para atualizar comanda.
     * @param novacomanda parametro que permite atualização da comanda
     
     */
    @Override
     public boolean atualizarComanda(Comanda novacomanda, int mesaAntiga){
       
         for(Comanda c: comandas){
             if(c.getNumMesa() == mesaAntiga){
                 comandas.remove(c);
                 comandas.add(novacomanda);
                 try {
                     atualizarArquivo(comandas);
                 } catch (IOException ex) {
                     Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 return true;
             }
         }
         return false;
     }
    
    /**
     * Método para deletar mesa.
     * @param mesa parametro que indica a mesa que dece ser delerada
     * @return true ou false;
     */
    @Override
   public boolean deletaComanda(int mesa){
      Set<Comanda> comandas = null;
        try {
            comandas = getComandas();
        } catch (IOException ex) {
            Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
     for(Comanda c: comandas){
         if(c.getNumMesa()== mesa){
             comandas.remove(c);
             try {
                 atualizarArquivo(comandas);
             } catch (IOException ex) {
                 Logger.getLogger(ComandaDaoCollection.class.getName()).log(Level.SEVERE, null, ex);
             }
             return true;
         }
     }
     return false;
 }
    @Override
  public   Set<Comanda> getComanda(){
     return comandas;
 }
  
  /**
   * 
    
   */
  /**
   * Método para lista comandas
   *@return conjunto de comandas 
   * @throws FileNotFoundException p
   * @throws IOException p
   * @throws ClassNotFoundException p
   */
  public Set<Comanda> getComandas() throws FileNotFoundException, IOException, ClassNotFoundException{
        if(arquivo.length()>0){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
            return (Set<Comanda>) in.readObject();
        }else{
            return new HashSet<>();
        }
        }
    /**
     * Método para atualizar o arquivo onde estão armazenado as comandas.
     * @param comandas representa todas as comandas 
     
     */
    private void atualizarArquivo(Set<Comanda> comandas) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(comandas);
    }
  }
    
    

