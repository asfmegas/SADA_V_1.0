/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Auxiliar.Erros;
import Auxiliar.ValidaCampos;
import DAO.CursoDAO;
import Objetos.Curso;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author asfmegas
 */
public class CursoGUI extends javax.swing.JFrame {
    private final DefaultTableModel tmCurso = new DefaultTableModel(null, new String[]{"ID","CURSO","CARGA"});
    private List<Curso> listaCurso;
    private ListSelectionModel lsmCurso;
    private Curso objCurso = new Curso();
    /**
     * Creates new form CursoGUI
     */
    public CursoGUI() {
        setTitle("CURSO - SADA V 1.0");
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        jtCurso.setDocument(new CustomDocument());
        jtCarga.setDocument(new CustomDocument());
        jtTabela.getTableHeader().setReorderingAllowed(false); 
        int x = 0;
        jtTabela.getColumnModel().getColumn(x++).setPreferredWidth(10);
        jtTabela.getColumnModel().getColumn(x++).setPreferredWidth(550);
        jtTabela.getColumnModel().getColumn(x++).setPreferredWidth(40);
        
        infor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtCurso = new javax.swing.JTextField();
        jtCarga = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtObservacao = new javax.swing.JTextArea();
        jbConsulta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbCadastro = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtTabela.setModel(tmCurso);
        jtTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmCurso = jtTabela.getSelectionModel();
        lsmCurso.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selecionarLinhaTabela(jtTabela);
                }
            }
        });
        jScrollPane1.setViewportView(jtTabela);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CURSO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CARGA HORÁRIA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("OBSERVAÇÃO:");

        jtCurso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtCurso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtCursoFocusLost(evt);
            }
        });
        jtCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtCursoActionPerformed(evt);
            }
        });

        jtCarga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtCarga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtCarga.setEnabled(false);
        jtCarga.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtCargaFocusLost(evt);
            }
        });

        jtObservacao.setColumns(20);
        jtObservacao.setRows(5);
        jtObservacao.setEnabled(false);
        jtObservacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtObservacaoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(jtObservacao);

        jbConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/SNOW E AQUA SHERLOCK2.png"))); // NOI18N
        jbConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 567, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addGap(566, 566, 566)))
                                .addComponent(jbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbConsulta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbNovo.setForeground(new java.awt.Color(0, 0, 204));
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo-sada.gif"))); // NOI18N
        jbNovo.setText("NOVO");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbCadastro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCadastro.setForeground(new java.awt.Color(0, 0, 204));
        jbCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar-sada.png"))); // NOI18N
        jbCadastro.setText("CADASTRAR");
        jbCadastro.setEnabled(false);
        jbCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroActionPerformed(evt);
            }
        });

        jbAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbAlterar.setForeground(new java.awt.Color(0, 0, 204));
        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar-sada.png"))); // NOI18N
        jbAlterar.setText("ALTERAR");
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(0, 0, 204));
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir-sada.png"))); // NOI18N
        jbExcluir.setText("EXCLUIR");
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbFechar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbFechar.setForeground(new java.awt.Color(0, 0, 204));
        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar-sada.png"))); // NOI18N
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExcluir)
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbAlterar, jbCadastro, jbExcluir, jbNovo});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbCadastro)
                        .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAlterar)
                        .addComponent(jbExcluir))
                    .addComponent(jbFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbAlterar, jbCadastro, jbExcluir, jbFechar, jbNovo});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        
        if(confirmarSalvarDados()){
            int resp = JOptionPane.showConfirmDialog(this, "Deseja excluir o curso?\n"
                + "Se o curso for excluido os movimento relacionados a ele\ntambém serão apagados.","Confirmação",JOptionPane.YES_NO_OPTION);
            if(resp == JOptionPane.YES_NO_OPTION){
                excluirCurso();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não há dados a serem excluidos.");
        }
        
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        Principal gui = new Principal();
        gui.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroActionPerformed
        if(confirmarSalvarDados()){
            salvarCurso();
            limparCampos(0);
        }else{
            JOptionPane.showMessageDialog(null, "Os campos CURSO e CARGA HORÁRIA precisam ser preenchidos.");
        }
    }//GEN-LAST:event_jbCadastroActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        ativarComponentes(1);
        limparCampos(0);
        //jbConsulta.setEnabled(false);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jtCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtCursoActionPerformed
        try {
            listarCursos();
        } catch (SQLException ex) {
            Erros.erroSql("Erro ao listar cursos\n"+ex.getMessage());
        }
    }//GEN-LAST:event_jtCursoActionPerformed

    private void jbConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultaActionPerformed
        try {
            listarCursos();
        } catch (SQLException ex) {
            Erros.erroSql("Erro ao listar cursos\n"+ex.getMessage());
        }
    }//GEN-LAST:event_jbConsultaActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        if(confirmarSalvarDados()){
            alterarCurso();
        }else{
            JOptionPane.showMessageDialog(null, "Não há dados a serem alterados.\nSelecione um curso.");
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jtCursoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtCursoFocusLost
        ValidaCampos vc = new ValidaCampos();
        if(vc.validar(100, jtCurso.getText()) == false){
            jtCurso.requestFocus();
        }
    }//GEN-LAST:event_jtCursoFocusLost

    private void jtObservacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtObservacaoFocusLost
        ValidaCampos vc = new ValidaCampos();
        if(vc.validar(250, jtObservacao.getText()) == false){
            jtObservacao.requestFocus();
        }
    }//GEN-LAST:event_jtObservacaoFocusLost

    private void jtCargaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtCargaFocusLost
        ValidaCampos vc = new ValidaCampos();
        
        if(!vc.validar(4, jtCarga.getText())){
            jtCarga.requestFocus();
        }else{
            if(vc.validarNumerosInteiros(jtCarga.getText()) == false){
                jtCarga.requestFocus();
                jtCarga.selectAll();
            }
        }
    }//GEN-LAST:event_jtCargaFocusLost

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
            java.util.logging.Logger.getLogger(CursoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CursoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CursoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CursoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CursoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCadastro;
    private javax.swing.JButton jbConsulta;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JTextField jtCarga;
    private javax.swing.JTextField jtCurso;
    private javax.swing.JTextArea jtObservacao;
    private javax.swing.JTable jtTabela;
    // End of variables declaration//GEN-END:variables
    //Classe para manter caixa alta no JTextField
    //Referência
    //http://www.guj.com.br/java/199701-jtextfield-com-caixa-altaresolvido
    public class CustomDocument extends PlainDocument {

        @Override
	public void insertString(int offset, String str, AttributeSet attr)
			throws BadLocationException {
		if (str == null)
			return;
		super.insertString(offset, str.toUpperCase(), attr); // Detalhe no str
	}
    }
    
    public void salvarCurso(){
        Curso curso = new Curso();
        curso.setCurso(jtCurso.getText());
        curso.setCarga(Integer.parseInt(jtCarga.getText()));
        curso.setObservacao(jtObservacao.getText());
        
        CursoDAO dao = new CursoDAO();
        dao.salvar(curso);
        try {
            listarCursos();
        } catch (SQLException ex) {
            Logger.getLogger(CursoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        limparCampos(1);
    }
    
    private void ativarComponentes(int v){
        if(v == 1)
            jtCurso.setText("");
        jtCurso.requestFocus();
        jtCarga.setEnabled(true);
        jtObservacao.setEnabled(true);
        jbAlterar.setEnabled(true);
        jbCadastro.setEnabled(true);
        jbExcluir.setEnabled(true);
    }
    
    private void limparCampos(int v){
        jtCurso.requestFocus();
        jtCarga.setText("");
        if(v == 1)
            jtCurso.setText("");
        jtObservacao.setText("");
    }
    
    private void listarCursos() throws SQLException{
        CursoDAO dao = new CursoDAO();
        listaCurso = dao.pesquisarString("%"+jtCurso.getText()+"%");
        mostrarPesquisa(listaCurso);
    }

    private void mostrarPesquisa(List<Curso> cursos) {
        while(tmCurso.getRowCount() > 0){
            tmCurso.removeRow(0);
        }
        
        if(cursos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Sua lista está vazia!");
        }else{
            String[] linhas = new String[]{null,null};
            for(int i=0; i < cursos.size();i++){
                tmCurso.addRow(linhas);
                tmCurso.setValueAt(cursos.get(i).getId(), i, 0);
                tmCurso.setValueAt(cursos.get(i).getCurso(), i, 1);
                tmCurso.setValueAt(cursos.get(i).getCarga(), i, 2);
            }
        }
    }
    
    private void selecionarLinhaTabela(JTable tabela){
        if(jtTabela.getSelectedRow() != -1){
            jtCurso.setText(""+listaCurso.get(tabela.getSelectedRow()).getCurso());
            jtCarga.setText(""+listaCurso.get(tabela.getSelectedRow()).getCarga());
            jtObservacao.setText(listaCurso.get(tabela.getSelectedRow()).getObservacao());
            ativarComponentes(0);
            Curso curso = new Curso();
            curso.setId(listaCurso.get(tabela.getSelectedRow()).getId());
            carregarDadosCurso(curso);
        }else{
            jtCurso.setText("");
        }
    }
    
    private void carregarDadosCurso(Curso curso){
         objCurso = curso;
    }
    
    private void alterarCurso(){
        CursoDAO dao = new CursoDAO();
        Curso curso = new Curso();
        curso.setId(objCurso.getId());
        curso.setCurso(jtCurso.getText());
        curso.setCarga(Integer.parseInt(jtCarga.getText()));
        curso.setObservacao(jtObservacao.getText());
        
        dao.alterar(curso);
        limparCampos(1);
        
        try {
            listarCursos();
        } catch (SQLException ex) {
            Erros.erroSql("Erro ao listar campos\n"+ex.getMessage());
        }
    }
    
    private void excluirCurso(){
        CursoDAO dao = new CursoDAO();
        dao.excluir(listaCurso.get(jtTabela.getSelectedRow()).getId());
        limparCampos(1);
        try {
            listarCursos();
        } catch (SQLException ex) {
            Logger.getLogger(CursoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void infor(){
        jbAlterar.setToolTipText("Alterar dados.");
        jbCadastro.setToolTipText("Cadastrar dados.");
        jbExcluir.setToolTipText("Excluir dados.");
        jbNovo.setToolTipText("Novo cadastro.");
    }
    
    private boolean confirmarSalvarDados(){
        if(!jtCurso.getText().equals("") && !jtCarga.getText().equals("")){
            return true;
        }else{
            return false;
        }
    }
    
}
