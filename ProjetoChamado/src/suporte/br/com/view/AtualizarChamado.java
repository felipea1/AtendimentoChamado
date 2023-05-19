package suporte.br.com.view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import suporte.br.com.dao.CRUDChamado;
import suporte.br.com.dominio.Chamado;

public class AtualizarChamado extends JFrame{

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDataResolucao;
	private JTextField txtResponsavel;
	Chamado cc = new Chamado();
	CRUDChamado cr = new CRUDChamado();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarChamado frame = new AtualizarChamado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public AtualizarChamado() {
		setTitle("Sistema de suporte - atendente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID do chamado:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblID.setBounds(180, 11, 112, 14);
		contentPane.add(lblID);
		
		JLabel lblStatus = new JLabel("Status do chamado:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(420, 12, 148, 14);
		contentPane.add(lblStatus);
		
		JComboBox txtStatus = new JComboBox();
		txtStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtStatus.setModel(new DefaultComboBoxModel(new String[] {"Pendente", "aberto", "fechado", "Resolvido"}));
		txtStatus.setBounds(420, 44, 112, 22);
		contentPane.add(txtStatus);
		
		txtId = new JTextField();
		txtId.setBounds(180, 45, 170, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblData = new JLabel("Data de resolução do chamado:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(180, 93, 225, 14);
		contentPane.add(lblData);
		
		txtDataResolucao = new JTextField();
		txtDataResolucao.setBounds(180, 130, 170, 20);
		contentPane.add(txtDataResolucao);
		txtDataResolucao.setColumns(10);
		
		JLabel lblResponsavel = new JLabel("Responsável do chamado:");
		lblResponsavel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResponsavel.setBounds(420, 93, 189, 14);
		contentPane.add(lblResponsavel);
		
		txtResponsavel = new JTextField();
		txtResponsavel.setBounds(420, 130, 170, 20);
		contentPane.add(txtResponsavel);
		txtResponsavel.setColumns(10);
		
		JLabel lblObservações = new JLabel("Observações:");
		lblObservações.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObservações.setBounds(344, 161, 112, 14);
		contentPane.add(lblObservações);
		
		JTextArea txtObservacoes = new JTextArea();
		txtObservacoes.setBounds(180, 183, 410, 191);
		contentPane.add(txtObservacoes);
		
		JLabel lblChamado = new JLabel("Atualizar chamados");
		lblChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtResponsavel.getText().trim().equals("") || txtStatus.getSelectedItem().equals("") || 
						   txtId.getText().trim().equals("") || txtDataResolucao.getText().trim().equals("")) {
								 JOptionPane.showMessageDialog(null, "Os campos Responsável Chamado, Id do Chamado, Status do Chamado e Data de Resolução devem ser preenchidos", "Erro 4000765x" , JOptionPane.ERROR_MESSAGE); 
								} 
								else { 
								
								cc.setDataResolucao(String.valueOf(txtDataResolucao.getText()));
								cc.setStatusChamado(txtStatus.getSelectedItem()); 
								cc.setAtendente(txtResponsavel.getText()); 
								cc.setObservacoes(txtObservacoes.getText()); 
								cc.setIdChamado(Long.parseLong(txtId.getText())); 
								cr.atualizar(cc);
								JOptionPane.showMessageDialog(null, "Chamada atualizada!");
								} 		
			}
		});
		lblChamado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblChamado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChamado.setBounds(10, 130, 148, 14);
		contentPane.add(lblChamado);
		
		JLabel lblExcluirCh = new JLabel("Excluir chamado");
		lblExcluirCh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtId.equals(null)) { 
					JOptionPane.showMessageDialog(null,"Selecione o chamado a ser excluído.","Erro 4000770x",JOptionPane.ERROR_MESSAGE); 
					} 
					else { 
					if(JOptionPane.showConfirmDialog(null, "Você tem certeza desta ação? \nEstá ação é permanente "+ "e não pode ser desfeita", "ATENÇÃO", JOptionPane.YES_NO_OPTION, 
							 JOptionPane.QUESTION_MESSAGE) == 0) { 
							Chamado ch = new Chamado(); 
							ch.setIdChamado(Long.parseLong(txtId.getText())); 
							JOptionPane.showMessageDialog(null, cr.apagar(cc));
					}
				}
			}
			
		});
		lblExcluirCh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExcluirCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExcluirCh.setBounds(10, 187, 148, 14);
		contentPane.add(lblExcluirCh);
	}}
