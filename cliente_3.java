package socket;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cliente_3 extends JFrame {
	//variables importantes
	Socket cliente;
	int puerto =9000;
	String ip ="127.0.0.1";
	BufferedReader entrada;
	PrintStream salida;
	
	//visual
	JTextArea estadoConexion = new JTextArea();
	JTextArea numeroUno = new JTextArea();
	JTextArea numeroDos = new JTextArea();
	JTextArea resultado = new JTextArea();
	JTextArea tipoOperacion = new JTextArea();
	JButton btnEnviar = new JButton("Enviar");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cliente_3 frame = new cliente_3();
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
	public cliente_3() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSeleccionaElTipo = new JLabel("Escribe el tipo de operacion:");
		
		
		
		JLabel lblsuma = new JLabel("1-Suma");
		
		JLabel lblresta = new JLabel("2-Resta");
		
		JLabel lblmultiplicacion = new JLabel("3-Multiplicacion");
		
		JLabel lbldivision = new JLabel("4-Division");
		
		JLabel lblPrimerNumero = new JLabel("Primer numero(Solo enteros):");
		
		JLabel lblSegundoNumero = new JLabel("Segundo numero(Solo enteros):");
		
		
		
		
		
		
		JLabel lblRespuesta = new JLabel("Respuesta:");
		
		
		
		JLabel lblEstadoDeLa = new JLabel("Estado de la conexion:");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblRespuesta)
									.addComponent(lblSegundoNumero)
									.addComponent(lblPrimerNumero)
									.addComponent(lblresta)
									.addComponent(lblEstadoDeLa)
									.addComponent(lblsuma))
								.addGap(44)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblmultiplicacion)
										.addContainerGap(189, Short.MAX_VALUE))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(lbldivision)
										.addContainerGap(215, Short.MAX_VALUE))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
												.addGap(18)
												.addComponent(tipoOperacion, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
											.addComponent(estadoConexion, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
										.addGap(123))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(numeroDos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
											.addComponent(resultado, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
											.addComponent(numeroUno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
										.addGap(123))))
							.addComponent(lblSeleccionaElTipo))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnEnviar)
							.addGap(164))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(estadoConexion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstadoDeLa))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeleccionaElTipo)
						.addComponent(tipoOperacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblsuma)
						.addComponent(lblmultiplicacion))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblresta)
						.addComponent(lbldivision))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrimerNumero)
						.addComponent(numeroUno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSegundoNumero)
						.addComponent(numeroDos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnEnviar)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRespuesta)
						.addComponent(resultado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		cliente();
	}
	
	public void cliente(){
		try{
			
			cliente= new Socket(ip,puerto);
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));//recibe la informacion del server y la almacena en entrada
			String estado_conexion=entrada.readLine();
			estadoConexion.setText(estado_conexion);
			salida = new PrintStream(cliente.getOutputStream());
			
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 String tipo_operacion=tipoOperacion.getText();
					 String numero_uno=numeroUno.getText();
					 String numero_dos=numeroDos.getText();
					try{
						salida = new PrintStream(cliente.getOutputStream());
						salida.println(tipo_operacion);//se envia al server
						salida.println(numero_uno);
						salida.println(numero_dos);
						String resultado_server= entrada.readLine();//recibe la informacion del server
						System.out.println(resultado_server);
						resultado.setText(resultado_server);
					}catch(Exception e){}
				}
			});
		}catch(Exception e){};
		
	}
}
