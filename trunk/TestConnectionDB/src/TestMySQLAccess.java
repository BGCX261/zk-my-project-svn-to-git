import java.sql.Connection;
import java.sql.DriverManager;



public class TestMySQLAccess {

	private Connection connect = null;
	
	private boolean resultTest = false;
	
	public boolean testConnectionDB(String host, String name, String username, String password) throws Exception{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String urlConnection = "jdbc:mysql://"+host+":3306/"+name;
			connect = DriverManager.getConnection(urlConnection, username, password);
			if (connect!=null) {
				resultTest = true;
				connect.close();
			}
		} catch (ClassNotFoundException e) {
			throw e;
		}	
			return resultTest;
	}
	
}
