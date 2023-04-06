package com.mycompany.hibernate;

public class Main {

    public static void main(String[] args) {
        
        Produto produto = new Produto();
        produto.setNome("Lápis");
        produto.setPreco(2.50);
        
        //Insert
        Controller controller = new Controller();
        //controller.salvarProduto(produto);
        
        //Update
        controller.editarProduto("Lápis", 1.50);
        
    }
    
}
