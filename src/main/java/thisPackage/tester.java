package thisPackage;

import static org.junit.Assert.*;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class tester {

	@Test
	public void test() {
		
		MongoClient mongoClient = new MongoClient();
		
		// Access database named 'test'
	       
		MongoDatabase database = mongoClient.getDatabase("test");

		// Access collection named 'restaurants'
       
		MongoCollection<Document> collection = database.getCollection("cities");
		
		greatCircleDistance gcd = new greatCircleDistance();
		
		cityRetriever cr = new cityRetriever();
		
		Document d1 = new Document();
		Document d2 = new Document();
		
		d1=cr.findCity("Atlanta");
		
		d2=cr.findCity("Arlington");
		
		float x= gcd.getDistance(d1.getDouble("latitude"), d2.getDouble("latitude"), 
				d1.getDouble("longitude"), d2.getDouble("longitude"));
		
		System.out.println(x);
		mongoClient.close();
		
		assertEquals((float)872.7224,(float)x);
	}

}
