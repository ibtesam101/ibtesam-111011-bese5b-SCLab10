package thisPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class cityRetriever {
	
	public Document findCityCO(double d, double e){
		MongoClient mongoClient = new MongoClient();
		// Access database named 'test'
	       
		MongoDatabase database = mongoClient.getDatabase("test");

		MongoCollection<Document> collection = database.getCollection("cities");

		
		
		Document doc= new Document();
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("latitude", d);
		whereQuery.put("longitude", e);
		FindIterable<Document> cursor = collection.find(whereQuery);
		
		for(Document d1:cursor){
			doc=d1;
		}
	
		return doc;
	}
	public Document findCity(String x){
		
		MongoClient mongoClient = new MongoClient();
		// Access database named 'test'
	       
		MongoDatabase database = mongoClient.getDatabase("test");

		MongoCollection<Document> collection = database.getCollection("cities");

		
		
		Document d= new Document();
		
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("City", "\""+x+"\"");
		FindIterable<Document> cursor = collection.find(whereQuery);
		
		for(Document d1:cursor){
			d=d1;
		}
		
		return d;
	}
	
	public static void main(String[] args){
		
		MongoClient mongoClient = new MongoClient();
		
		// Access database named 'test'
	       
		MongoDatabase database = mongoClient.getDatabase("test");

		// Access collection named 'restaurants'
       
		MongoCollection<Document> collection = database.getCollection("cities");

		
		
		FindIterable<Document> cursor = collection.find();
		
		for(Document d:cursor){
			System.out.println(d);
		}
		
		System.out.println("Testing single city search");
		cityRetriever cR=new cityRetriever();
		System.out.println(cR.findCity("Atlanta"));
		System.out.println(cR.findCityCO(33.792999267578125,-84.44319915771484));
		mongoClient.close();
	}
}
