/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import Interface.Ajouter.Retour;

/**
 *
 * @author Soda Ndiaye
 */
public class Gestion_Utilisateurs extends JFrame{

	public JPanel conteneur, pan1, pan2 ,pan;
	private CardLayout cdl1 = new CardLayout();
	private CardLayout cdl2 = new CardLayout();
	private GridLayout grdl = new GridLayout(1, 4, 2, 2);
	private JButton[] jbtpan1 = new JButton[5];
       // private  JButton R= new  JButton();
	private JTabbedPane jtp;
	
	
	public Gestion_Utilisateurs() {
		super();
        this.setTitle("GESTION  DES UTILISATEURS");
		this.setLocationRelativeTo(null);
		this.setSize(700, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		conteneur = new JPanel();
		
		pan1 = new JPanel();
		pan1.setPreferredSize(new Dimension(140, 140));
		//pan1.setLayout(grdl);
		
		
		jtp = new JTabbedPane();
		//jtp.setLayout(grdl);
		jtp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		jtp.addTab("RSA", pan1);
		
		
		//this.pack();
		pan2 = new JPanel();
		pan2.setPreferredSize(new Dimension(170, 50));
		pan2.setBackground(Color.blue);
		
		
		jbtpan1[0] = new JButton("Ajouter ");
		jbtpan1[1] = new JButton("Supprimer");
		jbtpan1[2] = new JButton("Modifier");
		jbtpan1[3] = new JButton("Lister");
        jbtpan1[4]=new JButton("Retour");
        jbtpan1[4].addActionListener(new Retour());
                
                
		for(int i=0; i<4; i++)
		{
			jbtpan1[i].setPreferredSize(new Dimension(150, 30));
                }
		
		for(int i=0; i<jbtpan1.length; i++)
		{
			jbtpan1[i].setPreferredSize(new Dimension(150, 30));
			pan2.add(jbtpan1[i]);
		}

		/*
		pan2.add(jbtpan1[0]);
		pan2.add(jbtpan1[1]);
		pan2.add(jbtpan1[2]);
		pan2.add(jbtpan1[3]);*/
		
		conteneur.setPreferredSize(new Dimension(200, 300));
		conteneur.setLayout(cdl2);
//		pan.add(jbtpan1[4]);
		Ajouter a = new Ajouter();
		conteneur.add("Ajouter", a.getJpan());
		
		jbtpan1[0].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				cdl2.show(conteneur, "Ajouter");
			}
		}
		);
		
		Supprimer S =new Supprimer();
		conteneur.add("Supprimer", S.getJpan());
		
		jbtpan1[1].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				cdl2.show(conteneur, "Supprimer");
			}
		}
		);
		
		Modifier M=new  Modifier();
		conteneur.add(jbtpan1[2].getText(), M.getJpan());
		
		jbtpan1[2].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				cdl2.show(conteneur, jbtpan1[2].getText());
			}
		}
		);
		
		
                Lister L =new Lister();
		conteneur.add(jbtpan1[3].getText(), L.getJpan());
		
		jbtpan1[3].addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				cdl2.show(conteneur, jbtpan1[3].getText());
			}
		}
		);
		
		
		
	
		Tête e = new Tête();
                
				//this.getContentPane().add(jtp, BorderLayout.NORTH);
                this.getContentPane().add(conteneur, BorderLayout.CENTER);
		this.getContentPane().add(pan2, BorderLayout.WEST);
                //this.getContentPane().add(pan, BorderLayout.SOUTH);
		this.getContentPane().add(e.getPanel1(), BorderLayout.NORTH);
                this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	class Retour implements ActionListener {

        public void actionPerformed(ActionEvent e){
            Interface.Admin A = new Interface.Admin();
            setVisible(false);
            A.setVisible(true);
            
            }
        }
    
}
