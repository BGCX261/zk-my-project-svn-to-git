
public class MainTest {

	public static void main(String[] args) throws Exception {
		
		String host = "localhost";
		String name = "bst";
		String username = "root";
		String password = "ulixe";
		
		TestMySQLAccess tAccess = new TestMySQLAccess();
		boolean result = tAccess.testConnectionDB(host,name, username, password);
		System.out.print(result);
		
	}

}
