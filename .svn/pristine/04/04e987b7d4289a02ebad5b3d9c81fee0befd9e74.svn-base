package src.bh20.bh25.pesquisa;

import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controle {
        
    private String MSG;
    private String MSGSER = "";
           
    protected Socket cliente = null;
    
    protected DataOutputStream o = null;
    protected DataInputStream s = null;
    
    //------------- contrutor controle
    Controle() throws IOException{
    }
    
    //------------- recebe e escreve na tela a MSG do servidor
    String setInput() throws IOException{
        Scanner S = new Scanner(cliente.getInputStream());
        MSGSER = S.nextLine();
        return MSGSER;
    }
    //------------- estabelece a conexao
    void Conectar (String ipServidor , int porta) throws UnknownHostException, IOException {

        Socket Temp = new Socket (ipServidor, porta);
        cliente = Temp;
    }
    //------------- envia a MSG para o servidor
    void enviarMSG (String t) throws IOException{
        PrintStream saida = new PrintStream(this.cliente.getOutputStream());
        saida.println(t.trim());
    }
   //------------- funcoes do botao enviar
    class enviarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
               
            try {
                enviarMSG(MSG);
            } catch (IOException ex) {
                Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
    
    
    
