package com.mycompany.testeroteirizador;

import java.io.IOException;

/**
 *
 * @author mauricio.rodrigues
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando consulta.");
        
        String veiculo, pontos, pontos2;
        boolean paradas = true;
        veiculo = "caminhao";
        int eixos = 6;
        pontos = "Curitiba,pr;88525-600;Florian%C3%B3polis,sc";
        //pontos2 = "Curitiba%2Cpr%3B88525-600%3BFlorian%C3%B3polis%2Csc";
        
        IntegrationAPI consultaViagem = new IntegrationAPI(pontos, veiculo, eixos, paradas);
        consultaViagem.teste();
        consultaViagem.testeEncode(pontos);
        
    }
}
