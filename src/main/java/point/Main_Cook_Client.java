package point;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import java.util.Properties;

public class Main_Cook_Client {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.setProperty("javax.jdo.PersistenceManagerFactoryClass", "com.objectdb.jdo.PMF");
        props.setProperty("javax.jdo.option.ConnectionURL", "objectdb://localhost:6136/points005/points102.odb");
        props.setProperty("javax.jdo.option.ConnectionUserName", "user1");
        props.setProperty("javax.jdo.option.ConnectionPassword", "user1");
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(props);
        PersistenceManager pm = pmf.getPersistenceManager();

        pm.currentTransaction().begin();
        // Operations that modify the database should come here.
        for (int i = 1000; i < 1500; i++) {
            Cook c = new Cook(i, i, i);
            pm.makePersistent(c);
        }
        pm.currentTransaction().commit();

        pm.close();
        pmf.close();

    }
}