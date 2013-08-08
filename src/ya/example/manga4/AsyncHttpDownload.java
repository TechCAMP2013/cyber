package ya.example.manga4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

public class AsyncHttpDownload extends AsyncTask<String, Void, Bitmap> {
    
    String url;
    ImageView img;
    HttpActivity activity;

    /**
     * constructor
     */
    public AsyncHttpDownload(String url, ImageView img, HttpActivity activity) {
        this.img = img;
        this.url = "http://133.242.188.195:8080/cyber4koma_images/" + url;
        this.activity = activity;
    }
    
    public void send()
    {
    	this.execute(url);
    }

    /**
     * background
     */
    @Override
    protected Bitmap  doInBackground(String... params) {
    	String urldisplay = params[0];
        Bitmap mIcon11 = null;
        try {
            mIcon11 = BitmapFactory.decodeStream(new URL(urldisplay).openConnection().getInputStream());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return mIcon11;
    }

    /**
     * on getting result
     */
    @Override
    protected void onPostExecute(Bitmap result) {
    	img.setImageBitmap(result);
    	if (activity != null)
    	{
    		((MyGalleryActivity)activity).receiveImage(img);
    	}
    }
}

