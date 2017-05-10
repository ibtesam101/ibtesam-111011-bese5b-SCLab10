package thisPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class csvParser {
	
	public csvParser(){

	}
	
	
	
	public static void main(String[] args){
		ArrayList<City> myCityList = new ArrayList<City>();
		
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
	
	                City c = new City();
	                
	                System.out.println("City [id= " + city[0] + " , country="+city[1]+ "]"+
	                		"[region= " + city[2] + " , city="+city[3]+ "]"+
	                		"[postalcode= " + city[4] + " , latitutude="+city[5]+ "]"+
	                		"[longitude= " + city[6]);
	                c.setlocId(Integer.parseInt(city[0]));
	                c.setCountry(city[1]);
	                c.setRegion(city[2]);
	                c.setCity(city[3]);
	                try{
	                	c.setPostalCode(Integer.parseInt(city[4]));
	                }
	                catch(NumberFormatException e){
	                	
	                }
	                try{
	                	c.setLatitude(Float.parseFloat(city[5]));
	                }
	                catch(NumberFormatException e){
	                	
	                }
	                try{
	                	c.setLongitude(Float.parseFloat(city[6]));
	                }
	                catch(NumberFormatException e){
	                	
	                }
	                myCityList.add(c);

            	}
            	
            	count++;
                
            }
            
            

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
