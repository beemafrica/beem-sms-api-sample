import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;

.@SuppressWarnings("unused")
public class Send {

	private static boolean result;
	private static HttpURLConnection con;
	
	public Send() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String username = "&username=" + URLEncoder.encode("Enter your username", "UTF-8");
		String password = "&password=" + URLEncoder.encode("Enter your password", "UTF-8");
		String request = "&request=" + URLEncoder.encode("sender", "UTF-8");
		
		
		
		String url = "http://www.bongolive.co.tz/api/request.php?username=" + username + "&password=" + password + "&request=" + request;

        
		try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            
            System.out.println(content.toString());

        } finally {
            
            con.disconnect();
        }
    }
}