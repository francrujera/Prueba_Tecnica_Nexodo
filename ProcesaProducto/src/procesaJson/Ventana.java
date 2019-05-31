package procesaJson;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;


	@SuppressWarnings("serial")
	public class Ventana extends JFrame{

		private JPanel contentPane;
	 
//Lanzamos la aplicacion
	    
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	Ventana frame = new Ventana();
	                    frame.setVisible(true);	                    
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	 

//Creamos el Frame
	    
	    public Ventana() {
	 
	        //Parametros asociados a la ventana
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 650, 300);
	        contentPane = new JPanel();
	        contentPane.setLayout(null);
	        setContentPane(contentPane);	 
 
	        //A�adimos el Boton para seleccionar un archivo
	        JButton btnSeleccionar = new JButton("Pulse para seleccionar el archivo JSON");
	        btnSeleccionar.setBounds(150, 25, 300, 23);
	        contentPane.add(btnSeleccionar);
	            
	        	 
	        btnSeleccionar.addActionListener(new ActionListener(){
	            public void actionPerformed (ActionEvent e){
	            	//Creamos el objeto JFileChooser
	            	JFileChooser fc=new JFileChooser();
	            	 
	            	//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
	            	int seleccion=fc.showOpenDialog(contentPane);
	            	 
	            	//Si el usuario, pincha en aceptar
	            	if(seleccion==JFileChooser.APPROVE_OPTION){
	            	 
	            	    //Seleccionamos el fichero
	            	    File fichero=fc.getSelectedFile();
	            	 
	            	    procesaJSON.recorreJSON(fichero.getAbsolutePath());
	            	    
	            	    //Configuramos la tabla
	        	        JTable table = new JTable(procesaJSON.data, procesaJSON.column); 
	                    
	        	        table.setBounds(20, 76, 300, 300);
	            	    
	        	        JScrollPane scroll=new JScrollPane(table);
	        	        scroll.setBounds(20, 76, 600, 300);
	        	        contentPane.add(scroll);
	            	    
	            	}
	            }
	        });
	 
	    }}
