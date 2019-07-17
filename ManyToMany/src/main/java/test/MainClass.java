package test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf=config.buildSessionFactory();
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		
		
		Item laptop=new Item();
		laptop.setPrice(100);
		laptop.setiName("laptop");
		
		Item mouse=new Item();
		mouse.setPrice(200);
		mouse.setiName("mouse");
		
		Item pendrive=new Item();
		pendrive.setPrice(300);
		pendrive.setiName("pendrive");
		
		Set<Item> itemset1=new HashSet<Item>();
		itemset1.add(laptop);
		itemset1.add(mouse);
		
		Set<Item> itemset2=new HashSet<Item>();
		itemset2.add(mouse);
		itemset2.add(pendrive);
		
		Cart cart1=new Cart();
		cart1.setItems(itemset1);
		cart1.setTotal(300);
		
		Cart cart2=new Cart();
		cart2.setItems(itemset2);
		cart2.setTotal(500);
		
		session.save(cart1);
		session.save(cart2);
		System.out.println("Before committing transaction");
		t.commit();
		session.close();
		
		System.out.println("Cart ID="+cart1.getId());
		System.out.println("Cart1 ID="+cart2.getId());
		
	}

}
