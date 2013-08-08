package ya.example.manga4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

public class AsyncHttpFile extends AsyncTask<String, String, String> {
    private File file;
    private HttpActivity activity;

    /**
     * constructor
     */
    public AsyncHttpFile(File file) {
        this.file = file;
        this.activity = activity;
    }
    
    public void send()
    {
    	this.execute("http://133.242.188.195:8080/cyber4koma/file");
    }

    /**
     * background
     */
    @Override
    protected String  doInBackground(String... params) {
    	System.out.println("KOKO!");
    	String str = "";
    	 HttpClient httpclient = HttpClientFactory.getThreadSafeClient();
    	 
    	 
    	 try
    	 {
    	 
    	 httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

    	    HttpPost httppost = new HttpPost(params[0]);

    	    MultipartEntity mpEntity = new MultipartEntity();
    	    ContentBody cbFile = new FileBody(file, "image/jpeg");
    	    mpEntity.addPart("file", cbFile);


    	    httppost.setEntity(mpEntity);
    	    System.out.println("executing request " + httppost.getRequestLine());
    	    HttpResponse response = httpclient.execute(httppost);
    	    HttpEntity resEntity = response.getEntity();

    	    System.out.println(response.getStatusLine());
    	    if (resEntity != null) {
    	      System.out.println(EntityUtils.toString(resEntity));
    	    }
    	    if (resEntity != null) {
    	      resEntity.consumeContent();
    	    }
    	    
    	 } catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 
    	 
    	 
    	 
    	    return str;
    }

    /**
     * on getting result
     */
    @Override
    protected void onPostExecute(String result) {

    	//DrawView.show(result);

    }
}

