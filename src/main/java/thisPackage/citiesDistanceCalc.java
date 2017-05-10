package thisPackage;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class citiesDistanceCalc {
	
	
	public static void main(String[] args){
		
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
		
		System.out.println(gcd.getDistance(d1.getDouble("latitude"), d2.getDouble("latitude"), 
				d1.getDouble("latitude"), d2.getDouble("latitude")));
		
		mongoClient.close();
	}
}
