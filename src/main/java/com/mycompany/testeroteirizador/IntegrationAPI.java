package com.mycompany.testeroteirizador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author mauricio.rodrigues
 */
public class IntegrationAPI {
    
    private String apiURL = "https://rotasbrasil.com.br/api/v3";
    private String token = "be0fec9037e09b6f6b987b5991ddbf56";
    private String pontos;
    private String veiculo;
    private int eixos;
    private boolean paradas;

    public IntegrationAPI(String pontos, String veiculo, int eixos, boolean paradas) {
        this.pontos = pontos;
        this.veiculo = veiculo;
        this.eixos = eixos;
        this.paradas = paradas;
    }
    
    public void teste () throws IOException{
        //String username = "octocat"; // nome de usuário do GitHub que queremos pesquisar
        String url = this.apiURL + "?pontos=" + this.pontos + "&veiculo=" + this.veiculo + "&eixos=" + this.eixos + "&paradas=" + this.paradas + "&token=" + this.token;// url da API
        //String url = "https://rotasbrasil.com.br/api/v3?pontos=Curitiba,pr;88525-600;Florian%C3%B3polis,sc&veiculo=caminhao&eixos=6&token=be0fec9037e09b6f6b987b5991ddbf56";
        testeEncode(url);
        System.out.println("Requested URL: " + url);
        
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
    }
    
    public void testeEncode(String encode){
        String cidade = encode;
        String cidadeEncoded = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
        System.out.println(cidadeEncoded); // Florian%C3%B3polis
    }
    
}
