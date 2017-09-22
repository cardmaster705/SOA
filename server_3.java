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
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class server_3 extends JFrame {
	ServerSocket server;
	Socket socket;
	int puerto=9000;
	DataOutputStream salida, resultado;
	BufferedReader entrada;
	int a,b,c;
	int eleccion;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					server_3 frame = new server_3();
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
	public server_3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblServidorIniciado = new JLabel("Servidor");
		lblServidorIniciado.setFont(new Font("Papyrus", Font.PLAIN, 48));
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iniciar();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(113)
							.addComponent(lblServidorIniciado))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(160)
							.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(lblServidorIniciado)
					.addGap(18)
					.addComponent(btnIniciar)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	
public void iniciar(){
		
		try{
		
		server = new ServerSocket(puerto);//se establece el puerto que tendra el server
		socket = new Socket();
		socket = server.accept();//acepta la conexion entrante al puerto
		//el server ya es funcional y espera a el cliente
		//entrada = new BufferedReader (new InputStreamReader(socket.getInputStream()));//lee el mensaje que envia el cliente y lo almacena en entrada
		//String mensaje = entrada.readLine();//almacena en un string los datos que contiene entrada
		//System.out.println(mensaje);//imprime en pantalla los datos recibidos por el cliente
		salida = new DataOutputStream(socket.getOutputStream());//envia un mensaje a el cliente
		salida.writeUTF("Conexion establecida\n");//mensaje para el cliente
		//salida.writeUTF("Selecciona el tipo de operacion");
		entrada =new BufferedReader (new InputStreamReader(socket.getInputStream()));
		String elec = entrada.readLine();
		eleccion=Integer.parseInt(elec);
		//entrada = new BufferedReader (new InputStreamReader(socket.getInputStream()));//recibe el primer parametro del cliente
		String n1 =entrada.readLine();//almacena el texto en una variable
		a=Integer.parseInt(n1);
		//entrada = new BufferedReader (new InputStreamReader(socket.getInputStream()));//recibe el segundo parametro del cliente
		String n2 = entrada.readLine();//almacena el texto en una variable
		b=Integer.parseInt(n2);
		//System.out.println(elec+n1+n2);
		switch(eleccion){
		case 1:
			suma(a,b);
			break;
		case 2:
			resta(a,b);
			break;
		case 3:
			multiplicacion(a,b);
			break;
		case 4:
			division(a,b);
			break;
		}
		String s= String.valueOf(c); 
		salida= new DataOutputStream(socket.getOutputStream());
		salida.writeUTF(s);
		//System.out.println(s);
		//salida.writeUTF("Servidor Terminado");
		socket.close();//termina la conexion
		
		}catch(Exception e){};
	}

public int suma(int a, int b){
	c=a+b;
	return c;
}
public int resta(int a, int b){
	c=a-b;
	return c;
}
public int multiplicacion(int a, int b){
	c=a*b;
	return c;
}
public int division(int a, int b){
	c=a/b;
	return c;
}
}
