import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;

    .@SuppressWarnings("unused")
        public class SendingSms {

        private static boolean result;
        private static HttpURLConnection con;
        
        public Sending() 
            {
                // TODO Auto-generated constructor stub
            }
        void main(String[] args) throws IOException {
            // TODO Auto-generated method stub

            String sendername = "&sendername=" + URLEncoder.encode("Enter your sender name", "UTF-8");
            String username = "&username=" + URLEncoder.encode("Enter your Bongolive username", "UTF-8");
            String password = "&password=" + URLEncoder.encode("Enter your Bongolive Password", "UTF-8");
            String apiKey = "&apikey=" + URLEncoder.encode("Enter Key obtained from your Bongolive Account", "UTF-8");
            String destnum = "&destnum=" + URLEncoder.encode("Enter your destnation number", "UTF-8");
            String message = "&message=" + URLEncoder.encode("Enter your message content here", "UTF-8");
            String senddate = "&senddate=" + URLEncoder.encode("", "UTF-8");
    
            String url = "http://www.bongolive.co.tz/api/sendSMS.php?sendername=" + sendername + "&username=" + username + "&password=" + password + "&apikey=" + apiKey + "&destnum=" + destnum + "&message=" + message + "&senddate=" + senddate;

    
        try 
        {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content;

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()))) 
            {

                String line;
                content = new StringBuilder();

            while ((line = in.readLine()) != null) 
                {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
        
        System.out.println(content.toString());

        }   
        finally 
        {
        
        con.disconnect();
        }
    }
}