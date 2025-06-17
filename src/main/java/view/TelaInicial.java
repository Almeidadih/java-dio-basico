package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial  extends JFrame {

    public TelaInicial(){

        setTitle("Sistema de Cadastrode Produtos - inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,350);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Cores claras

        Color azulClaro = new Color(173,216,360);//LigthBlue

        Color verdeClaro = new Color(101, 198, 15);// LigthGreen
        Color amareloClaro = new Color(168, 168, 32);//LigthYellow

        // Painel principal com Layout de Grade (2 linhas , 1 coluna ) para a cor de fundo alterar

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1));// 2 linhas para alterar cores
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));// Padding

        //Painel Superior(Azul Claro)
        JPanel topPanel = new JPanel();
        topPanel.setBackground(azulClaro);
        topPanel.setLayout(new GridLayout());// Para centralizar o texto
        JLabel welcomeLabel = new JLabel("Bem vindo ao Sistema de Produtos!");
        welcomeLabel.setFont(new Font("Arial" , Font.BOLD,24));

        topPanel.add(welcomeLabel);
        mainPanel.add(topPanel);

        //Painel Inferior(Verde Claro com Botão Amarelo Claro)
        JPanel bottonPanel = new JPanel();
        bottonPanel.setBackground(verdeClaro);
        bottonPanel.setLayout(new GridBagLayout());// Para centralizar o botão

        JButton btnCadastro = new JButton("Ir para Cadastro de Produtos");
        btnCadastro.setFont(new Font("Arial" , Font.PLAIN,18));
        btnCadastro.setBackground(amareloClaro); // Fundo do Botão
        btnCadastro.setForeground(Color.DARK_GRAY);// Cor do texto do botão
        btnCadastro.setFocusPainted(false);// Remove a borda de foco
        btnCadastro.setBorder(BorderFactory.createLineBorder(Color.GRAY,1)); // Borda sutil
        btnCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));// Cursor de mão ao passar o mouse

        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Ao clicar, fecha a tela inicial e abre a tela de cadasxtro
                dispose();//Fecha a tela atual
                new TelaCadasatroProduto().setVisible(true);
            }
        });

        bottonPanel.add(btnCadastro);
        mainPanel.add(bottonPanel);

        add(mainPanel);

    }
}
