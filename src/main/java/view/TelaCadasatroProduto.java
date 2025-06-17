package view;

import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaCadasatroProduto  extends JFrame {

    private JTextField txtNome;
    private JTextField txtDescricao;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JTextArea taProdutosCadastrados;

    // Simulação de "banco de dados" em memoria

    private List<Produto> listarProdutos;

    public TelaCadasatroProduto() {
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setLocationRelativeTo(null);// Centraliza a janela na tela

        listarProdutos = new ArrayList<>();

        //Cor de fundo da tela de cadastro(Verde Claro)

        Color verdeClaro = new Color(144,238,144);//LigthGreen

        getContentPane().setBackground(verdeClaro);
        setLayout(new BorderLayout(10,10)); // Layout principal com espaçamento

        // -----Painel de Formulário (Norte)
        JPanel formPanel = new JPanel(new GridLayout(4,2,10,10)); // 4 linhas , 2 colunas , com espaçamento
        formPanel.setBackground(verdeClaro);// Mesma cor de fundo

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(20);
        JLabel lblDescricao = new JLabel("Descricao");
        txtDescricao = new JTextField(20);
        JLabel lblPreco = new JLabel("Preco");
        txtPreco = new JTextField(20);
        JLabel lblQuantidade = new JLabel("Quantidade");
        txtQuantidade = new JTextField(20);
    }
}
