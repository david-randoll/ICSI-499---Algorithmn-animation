import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;


public class ApacheHttpClientPost {

    public void postFeedback(String feedback){
    try {

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(
            "http://localhost:8080/AlgoAnimation/json/post"); //CHANGE THIS

        StringEntity input = new StringEntity(str, "UTF-8");
        input.setContentType("application/json");
        postRequest.setEntity(input);
        postRequest.setHeader("FeedBack", feedback);


        HttpResponse response = httpClient.execute(postRequest);

        //Failed to post
        if (response.getStatusLine().getStatusCode() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                + response.getStatusLine().getStatusCode());
        }

        //server response
        BufferedReader br = new BufferedReader(
                        new InputStreamReader((response.getEntity().getContent())));

        String output;
        System.out.println("Output from Server \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }

        httpClient.getConnectionManager().shutdown();

      } catch (MalformedURLException e) {

        e.printStackTrace();

      } catch (IOException e) {

        e.printStackTrace();

      }

    }
}


