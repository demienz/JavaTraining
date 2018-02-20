package openweathermap;

import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class GetJsonFromUrl {
	private static Scanner scan;

	//static final String UrltoApi = "http://api.openweathermap.org/data/2.5/weather?q=Lodz,pl&APPID=000b957d41dbc5695b68d9435923cc75";

	public static void main(String[] args) throws IOException, JSONException {
		
		String cityName = setCityName();
		JSONObject json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + ",pl&APPID=000b957d41dbc5695b68d9435923cc75");
 
		//System.out.println(json.toString());
		//System.out.println(json.get("id"));
		 
		JSONObject subJson = (JSONObject) json.get("main");
		System.out.println("Temperatura w : " + cityName + " to " + kelvinToCelsius((double) subJson.get("temp")));
			 
	}

	
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }

	  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
	  
	  public static double kelvinToCelsius (double temp) {
		  
		  double newTemp = temp - 273.15;
		  return newTemp;
		  
	  }

	  public static String setCityName() {
		  
		  scan = new Scanner(System.in);
		  System.out.println("Podaj nazwe miasta: ");
		  String cityName = scan.nextLine();
		  return cityName;
		  
	  }
	  
	
	
	
}
