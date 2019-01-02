package view;

import dao.AbrigoDAO;
import database.Utilitarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Abrigo;

/**
 *
 * @author Alunos  Talita vitoria, Felipe Tobias, Iara Oliveira e Vinicius donschen
 */
public final class JFrameListaAbrigo extends javax.swing.JFrame {

   
    public JFrameListaAbrigo() {
        initComponents();
        popularListaAbrigo();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAbrigo = new javax.swing.JPanel();
        jButtonEditarAbrigo = new javax.swing.JButton();
        jScrollPaneAbrigo = new javax.swing.JScrollPane();
        jTableAbrigo = new javax.swing.JTable();
        jTextFieldPesquisaAbrigo = new javax.swing.JTextField();
        jComboBoxPesquisaAbrigo = new javax.swing.JComboBox();
        jLabelPesquisaAbrigo = new javax.swing.JLabel();
        jButtonPesquisaAbrigo = new javax.swing.JButton();
        jButtonAdicionarAbrigo = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabelListaAbrigos = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        btnHome = new javax.swing.JPanel();
        jLabelBtnHome = new javax.swing.JLabel();
        btnListaOcorrencia = new javax.swing.JPanel();
        jLabelBtnListaOcorrencia = new javax.swing.JLabel();
        btnListaSalvamento = new javax.swing.JPanel();
        jLabelBtnListaSalvamento = new javax.swing.JLabel();
        btnListaAbrigo = new javax.swing.JPanel();
        jLabelBtnListaAbrigo = new javax.swing.JLabel();
        btnListaVeiculo = new javax.swing.JPanel();
        jLabelBtnListaVeiculo = new javax.swing.JLabel();
        btnListaDadosGerais = new javax.swing.JPanel();
        jLabelBtnDadosGerais = new javax.swing.JLabel();
        jPanelHome = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Abrigos");
        setBounds(new java.awt.Rectangle(700, 500, 0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanelAbrigo.setMaximumSize(new java.awt.Dimension(620, 600));
        jPanelAbrigo.setMinimumSize(new java.awt.Dimension(620, 600));
        jPanelAbrigo.setPreferredSize(new java.awt.Dimension(620, 600));

        jButtonEditarAbrigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit-515151-64px.png"))); // NOI18N
        jButtonEditarAbrigo.setToolTipText("Editar abrigo já existente");
        jButtonEditarAbrigo.setBorderPainted(false);
        jButtonEditarAbrigo.setContentAreaFilled(false);
        jButtonEditarAbrigo.setMaximumSize(new java.awt.Dimension(40, 40));
        jButtonEditarAbrigo.setMinimumSize(new java.awt.Dimension(40, 40));
        jButtonEditarAbrigo.setPreferredSize(new java.awt.Dimension(40, 40));
        jButtonEditarAbrigo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit-a9cb73-64px.png"))); // NOI18N
        jButtonEditarAbrigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarAbrigoActionPerformed(evt);
            }
        });

