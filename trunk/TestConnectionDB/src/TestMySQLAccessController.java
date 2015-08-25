import org.zkoss.bind.annotation.Command;
import org.zkoss.zul.Messagebox;


public class TestMySQLAccessController {

	private boolean result = false;

	private Connection connection = new Connection();
	
	@Command
	public void testConnection(){
		TestMySQLAccess access = new TestMySQLAccess();
		try {
			result = access.testConnectionDB(connection.getHost(),connection.getName(),connection.getUsername(),connection.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show(e.getMessage());
		}
		if(result){
			Messagebox.show("Test Connection: OK");
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
