package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.SinglePixelPackedSampleModel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import Util.Util;
import dao.DaoCliente;
import dao.DaoCliente;
import model.Cliente;

public class FrameTela {
	
	private JTextField textPlaca;
	private JLabel labelTitulo;
	private JLabel labelPlaca;
	private JTextField textModelo;
	private JLabel labelModelo;
	private JButton buttonEntrar;
	private JTable tabelaCadastro;
	private DefaultTableColumnModel tabelaCadastroModel;
	private JScrollPane scrollTabela;
	private JLabel labelTitle;
	private JTextField textPlacaBusca;
	private JLabel labelPlacaBusca;
	private JButton buttonBuscar;
	private JTextField textModeloBuscar;
	private JLabel labelModeloBuscar;
	private JTextField textDataEntrada;
	private JLabel labelDataEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textDataSaida;
	private JLabel labelDataSaida;
	private JTextField textHoraSaida;
	private JLabel labelHoraSaida;
	private JTextField textTempo;
	private JLabel labelTempo;
	private JTextField textValor;
	private JLabel labelValor;
	private JButton buttonSair;
	private JTable tabelaClientes;
	private DefaultTableModel tabelaClientesModelo;
	private JScrollPane scrollTable;
	
		public void criarTela() {
			
			Color Vermelhinho = new Color(255, 106, 106);
			Color Verdinho = new Color(	92, 219, 77);
			Color Cinzinha = new Color(	105, 105, 105);
			Font titulo = new Font("Corbel", Font.BOLD, 25);
			Font text = new Font("Corbel Light", Font.BOLD, 17);
			Font button = new Font("Corbel Light", Font.BOLD, 20);
			Font valor = new Font("Corbel Light", Font.BOLD, 25);
			
			JFrame tela = new JFrame();
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			tela.setTitle("Cadastro de Clientes");
			tela.setSize(863, 630);
			tela.setLayout(null);
			tela.setResizable(false);
			tela.setLocationRelativeTo(null);
			
			labelTitulo = new JLabel("ENTRADA");
			labelTitulo.setFont(titulo);
			labelTitulo.setForeground(Color.black);
			labelTitulo.setBounds(30, 10, 130, 30);
			
			labelPlaca = new JLabel("Placa:");
			labelPlaca.setBounds(30, 50, 140, 30);
			labelPlaca.setFont(text);
			textPlaca = new JTextField();
			textPlaca.setBounds(30, 80, 320, 30);
			textPlaca.setFont(text);
			
			labelModelo = new JLabel("Modelo:");
			labelModelo.setBounds(360, 50, 140, 30);
			labelModelo.setFont(text);
			textModelo = new JTextField();
			textModelo.setBounds(360, 80, 320, 30);
			textModelo.setFont(text);
			
			buttonEntrar = new JButton("Entrar");
			buttonEntrar.setBackground(Verdinho);
			buttonEntrar.setForeground(Color.WHITE);
			buttonEntrar.setBounds(690, 80, 130, 34);
			buttonEntrar.setFont(button);
			
			criarTabela();
			
			labelTitle = new JLabel("Saída");
			labelTitle.setFont(titulo);
			labelTitle.setForeground(Color.black);
			labelTitle.setBounds(30, 300, 130, 30);
			
			labelPlacaBusca = new JLabel("Placa:");
			labelPlacaBusca.setBounds(30, 335, 140, 30);
			labelPlacaBusca.setFont(text);
			textPlacaBusca = new JTextField();
			textPlacaBusca.setBounds(30, 365, 200, 40);
			textPlacaBusca.setFont(text);
			
			buttonBuscar = new JButton("Buscar");
			buttonBuscar.setBackground(Cinzinha);
			buttonBuscar.setForeground(Color.WHITE);
			buttonBuscar.setBounds(240, 365, 130, 40);
			buttonBuscar.setFont(button);
			
			labelModeloBuscar = new JLabel("Modelo:");
			labelModeloBuscar.setBounds(30, 430, 140, 30);
			labelModeloBuscar.setFont(text);
			textModeloBuscar = new JTextField();
			textModeloBuscar.setBounds(30, 450, 130, 40);
			textModeloBuscar.setFont(text);
			
			labelDataEntrada = new JLabel("Data Entrada");
			labelDataEntrada.setBounds(170, 430, 140, 30);
			labelDataEntrada.setFont(text);
			textDataEntrada = new JTextField();
			textDataEntrada.setBounds(170, 450, 130, 40);
			textDataEntrada.setFont(text);
			
			labelHoraEntrada = new JLabel("Hora Entrada");
			labelHoraEntrada.setBounds(310, 430, 140, 30);
			labelHoraEntrada.setFont(text);
			textHoraEntrada = new JTextField();
			textHoraEntrada.setBounds(310, 450, 130, 40);
			textHoraEntrada.setFont(text);
			
			labelDataSaida = new JLabel("Data Saída");
			labelDataSaida.setBounds(450, 430, 140, 30);
			labelDataSaida.setFont(text);
			textDataSaida = new JTextField();
			textDataSaida.setBounds(450, 450, 130, 40);
			textDataSaida.setFont(text);
			
			labelHoraSaida = new JLabel("Hora Saída");
			labelHoraSaida.setBounds(590, 430, 140, 30);
			labelHoraSaida.setFont(text);
			textHoraSaida = new JTextField();
			textHoraSaida.setBounds(590, 450, 130, 40);
			textHoraSaida.setFont(text);
			
			labelTempo = new JLabel("Tempo");
			labelTempo.setBounds(730, 430, 140, 30);
			labelTempo.setFont(text);
			textTempo = new JTextField();
			textTempo.setBounds(730, 450, 90, 40);
			textTempo.setFont(text);
			
			labelValor = new JLabel("Valor total");
			labelValor.setBounds(410, 515, 140, 30);
			labelValor.setFont(text);
			textValor = new JTextField();
			textValor.setBounds(500, 510, 170, 40);
			textValor.setFont(valor);
			
			buttonSair = new JButton("Pagar");
			buttonSair.setBackground(Vermelhinho);
			buttonSair.setForeground(Color.WHITE);
			buttonSair.setBounds(690, 510, 130, 40);
			buttonSair.setFont(button);
			
			
			tela.getContentPane().add(labelTitulo);
			tela.getContentPane().add(labelPlaca);
			tela.getContentPane().add(textPlaca);
			tela.getContentPane().add(labelModelo);
			tela.getContentPane().add(textModelo);
			tela.getContentPane().add(buttonEntrar);
			tela.getContentPane().add(scrollTable);
			tela.getContentPane().add(labelTitle);
			tela.getContentPane().add(labelPlacaBusca);
			tela.getContentPane().add(textPlacaBusca);
			tela.getContentPane().add(buttonBuscar);
			tela.getContentPane().add(labelModeloBuscar);
			tela.getContentPane().add(textModeloBuscar);
			tela.getContentPane().add(labelDataEntrada);
			tela.getContentPane().add(textDataEntrada);
			tela.getContentPane().add(labelHoraEntrada);
			tela.getContentPane().add(textHoraEntrada);
			tela.getContentPane().add(labelDataSaida);
			tela.getContentPane().add(textDataSaida);
			tela.getContentPane().add(labelHoraSaida);
			tela.getContentPane().add(textHoraSaida);
			tela.getContentPane().add(labelTempo);
			tela.getContentPane().add(textTempo);
			tela.getContentPane().add(labelValor);
			tela.getContentPane().add(textValor);
			tela.getContentPane().add(buttonSair);
			
			tela.setVisible(true);
			
			buttonEntrar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (validarFormulario()) {
						
						Cliente cliente = new Cliente();
						cliente.setCodigo(Util.gerarCodigo());
						cliente.setPlaca(textPlaca.getText().toUpperCase());
						cliente.setModelo(textModelo.getText().toUpperCase());
						cliente.setDataEntrada(LocalDate.now());
						cliente.setHoraEntrada(LocalTime.now());
						
						DaoCliente dao = new DaoCliente(cliente);
						dao.salvar();
						
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!!!");
						
						limparFormulario();
						
						  String[] linha = {cliente.getCodigo(), cliente.getPlaca(), cliente.getModelo(), cliente.getDataEntrada().toString()};
						  tabelaClientesModelo.addRow(linha);
						    
					} else {
						JOptionPane.showMessageDialog(
								null, 
								"Você deve preencher todos os campos!", 
								"ATENÇÃO", 
								JOptionPane.WARNING_MESSAGE);
						
						limparFormulario();
						criarTela();
					}
					
					
					
				}

				
			});
			buttonBuscar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//System.out.print(textPlacaBusca.getText());
					
					DaoCliente Daocliente = new DaoCliente();
				    ArrayList<Cliente> clientes = Daocliente.listarClientes();
				    
				   for(Cliente cliente : clientes) {
					   if(cliente.getPlaca().equals(textPlacaBusca.getText())) {
						   DecimalFormat decimal2 = new DecimalFormat("#.##");
						   
						   textModeloBuscar.setText(cliente.getModelo());
						   textDataEntrada.setText(cliente.getDataEntrada().toString());
						   textHoraEntrada.setText(cliente.getHoraEntrada().toString());
						   textDataSaida.setText(LocalDate.now().toString());
						   DateTimeFormatter formatarHora = DateTimeFormatter.ofPattern("HH:mm");
						   textHoraSaida.setText(formatarHora.format(LocalTime.now()));
						   double horaEntrada = cliente.getHoraEntrada().toSecondOfDay();
						   double horaSaída = LocalTime.now().toSecondOfDay();
						   double tempoTotal = Math.ceil((horaSaída - horaEntrada) / 60 / 60);
						   textTempo.setText(decimal2.format(tempoTotal));
						   double valorTotal = tempoTotal * 5;
						   textValor.setText(decimal2.format(valorTotal));
						   break;
					   }
				   }
					
				}
			});
			buttonSair.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					DaoCliente Daocliente = new DaoCliente();
				    ArrayList<Cliente> clientes = Daocliente.listarClientes();
				    
				    Daocliente.limparArquivo();
				    
				    int indice = 0;
				    for(Cliente cliente : clientes) {
				    	if(cliente.getPlaca().equals(textPlacaBusca.getText())) {
							tabelaClientesModelo.removeRow(indice);
				    	}else {
				    		DaoCliente dao = new DaoCliente(cliente);
							dao.salvar();
				    	}
				    	
				    	indice++;
				    }
				}
			});
			
		
}// fim de criarTela

