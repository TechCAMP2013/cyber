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

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
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
    	 HttpClient httpclient = new DefaultHttpClient();

		    HttpPost httppost = new HttpPost(params[0]);
		    str += "1";
		    InputStreamEntity reqEntity;
			try {
				str += "2";
				reqEntity = new InputStreamEntity(
				        new FileInputStream(file), -1);
			
		    reqEntity.setContentType("binary/octet-stream");
		    reqEntity.setChunked(true); // Send in multiple parts if needed
		    httppost.setEntity(reqEntity);
		    HttpResponse response = httpclient.execute(httppost);
		    str += "waaaaaa";
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}  
			return str;
    }

    /**
     * on getting result
     */
    @Override
    protected void onPostExecute(String result) {
    	DrawView.show(result);
    }
}

