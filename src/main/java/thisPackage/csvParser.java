package thisPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class csvParser {
	
	public csvParser(){

	}
	
	
	
	public static void main(String[] args){
		
		MongoClient mongoClient = new MongoClient();
		
		// Access database named 'test'
	       
		MongoDatabase database = mongoClient.getDatabase("test");

		// Access collection named 'cities'
       
		MongoCollection<Document> collection = database.getCollection("cities");

      
		ArrayList<City> myCityList = new ArrayList<City>();
		ArrayList<Document> myCityDocList = new ArrayList<Document>();
		
		csvParser myC = new csvParser();
		String csvFile = "GeoLiteCity-Location.csv";
		String line = "";
		String cvsSplitBy = ",";
	
		int count = 0;
		
		BufferedReader br = null;
		
		String check = "wut";
		
		try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null  && count <1000) {

            	if(count>2){

	                // use comma as separator
	                String[] city = line.split(cvsSplitBy);
	                Document cDoc = new Document();
	                City c = new City();
	                
	                System.out.println("City [id= " + city[0] + " , country="+city[1]+ "]"+
	                		"[region= " + city[2] + " , city="+city[3]+ "]"+
	                		"[postalcode= " + city[4] + " , latitutude="+city[5]+ "]"+
	                		"[longitude= " + city[6]);
	                c.setlocId(Integer.parseInt(city[0]));
	                cDoc.append("id", Integer.parseInt(city[0]));
	                c.setCountry(city[1]);
	                cDoc.append("Country", city[1]);
	                c.setRegion(city[2]);
	                cDoc.append("Region", city[2]);
	                c.setCity(city[3]);
	                cDoc.append("City", city[3]);
	                try{
	                	c.setPostalCode(Integer.parseInt(city[4]));
	                	cDoc.append("PostalCode", Integer.parseInt(city[4]));
	                }
	                catch(NumberFormatException e){
	                	
	                }
	                try{
	                	c.setLatitude(Float.parseFloat(city[5]));
	                	cDoc.append("latitude", Float.parseFloat(city[5]));
	                }
	                catch(NumberFormatException e){
	                	
	                }
	                try{
	                	c.setLongitude(Float.parseFloat(city[6]));
	                	cDoc.append("longitude", Float.parseFloat(city[6]));
	                }
	                catch(NumberFormatException e){
	                	
	                }
	                myCityList.add(c);
	                myCityDocList.add(cDoc);
            	}
            	
            	count++;
                
            }
            
            collection.insertMany(myCityDocList);
            mongoClient.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
	}
}