private Color Color(int i, int j, int k) {
			// TODO Auto-generated method stub
			return null;
		}

private void criarTabela() {
	
	// tabela 
	
	tabelaClientesModelo = new DefaultTableModel();
    
    tabelaClientesModelo.addColumn("Código");
    tabelaClientesModelo.addColumn("Placa");
    tabelaClientesModelo.addColumn("Modelo");
    tabelaClientesModelo.addColumn("Data de Entrada");
    
    DaoCliente Daocliente = new DaoCliente();
    ArrayList<Cliente> clientes = Daocliente.listarClientes();
    
   for(Cliente cliente : clientes) {
	   String[] linha = {cliente.getCodigo(), cliente.getPlaca(), cliente.getModelo(), cliente.getDataEntrada().toString()};
	    tabelaClientesModelo.addRow(linha);
   }
    
    
    
    
    tabelaClientes = new JTable(tabelaClientesModelo);
			
			tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(100);
			tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(130);
			tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(130);
			tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(140);
			
			scrollTable = new JScrollPane(tabelaClientes);
			scrollTable.setBounds(30, 125, 795, 160);
			
	
}

private void limparFormulario() {
	textPlaca.setText("");
	textModelo.setText("");
}

private boolean validarFormulario() {
	
	boolean valido = true;
	
	if (textPlaca.getText().trim().length() == 0) {
		labelPlaca.setForeground(Color.RED);
		valido = false;
	} else if (textModelo.getText().trim().length() == 0) {
		labelModelo.setForeground(Color.RED);
		valido = false;
	}
	
	
	return valido;
	
}

}
