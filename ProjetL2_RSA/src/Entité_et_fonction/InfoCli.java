package Entité_et_fonction;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InfoCli {
	
	private static String url= "jdbc:mysql://localhost:3306/projet_rsa?useUnicode=true&characterEncoding=UTF-8";
    private static String user="root"; 
    private static String pass1="";
	private static BigInteger ncli;
    private static BigInteger ecli;
    private static BigInteger dcli;
    private Object IdCli;
    private String prenomcli;
    private String nomcli;
	public InfoCli(Object idCli) {
		
		this.IdCli = idCli;
	}
	public static BigInteger getNcli() {
		return ncli;
	}
	public static void setNcli(BigInteger ncli) {
		InfoCli.ncli = ncli;
	}
	public static BigInteger getEcli() {
		return ecli;
	}
	public static void setEcli(BigInteger ecli) {
		InfoCli.ecli = ecli;
	}
	public InfoCli() {
		super();
	}
	public static BigInteger getDcli() {
		return dcli;
	}
	public static void setDcli(BigInteger dcli) {
		InfoCli.dcli = dcli;
	}
	public Object getIdCli() {
		return IdCli;
	}
	public void setIdCli(String idCli) {
		IdCli = idCli;
	}
	public String getPrenomcli() {
		return prenomcli;
	}
	public void setPrenomcli(String prenomcli) {
		this.prenomcli = prenomcli;
	}
	public String getNomcli() {
		return nomcli;
	}
	public void setNomcli(String nomcli) {
		this.nomcli = nomcli;
	}

public void InfoUserCli() {
    	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c;
			c = DriverManager.getConnection(url, user, pass1);
			System.out.println("Connection etablie");
	        Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        ResultSet b = st.executeQuery("SELECT * FROM utilisateur WHERE Id = '"+IdCli+"'");
	        b.first();
	        BigInteger dcli = new BigInteger(b.getString("d"));
	        BigInteger ecli = new BigInteger(b.getString("e"));
	        BigInteger ncli = new BigInteger(b.getString("n"));
	        this.dcli = dcli;
	        this.ecli = ecli;
	        this.ncli = ncli;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    

}
