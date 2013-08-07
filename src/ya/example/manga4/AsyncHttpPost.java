package ya.example.manga4;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
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

public class AsyncHttpPost extends AsyncTask<String, String, String> {
    private Map<String, Object> data = null;// post data
    private HttpActivity activity;

    /**
     * constructor
     */
    public AsyncHttpPost(HashMap<String, Object> data, HttpActivity activity) {
        this.data = data;
        this.activity = activity;
    }
    
    public void send()
    {
    	this.execute("http://133.242.188.195:8080/cyber4koma/query");
    }

    /**
     * background
     */
    @Override
    protected String doInBackground(String... params) {
        byte[] result = null;
        String str = "";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(params[0]);// in this case, params[0] is URL
        try {
            // set up post data
        	JSONObject json = new JSONObject();
            Iterator<String> it = data.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                json.put(key, data.get(key));
            }

            StringEntity se = new StringEntity( json.toString());  
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            post.setEntity(se);
            HttpResponse response = client.execute(post);
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpURLConnection.HTTP_OK){
                result = EntityUtils.toByteArray(response.getEntity());
                str = new String(result, "UTF-8");
            }
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
        }
        return str;
    }

    /**
     * on getting result
     */
    @Override
    protected void onPostExecute(String result) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	try {
    	    JSONObject jsonObject = new JSONObject(result);
    	    Iterator keys = jsonObject.keys();
    	    while (keys.hasNext()) {
    	        String key = (String) keys.next();
    	        map.put(key, jsonObject.getString(key));
    	    }
        	activity.receiveMessage(map);
    	} catch (JSONException e) {
    	    e.printStackTrace();
    	    map.put("result", result.toString());
    	    map.put("test", "test");
    	    activity.receiveMessage(map);
    	}
    }
}

