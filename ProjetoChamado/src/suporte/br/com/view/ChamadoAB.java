package suporte.br.com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import suporte.br.com.dao.CRUDChamado;
import suporte.br.com.dominio.Chamado;
import java.awt.Cursor;

public class ChamadoAB extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDepartamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChamadoAB frame = new ChamadoAB();
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
	public ChamadoAB() {
		setTitle("Sistema de suporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreencha = new JLabel("Preencha todos os campos  para efetuar um chamado.");
		lblPreencha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPreencha.setBounds(247, 11, 347, 14);
		contentPane.add(lblPreencha);
		
		JLabel lblNome = new JLabel("insira seu nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(247, 74, 101, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(247, 99, 220, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblChamado = new JLabel("Informe com qual departamento deseja falar:");
		lblChamado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChamado.setBounds(247, 143, 347, 14);
		contentPane.add(lblChamado);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(247, 179, 270, 20);
		contentPane.add(txtDepartamento);
		
		JLabel lblConte = new JLabel("Conte-nos mais sobre o seu problema:");
		lblConte.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConte.setBounds(247, 223, 226, 14);
		contentPane.add(lblConte);
		
		JTextArea txtDescricao = new JTextArea();
		txtDescricao.setBounds(247, 239, 347, 137);
		contentPane.add(txtDescricao);
		
		JLabel soliciChamado = new JLabel("Registrar chamado");
		soliciChamado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		soliciChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			CRUDChamado cc = new CRUDChamado();
			Chamado soliciChamado = new Chamado();
			
			if (txtNome.getText().trim().equals("") ||
				txtDepartamento.getText().trim().equals("") ||
				txtDescricao.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.","Erro 4000765x",JOptionPane.ERROR_MESSAGE);
				} else {
					soliciChamado.setSolicitacao(txtNome.getText());
					
					soliciChamado.setDepSolicitado(txtDepartamento.getText()); 
					 
					soliciChamado.setDescChamado(txtDescricao.getText()); 
					 
					 JOptionPane.showMessageDialog(null, cc.registrar(soliciChamado));
				}
			}
		});
		soliciChamado.setFont(new Font("Tahoma", Font.BOLD, 11));
		soliciChamado.setBounds(10, 182, 121, 14);
		contentPane.add(soliciChamado);
	}
}
