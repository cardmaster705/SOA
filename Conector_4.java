package socket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;
import javax.swing.JTextArea;

public class Conector_4 extends JFrame {
	ServerSocket conector, conectorServidor;
	Socket socket,socket2;
	int puerto=8000;
	int puertoServer=9000;
	DataOutputStream salida;
	PrintStream salidaServidor;
	BufferedReader entrada, entradaServidor;
	String operacion="";
	String elemento1="";
	String elemento2="";
	String ip ="127.0.0.1";
	String resultadoServidor="";
	boolean disponible=true;
	//visual
	
	JLabel lblConector = new JLabel("Conector");
	JLabel lblServidor = new JLabel("Servidor Disponible:");
	JButton btnIniciar = new JButton("Iniciar");
	JTextArea campoServidorDisponible = new JTextArea();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conector_4 frame = new Conector_4();
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
	public Conector_4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblConector.setFont(new Font("Sitka Small", Font.PLAIN, 55));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conector();
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addComponent(lblConector))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblServidor)
								.addGap(32)
								.addComponent(campoServidorDisponible))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(179)
								.addComponent(btnIniciar))))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblConector)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIniciar)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServidor)
						.addComponent(campoServidorDisponible, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void conector(){
		
		try {
			conector = new ServerSocket(puerto);
			socket = conector.accept();
			entrada =new BufferedReader (new InputStreamReader(socket.getInputStream()));
			salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF("Conexion establecida\n");
			 operacion=entrada.readLine();
			 elemento1=entrada.readLine();
			 elemento2=entrada.readLine();
			//salida.writeUTF(resultadoServidor);
			if(operacion!=null&&elemento1!=null&&elemento2!=null){
				conexionServidor();
		
					salida.writeUTF(resultadoServidor);
				
			}
			socket.close();
		} catch (Exception e) {
		
		}
		
	
	}
	
	public void conexionServidor(){
		try{
			campoServidorDisponible.setText("servidor 1");
			socket2 = new Socket(ip,puertoServer);
			entradaServidor =new BufferedReader (new InputStreamReader(socket2.getInputStream()));
			String mensajeConexion=entradaServidor.readLine();
			salidaServidor = new PrintStream(socket2.getOutputStream());
			salidaServidor.println(operacion);
			salidaServidor.println(elemento1);
			salidaServidor.println(elemento2);
			resultadoServidor = entradaServidor.readLine();
			System.out.println(resultadoServidor);
			
		}catch(Exception e){
			
		}
	}
	
}
