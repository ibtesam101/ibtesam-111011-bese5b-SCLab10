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
	}
}
