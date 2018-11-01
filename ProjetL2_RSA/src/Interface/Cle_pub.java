/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class Cle_pub  extends JFrame{
	

	private static String url= "jdbc:mysql://localhost:3306/projet_rsa?useUnicode=true&characterEncoding=UTF-8";
    
    private static String user="root"; 

    private static String pass1="";
	    private JScrollPane jsp;
	    private JSeparator js;
	    private JTable jt;
	    private JPanel[] jp = new JPanel[3];
	    private JPanel jpan = new JPanel();
	    private JLabel[] jl = new JLabel[4];
	    private JComboBox jcb =new JComboBox();
	    private JButton jb = new JButton();
            private  JTextField nomRech =new JTextField();
	    DefaultTableModel d;
	   
	    public Cle_pub(){
	    	this.setTitle("GESTION LABORATOIRE");
		this.setLocationRelativeTo(null);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	    	this.setVisible(true);
	    	//this.setLocationRelativeTo(null);
	    	this.setSize(500, 600);
	    	js = new JSeparator();
	    	for(int i=0; i < jp.length; i++){
	    		jp[i] = new JPanel();
	    	}
	    	
	    	jp[1].setBackground(new java.awt.Color(0, 153, 153));
	        jp[1].setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 18), new Color(255, 255, 255))); // NOI18N
	        

	    	for(int i=0 ; i < jl.length; i++){
	    		jl[i] = new JLabel();
	    		jl[i].setPreferredSize(new Dimension(100, 30));
                       
	    	}
                      //  jb.setText("Ok");
                       // jb.setPreferredSize(new Dimension(50, 30));
                      //  jb.addActionListener(new Afficher());
	    		//nomRech.setPreferredSize(new Dimension(100, 30));
	        
	        jl[1].setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
	        jl[1].setForeground(new java.awt.Color(255, 255, 255));
	        jl[1].setText("");
	        jl[0].setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
	        jl[0].setForeground(new java.awt.Color(255, 255, 255));
	        jl[0].setText("Liste des Laboratoires : Recherche");
	        
	        
	        jl[2].setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
	        jl[2].setForeground(new java.awt.Color(255, 255, 255));
	        jl[2].setText("NomVille");
	        

	        
	        
	        jt = new JTable();
                
//	           labo();
	        
	        jsp = new JScrollPane(jt);
	        jsp.setPreferredSize(new Dimension(460, 200));
                jsp.setViewportView(jt);
	        jt.setBackground(new Color(255, 255, 255));
	        jp[0].setBackground(new java.awt.Color(0, 51, 51));
	        jp[1].setBackground(new java.awt.Color(0, 51, 51));
	        
	        
	        jp[0].setSize(460, 100);
	        //jp[1].setSize(300, 600);
	       
	        jcb.setPreferredSize(new Dimension(100, 30));
                
	        jp[0].setPreferredSize(new Dimension(450, 80));
                jp[0].setLayout(new GridLayout(2, 2, 5, 5));
	       
	        
	        jp[1].add(jsp);
	       
	        
	        /*jp[2].add(jb[0]);
	        jp[2].add(jb[1]);
	        jp[2].add(jb[2]);
	        */
                jpan.setBackground(new java.awt.Color(176, 224, 230));
                jpan.setPreferredSize(new Dimension(470, 500));
	        jpan.add(jp[0]);
	        jpan.add(jp[1]);
                
		this.getContentPane().add(jpan, BorderLayout.CENTER);
	        //jpan.add(jp[2]);
	        //getContentPane().add(jpan);
	       
                
	    }
            
            
            
             public JPanel getJpan() {
			return jpan;
		}

		public void setJpan(JPanel jpan) {
			this.jpan = jpan;
		}
            
            
            
	    public void CreateColonne(){
            jt.repaint();
            d=(DefaultTableModel) jt.getModel();
               
            d.addColumn("Id ");
            d.addColumn("Nom");
            d.addColumn("Prenom");
            d.addColumn("n");
            d.addColumn("e");
       
            
        }

			public void ligne(Object[] o/*int a, String b, String c, String d, String e, String f, String g */){
            
             //Object[] line ={a, b, c, d, e, f, g};
            
             d.addRow(o);
        }
                   
                    
		    public void pub() {
		       JCheckBox n =new JCheckBox();
		       JCheckBox e =new JCheckBox();
		    	CreateColonne();
		         
	            try{
	            Class.forName("com.mysql.jdbc.Driver");
	              
	            Connection c1 =DriverManager.getConnection(url, user, pass1);
	            
	            System.out.println("Connection bien etablie");
	            
	            Statement a = c1.createStatement();
	            
	            ResultSet b = a.executeQuery("SELECT * FROM utilisateur");
	          
	           Object[] ob1 = new Object[5];
	    
	            while(b.next()){
	                    
	          ob1[0]=b.getCharacterStream(1);
	          
	          ob1[1] =b.getString(2);
	          
	          ob1[2] =b.getString(3);
	          
	          ob1[3] =n;
	          
	          ob1[4] =e;
	          ligne(ob1);
	     
	      }
	 
	        }
	        catch(Exception ex){
	            ex.printStackTrace();
	        }
	 
	    }
                    
         class   recuperation_de_n implements ActionListener {

        public void actionPerformed(ActionEvent e){
            
            try {
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                String requete= "SELECTE n FROM utilisateur WHERE Id=";
                Connection Con = DriverManager.getConnection(url,user,pass1);
                System.out.println("Connection etablie");
                Statement st =  Con.createStatement();
                st.execute(requete);
                
            }catch(Exception e1){
                e1.printStackTrace();
            }
	}
}
                    
   	    
}
	        
	        
	        
	        
	        
    

