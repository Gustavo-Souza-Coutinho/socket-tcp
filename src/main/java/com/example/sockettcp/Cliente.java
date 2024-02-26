package com.example.sockettcp;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        double real = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor R$:"));

        try( Socket conexao = new Socket("127.0.0.1", 40000)){

            ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

            saida.writeObject(real);
            double dolar = (double)entrada.readObject();

            JOptionPane.showMessageDialog(null,"quantidade de dolares: " + dolar);


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
