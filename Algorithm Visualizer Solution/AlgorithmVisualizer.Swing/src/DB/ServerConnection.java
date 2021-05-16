package DB;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;


import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ServerConnection {

    public void post(String uri, String data) throws Exception {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(uri);

            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("feedback", data));
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);

            //Error handling status code should be 200
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                JOptionPane.showMessageDialog(null, "Feedback saved!");
            }else{
                JOptionPane.showMessageDialog(null, "Error saving feedback!");
            }
            client.close();

    }

}