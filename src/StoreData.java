import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
public static void main(String [] args)
{
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata meta= new MetadataSources(ssr).getMetadataBuilder().build();
	SessionFactory sf = meta.getSessionFactoryBuilder().build();
	Session session = sf.openSession();
	Transaction t = session.beginTransaction();
	
	Employee e1 = new Employee();
	//e1.setEmployeeId(1);
    e1.setName("Rahul singh");
	e1.setEmail("rahul@gmail.com");
	
	Address a1 = new Address();
	//a1.setAddressId(1);
	a1.setAddressLine1("malviya nagar sector 1");
	a1.setCity("Jaipur");
	a1.setPincode(302017);
	a1.setState("raj");
	a1.setCountry("India");
	
	e1.setAddress(a1);
	a1.setEmployee(e1);
	
	session.persist(e1);
	t.commit();
	session.close();
	System.out.println("data stored in table");
	
}
}
