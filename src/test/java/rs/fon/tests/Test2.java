package rs.fon.tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Test2 {

	private final static String urlString = "http://localhost:8080/fonis-rest-service/users";

	public static void main(String[] args) throws Exception {

		URL url = new URL(urlString);

		for (int i = 0; i < 50; i++) {
			JsonObject obj = new JsonObject();
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			obj.addProperty("id", 11 + i);
			obj.addProperty("name", "Ime " + i);
			obj.addProperty("lastName", "Prezime " + i);
			obj.addProperty("email", "ime@prezime.com");
			JsonArray array = new JsonArray();
			obj.add("posts", array);

			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
			wr.write(obj.toString());
			wr.close();
			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			con.disconnect();
		}

	}

}
