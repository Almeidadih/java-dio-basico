package view;

import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        // -----Painel de Formulário (Norte) ------
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

        formPanel.add(lblNome);
        formPanel.add(txtNome);
        formPanel.add(lblDescricao);
        formPanel.add(txtDescricao);
        formPanel.add(lblPreco);
        formPanel.add(txtPreco);
        formPanel.add(lblQuantidade);
        formPanel.add(txtQuantidade);

        //Adiciona um padding ao painel do formulário
        formPanel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        add(formPanel,BorderLayout.NORTH);

        //---------- Painel de Botões (Centro) ---------

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,5)); // Centraliza botões
        buttonPanel.setBackground(verdeClaro); // Mesma cor do fundo

        JButton btnCadastrar = new JButton("Cadastrar Produto ");
        btnCadastrar.setBackground(new Color(255,255,204));// Amarelo bem claro para o botão
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        JButton btnLimpar = new JButton("Limpar Campos");
        btnLimpar.setBackground(new Color(255,255,204));// Amarelo bem claro para o botão
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        JButton btnVoltar = new JButton("Voltar para inicio");
        btnVoltar.setBackground(new Color(255,255,204)); // Amarelo bem claro para o botão
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();// Fecha  a tela atual
                new TelaInicial().setVisible(true);// Volta para a tela inicial
            }
        });

        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnLimpar);
        buttonPanel.add(btnVoltar);

        add(buttonPanel,BorderLayout.CENTER);


        //-----Painel de Produtos Cadastrados (Sul)------
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(verdeClaro);
        listPanel.setBorder(BorderFactory.createTitledBorder("Produtos Cadastrados"));// Titulo com borda

        taProdutosCadastrados = new JTextArea(10,40);
        taProdutosCadastrados.setEditable(false);
        taProdutosCadastrados.setBackground(new Color(240,255,240)); // Um verde pastel muito claro para a área de texto
        JScrollPane scrollPane = new JScrollPane(taProdutosCadastrados);// Adiciona scroll se tiver muitos produtos
        listPanel.add(scrollPane,BorderLayout.CENTER);

        listPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));// Padding
        add(listPanel, BorderLayout.SOUTH);
    }

    private void cadastrarProduto(){
        try {
            String nome = txtNome.getText();
            String descricao = txtDescricao.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int quantidade = Integer.parseInt(txtQuantidade.getText());

            if (nome.isEmpty() || descricao.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome e Descrição não podem está vazios!", "Erro de Validação ", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Produto produto = new Produto(nome, descricao, preco, quantidade);
            listarProdutos.add(produto);
            atualizarListaProdutos();
            limparCampos();
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        }catch (NumberFormatException e ){
            JOptionPane.showMessageDialog(this,"Preço e Quantidade devem ser números válidos." , "Erro de Entrada" , JOptionPane.ERROR_MESSAGE);

        }catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Ocorreu um erro:" + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtNome.setText(" ");
        txtDescricao.setText(" ");
        txtPreco.setText(" ");
        txtQuantidade.setText(" ");
    }

    private void atualizarListaProdutos() {
        taProdutosCadastrados.setText("");// Limpa o texto atual
        for (Produto p : listarProdutos) {
            taProdutosCadastrados.append("Nome:" + p.getNome() + "Preço: R$" + String.format("%.2f",p.getPreco()) + "\n");
        }
    }
}