        jTableAbrigo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Bairro", "Responsável", "Lotação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAbrigo.setGridColor(new java.awt.Color(81, 81, 81));
        jTableAbrigo.setIntercellSpacing(new java.awt.Dimension(1, 2));
        jTableAbrigo.setPreferredSize(new java.awt.Dimension(500, 400));
        jTableAbrigo.setSelectionBackground(new java.awt.Color(169, 203, 115));
        jTableAbrigo.setShowVerticalLines(false);
        jTableAbrigo.getTableHeader().setResizingAllowed(false);
        jTableAbrigo.getTableHeader().setReorderingAllowed(false);
        jScrollPaneAbrigo.setViewportView(jTableAbrigo);
        jTableAbrigo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableAbrigo.getColumnModel().getColumnCount() > 0) {
            jTableAbrigo.getColumnModel().getColumn(0).setResizable(false);
            jTableAbrigo.getColumnModel().getColumn(1).setResizable(false);
            jTableAbrigo.getColumnModel().getColumn(3).setResizable(false);
            jTableAbrigo.getColumnModel().getColumn(4).setResizable(false);
        }

        jTextFieldPesquisaAbrigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisaAbrigoActionPerformed(evt);
            }
        });

        jComboBoxPesquisaAbrigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Nome", "Bairro", "Responsável" }));
        jComboBoxPesquisaAbrigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPesquisaAbrigoActionPerformed(evt);
            }
        });

        jLabelPesquisaAbrigo.setText("Pesquisar por:");

        jButtonPesquisaAbrigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search-515151-32px.png"))); // NOI18N
        jButtonPesquisaAbrigo.setToolTipText("Pesquisar Abrigo");
        jButtonPesquisaAbrigo.setBorderPainted(false);
        jButtonPesquisaAbrigo.setContentAreaFilled(false);
        jButtonPesquisaAbrigo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search-a9cb73-32px.png"))); // NOI18N
        jButtonPesquisaAbrigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaAbrigoActionPerformed(evt);
            }
        });

        jButtonAdicionarAbrigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-515151-64px.png"))); // NOI18N
        jButtonAdicionarAbrigo.setToolTipText("Adicionar novo abrigo");
        jButtonAdicionarAbrigo.setBorderPainted(false);
        jButtonAdicionarAbrigo.setContentAreaFilled(false);
        jButtonAdicionarAbrigo.setMaximumSize(new java.awt.Dimension(40, 40));
        jButtonAdicionarAbrigo.setMinimumSize(new java.awt.Dimension(40, 40));
        jButtonAdicionarAbrigo.setPreferredSize(new java.awt.Dimension(40, 40));
        jButtonAdicionarAbrigo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-a9cb73-64px.png"))); // NOI18N
        jButtonAdicionarAbrigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarAbrigoActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(81, 81, 81));
        jButtonSair.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cancel-515151-64px.png"))); // NOI18N
        jButtonSair.setToolTipText("Sair");
        jButtonSair.setBorderPainted(false);
        jButtonSair.setContentAreaFilled(false);
        jButtonSair.setPreferredSize(new java.awt.Dimension(40, 40));
        jButtonSair.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/cancel-a9cb73-64px.png"))); // NOI18N
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelListaAbrigos.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabelListaAbrigos.setForeground(new java.awt.Color(81, 81, 81));
        jLabelListaAbrigos.setText("LISTA de ABRIGOS");

        javax.swing.GroupLayout jPanelAbrigoLayout = new javax.swing.GroupLayout(jPanelAbrigo);
        jPanelAbrigo.setLayout(jPanelAbrigoLayout);
        jPanelAbrigoLayout.setHorizontalGroup(
            jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAbrigoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAbrigoLayout.createSequentialGroup()
                        .addComponent(jLabelListaAbrigos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanelAbrigoLayout.createSequentialGroup()
                        .addGroup(jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAbrigoLayout.createSequentialGroup()
                                .addGroup(jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAbrigoLayout.createSequentialGroup()
                                        .addComponent(jLabelPesquisaAbrigo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxPesquisaAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldPesquisaAbrigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisaAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelAbrigoLayout.createSequentialGroup()
                                .addComponent(jScrollPaneAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonEditarAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionarAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 45, Short.MAX_VALUE))))
        );
        jPanelAbrigoLayout.setVerticalGroup(
            jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAbrigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelListaAbrigos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPesquisaAbrigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAbrigoLayout.createSequentialGroup()
                        .addGroup(jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPesquisaAbrigo)
                            .addComponent(jComboBoxPesquisaAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisaAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelAbrigoLayout.createSequentialGroup()
                        .addComponent(jButtonAdicionarAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditarAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        jPanelMenu.setBackground(new java.awt.Color(81, 81, 81));
        jPanelMenu.setForeground(new java.awt.Color(169, 203, 115));
        jPanelMenu.setPreferredSize(new java.awt.Dimension(180, 600));

        btnHome.setBackground(new java.awt.Color(81, 81, 81));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMousePressed(evt);
            }
        });

        jLabelBtnHome.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelBtnHome.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBtnHome.setText("Principal");

        javax.swing.GroupLayout btnHomeLayout = new javax.swing.GroupLayout(btnHome);
        btnHome.setLayout(btnHomeLayout);
        btnHomeLayout.setHorizontalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        btnHomeLayout.setVerticalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnListaOcorrencia.setBackground(new java.awt.Color(81, 81, 81));
        btnListaOcorrencia.setPreferredSize(new java.awt.Dimension(180, 50));
        btnListaOcorrencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnListaOcorrenciaMousePressed(evt);
            }
        });

        jLabelBtnListaOcorrencia.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelBtnListaOcorrencia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBtnListaOcorrencia.setText("Ocorrências");

        javax.swing.GroupLayout btnListaOcorrenciaLayout = new javax.swing.GroupLayout(btnListaOcorrencia);
        btnListaOcorrencia.setLayout(btnListaOcorrenciaLayout);
        btnListaOcorrenciaLayout.setHorizontalGroup(
            btnListaOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListaOcorrenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnListaOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        btnListaOcorrenciaLayout.setVerticalGroup(
            btnListaOcorrenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnListaOcorrenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnListaOcorrencia, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnListaSalvamento.setBackground(new java.awt.Color(81, 81, 81));
        btnListaSalvamento.setPreferredSize(new java.awt.Dimension(180, 50));
        btnListaSalvamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnListaSalvamentoMousePressed(evt);
            }
        });

        jLabelBtnListaSalvamento.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelBtnListaSalvamento.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBtnListaSalvamento.setText("Salvamentos");

        javax.swing.GroupLayout btnListaSalvamentoLayout = new javax.swing.GroupLayout(btnListaSalvamento);
        btnListaSalvamento.setLayout(btnListaSalvamentoLayout);
        btnListaSalvamentoLayout.setHorizontalGroup(
            btnListaSalvamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListaSalvamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnListaSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        btnListaSalvamentoLayout.setVerticalGroup(
            btnListaSalvamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnListaSalvamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnListaSalvamento, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnListaAbrigo.setBackground(new java.awt.Color(97, 97, 97));
        btnListaAbrigo.setPreferredSize(new java.awt.Dimension(180, 50));

        jLabelBtnListaAbrigo.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelBtnListaAbrigo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBtnListaAbrigo.setText("Abrigos");

        javax.swing.GroupLayout btnListaAbrigoLayout = new javax.swing.GroupLayout(btnListaAbrigo);
        btnListaAbrigo.setLayout(btnListaAbrigoLayout);
        btnListaAbrigoLayout.setHorizontalGroup(
            btnListaAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListaAbrigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnListaAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        btnListaAbrigoLayout.setVerticalGroup(
            btnListaAbrigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnListaAbrigoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnListaAbrigo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnListaVeiculo.setBackground(new java.awt.Color(81, 81, 81));
        btnListaVeiculo.setPreferredSize(new java.awt.Dimension(180, 50));
        btnListaVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnListaVeiculoMousePressed(evt);
            }
        });

        jLabelBtnListaVeiculo.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelBtnListaVeiculo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBtnListaVeiculo.setText("Veiculos");

        javax.swing.GroupLayout btnListaVeiculoLayout = new javax.swing.GroupLayout(btnListaVeiculo);
        btnListaVeiculo.setLayout(btnListaVeiculoLayout);
        btnListaVeiculoLayout.setHorizontalGroup(
            btnListaVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListaVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnListaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        btnListaVeiculoLayout.setVerticalGroup(
            btnListaVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnListaVeiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnListaVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnListaDadosGerais.setBackground(new java.awt.Color(81, 81, 81));
        btnListaDadosGerais.setPreferredSize(new java.awt.Dimension(180, 50));
        btnListaDadosGerais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnListaDadosGeraisMousePressed(evt);
            }
        });

        jLabelBtnDadosGerais.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabelBtnDadosGerais.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBtnDadosGerais.setText("Dados Gerais");

        javax.swing.GroupLayout btnListaDadosGeraisLayout = new javax.swing.GroupLayout(btnListaDadosGerais);
        btnListaDadosGerais.setLayout(btnListaDadosGeraisLayout);
        btnListaDadosGeraisLayout.setHorizontalGroup(
            btnListaDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnListaDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnDadosGerais)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        btnListaDadosGeraisLayout.setVerticalGroup(
            btnListaDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnListaDadosGeraisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBtnDadosGerais, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelHome.setForeground(new java.awt.Color(255, 255, 255));
        jPanelHome.setPreferredSize(new java.awt.Dimension(620, 600));
        jPanelHome.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnListaOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListaSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListaAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListaDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListaOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListaSalvamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListaAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListaDadosGerais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelHome, 588, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelAbrigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAbrigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanelAbrigo.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        popularListaAbrigo();
    }//GEN-LAST:event_formWindowActivated

    private void jButtonEditarAbrigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarAbrigoActionPerformed
        if (jTableAbrigo.getSelectedRow() > -1) {
            
            int id = Integer.parseInt(jTableAbrigo.getValueAt(jTableAbrigo.getSelectedRow(), 0).toString());
            Abrigo abrigo = new AbrigoDAO().buscarAbrigoPorId(id);
            new JFrameCadastroAbrigo(abrigo).setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para editar");
        }      
    }//GEN-LAST:event_jButtonEditarAbrigoActionPerformed

    private void jButtonAdicionarAbrigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarAbrigoActionPerformed
        new JFrameCadastroAbrigo().setVisible(true);
    }//GEN-LAST:event_jButtonAdicionarAbrigoActionPerformed

    private void jButtonPesquisaAbrigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaAbrigoActionPerformed
        String coluna = jComboBoxPesquisaAbrigo.getSelectedItem().toString();
        String valorPesquisar = jTextFieldPesquisaAbrigo.getText();
        popularListaAbrigoPorPesquisa(coluna, valorPesquisar);
    }//GEN-LAST:event_jButtonPesquisaAbrigoActionPerformed

    private void jComboBoxPesquisaAbrigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPesquisaAbrigoActionPerformed
        //        String coluna = "";

    }//GEN-LAST:event_jComboBoxPesquisaAbrigoActionPerformed

    private void jTextFieldPesquisaAbrigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaAbrigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisaAbrigoActionPerformed

    private void btnListaOcorrenciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaOcorrenciaMousePressed
        new JFrameListaOcorrencia().setVisible(true);
        dispose();

    }//GEN-LAST:event_btnListaOcorrenciaMousePressed

    private void btnListaSalvamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaSalvamentoMousePressed
        new JFrameListaSalvamento().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListaSalvamentoMousePressed

    private void btnListaVeiculoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaVeiculoMousePressed
        new JFrameListaVeiculo().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListaVeiculoMousePressed

    private void btnListaDadosGeraisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaDadosGeraisMousePressed
        new JFrameDadosGerais().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListaDadosGeraisMousePressed

    private void btnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMousePressed
        new JFrameTelaInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeMousePressed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameListaAbrigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameListaAbrigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameListaAbrigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameListaAbrigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameListaAbrigo().setVisible(true);
            }
        });
    }
    
    public void popularListaAbrigoPorPesquisa(String coluna, String valor) {
        DefaultTableModel modelo = (DefaultTableModel) jTableAbrigo.getModel();
        ArrayList<Abrigo> abrigos = new AbrigoDAO().pesquisarAbrigo(coluna, valor);
        modelo.setRowCount(0);
        for (Abrigo a : abrigos) {
            modelo.addRow(new Object[]{
                a.getIdAbrigo(),
                a.getNomeAbrigo(),
                a.getLocalAbrigo(),
                a.getResponsavelAbrigo(),
                a.getLotacaoAbrigo()
            });
        }
    }
    
    public void popularListaAbrigo() {
        DefaultTableModel modelo = (DefaultTableModel) jTableAbrigo.getModel();
        ArrayList<Abrigo> abrigos = new AbrigoDAO().retornarListaAbrigo();
        modelo.setRowCount(0);
        for(Abrigo abrigo : abrigos){
            modelo.addRow(new Object[]{
                abrigo.getIdAbrigo(),
                abrigo.getNomeAbrigo(), 
                abrigo.getLocalAbrigo(),
                abrigo.getResponsavelAbrigo(), 
                abrigo.getLotacaoAbrigo()
            });
        }
    }    
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnHome;
    private javax.swing.JPanel btnListaAbrigo;
    private javax.swing.JPanel btnListaDadosGerais;
    private javax.swing.JPanel btnListaOcorrencia;
    private javax.swing.JPanel btnListaSalvamento;
    private javax.swing.JPanel btnListaVeiculo;
    private javax.swing.JButton jButtonAdicionarAbrigo;
    private javax.swing.JButton jButtonEditarAbrigo;
    private javax.swing.JButton jButtonPesquisaAbrigo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxPesquisaAbrigo;
    private javax.swing.JLabel jLabelBtnDadosGerais;
    private javax.swing.JLabel jLabelBtnHome;
    private javax.swing.JLabel jLabelBtnListaAbrigo;
    private javax.swing.JLabel jLabelBtnListaOcorrencia;
    private javax.swing.JLabel jLabelBtnListaSalvamento;
    private javax.swing.JLabel jLabelBtnListaVeiculo;
    private javax.swing.JLabel jLabelListaAbrigos;
    private javax.swing.JLabel jLabelPesquisaAbrigo;
    private javax.swing.JPanel jPanelAbrigo;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPaneAbrigo;
    private javax.swing.JTable jTableAbrigo;
    private javax.swing.JTextField jTextFieldPesquisaAbrigo;
    // End of variables declaration//GEN-END:variables
}
