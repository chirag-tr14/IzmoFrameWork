package price.rule.testcase;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.database.Database;

public class EuroDatabase {
	@Test
	public void selectData() throws ClassNotFoundException, SQLException {
		Database databse = new Database();
		String Query = "select *from inventory_price_rules where level='DLR' and fk_dealer_id=103209 and status='ACTV';";
		ResultSet data = databse.getData(Query);
		// System.out.println(data);
		while (data.next()) {
			System.out.println(data.getString(1));

			// String ruleid=data.getString(1);
		}
	}
}
