package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import model.Cliente;

public class DaoCliente {
	
	private static Cliente cliente;
	private static final String LOCAL_ARQUIVO = "C://Users//cinia//estacionamento.ds1";
	
	File arquivo = new File("C://Users//cinia//estacionamento.ds1");
	DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");   
	String data = formatData.format(new Date(arquivo.lastModified()));

	public DaoCliente (Cliente cliente) {
		this.cliente = cliente;
	}
	
	public DaoCliente() {
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void salvar() {
		
		Path patch = Paths.get(LOCAL_ARQUIVO);
		
		try {
			
			BufferedWriter writer = Files.newBufferedWriter(patch, 
					Charset.forName("UTF-8"), 
					StandardOpenOption.WRITE, 
					StandardOpenOption.APPEND);
			
			writer.write(cliente.toString());
			writer.newLine();
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não foi possivel salvar");
		}
		
	}
	public void limparArquivo() {
		
		Path patch = Paths.get(LOCAL_ARQUIVO);
		
		try {
			
			BufferedWriter writer = Files.newBufferedWriter(patch, 
					Charset.forName("UTF-8"), 
					StandardOpenOption.TRUNCATE_EXISTING);
			
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não foi possivel pagar");
		}
		
	}
	public Cliente buscarCliente(String placa) {
			
			Path path = Paths.get(LOCAL_ARQUIVO);
			
			try {
				BufferedReader reader = Files.newBufferedReader(path, 
						Charset.forName("UTF-8"));
				
				String linha = reader.readLine();
				Cliente cliente = new Cliente();
				
				while (linha != null) {
					String[] vetorCliente = linha.split(";");
					
					if(vetorCliente[0].equals(placa)) {
						cliente.setCodigo(vetorCliente[0]);
						cliente.setPlaca(vetorCliente[1]);
						cliente.setModelo(vetorCliente[2]);
						cliente.setDataEntrada(LocalDate.parse(vetorCliente[3]));
						cliente.setHoraEntrada(LocalTime.parse(vetorCliente[4]));
						cliente.setDataSaida(LocalDate.parse(vetorCliente[5]));
						cliente.setHoraSaida(LocalTime.parse(vetorCliente[6]));
						cliente.setTempo(Double.parseDouble(vetorCliente[7]));
						break;
					}
					linha = reader.readLine();
				}
				
					System.out.println(cliente);
				reader.close();
				
				return cliente;
				
			} catch (Exception e) {
	            System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
	            System.out.println(e.getMessage());
	            e.printStackTrace();
	            return null;
			}
	}
	
	public ArrayList<Cliente> listarClientes() {
		//arquivo leitura ou escrita
		
		
		Path path = Paths.get(LOCAL_ARQUIVO);
		
		try {
			
			BufferedReader reader = Files.newBufferedReader(path, 
					Charset.forName("UTF-8"));
			
			String linha = reader.readLine();
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			while (linha != null) {
				String[] vetorCliente = linha.split(";");
				
				Cliente cliente = new Cliente();
				cliente.setCodigo(vetorCliente[0]);
				cliente.setPlaca(vetorCliente[1]);
				cliente.setModelo(vetorCliente[2]);
				cliente.setDataEntrada(LocalDate.parse(vetorCliente[3]));
				cliente.setHoraEntrada(LocalTime.parse(vetorCliente[4]));
				
				
				clientes.add(cliente);
				
				linha = reader.readLine();
			}
			
			System.out.println(clientes);
			
			reader.close();
			return clientes;
			
           
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na tentativa de ler o arquivo");
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
            return null;
	}
	
	}
}

