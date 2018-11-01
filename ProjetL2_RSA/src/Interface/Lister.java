package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Lister extends JPanel{
	
private static String url= "jdbc:mysql://localhost:3306/projet_rsa?useUnicode=true&characterEncoding=UTF-8";
    
    private static String user="root"; 

    private static String pass1="";
	    private JScrollPane jsp;
	    private JSeparator js;
	    private JTable jt;
	    private JPanel[] jp = new JPanel[3];
	    private JPanel jpan = new JPanel();
	    private JButton[] jb = new JButton[3];
            private  JLabel jl=new JLabel();
	    DefaultTableModel d;
	   
	    public Lister(){
	    	
	    	this.setVisible(true);
	    	//this.setLocationRelativeTo(null);
	    	this.setSize(500, 600);
	    	js = new JSeparator();
	    	for(int i=0; i < jp.length; i++){
	    		jp[i] = new JPanel();
	    	}
	    	
	    	jp[1].setBackground(new java.awt.Color(0, 153, 153));
	        jp[1].setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, 18), new Color(255, 255, 255))); // NOI18N
	        

	    	/*jl[0].setText("Gestion Laboratoire");
	    	jl[0].setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
	        jl[0].setForeground(new java.awt.Color(255, 255, 255));*/
	        
	        jl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
	        jl.setForeground(new java.awt.Color(255, 255, 255));
	        jl.setText("Liste des Utilisateurs");
	        
	        
	       
 
	        jt = new JTable();
                
                   afficher();
	        
	        jsp = new JScrollPane(jt);
	        jsp.setPreferredSize(new Dimension(460, 200));
	        jsp.setViewportView(jt);
	        jt.setBackground(new Color(255, 255, 255));
	        jp[0].setBackground(new java.awt.Color(0, 51, 51));
	        jp[1].setBackground(new java.awt.Color(0, 51, 51));
	        
	        
	        jp[0].setSize(460, 100);
	        //jp[1].setSize(300, 600);
	       
	        jp[1].add(jsp);
	       
	        
	        /*jp[2].add(jb[0]);
	        jp[2].add(jb[1]);
	        jp[2].add(jb[2]);
	        */
                jpan.setBackground(new java.awt.Color(176, 224, 230));
                jpan.setPreferredSize(new Dimension(470, 540));
	        jpan.add(jp[0]);
	        jpan.add(jp[1]);
	        //jpan.add(jp[2]);
	        //getContentPane().add(jpan);
	       
	       
	     
	       
	             

	    }
	   
	    public void CreateColonne(){
            
            d=(DefaultTableModel) jt.getModel();
            
            d.addColumn("Id "); 
            d.addColumn("Nom ");
            d.addColumn("Prénom");
            
        }
             public JPanel getJpan() {
			return jpan;
		}

		public void setJpan(JPanel jpan) {
			this.jpan = jpan;
		}

			public void ligne(Object[] o/*int a, String b, String c, String d, String e, String f, String g */){
            
             //Object[] line ={a, b, c, d, e, f, g};
            
             d.addRow(o);
        }
		    public void afficher() {
		        
		    	CreateColonne();
		         
	            try{
	            Class.forName("com.mysql.jdbc.Driver");
	              
	            Connection c1 =DriverManager.getConnection(url, user, pass1);
	            
	            System.out.println("Connection bien etablie");
	            
	            Statement a = c1.createStatement();
	            
	            ResultSet b = a.executeQuery("SELECT * FROM utilisateur");
	          
	           Object[] ob = new Object[3];
	           	            
	            while(b.next()){
	                    
	          ob[0]=b.getString(1);
	          
	          ob[1] =b.getString(2);
	          
	          ob[2] =b.getString(3);
	          
	          ligne(ob);
	                
	                
	               
	    
	            
	      }
	        
	            
	         
	        }
	        catch(Exception ex){
	            ex.printStackTrace();
	        }
	   
	       

	    }

}
