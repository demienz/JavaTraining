package openweathermap;

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
	//static final String UrltoApi = "http://api.openweathermap.org/data/2.5/weather?q=Lodz,pl&APPID=000b957d41dbc5695b68d9435923cc75";

	public static void main(String[] args) throws IOException, JSONException {
		 JSONObject json = readJsonFromUrl("http://api.openweathermap.org/data/2.5/weather?q=Lodz,pl&APPID=000b957d41dbc5695b68d9435923cc75");
		    System.out.println(json.toString());
		    System.out.println(json.get("id"));
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

	  
	
	
	
}
