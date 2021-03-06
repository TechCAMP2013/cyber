package ya.example.manga4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ya.example.manga4.DrawModeActivity.ImageAdapter;
import ya.example.manga4.DrawModeActivity.NewClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;

public class PreviousKomaActivity extends HttpActivity {
	

    private ImageView[] img4koma = new ImageView[1000];
    List<Map<String,Object>> info4koma = new ArrayList<Map<String,Object>>();
    
    LinearLayout ll; 
    HttpActivity activity = this;
    
    Intent intent;
    
    static ImageView[] images = new ImageView[4];
    
    public void receiveImage(ImageView img)
    {
    	System.out.println("DGADSGJGJAJ");
    }
    
    public void receiveMessage(Map<String, Object> map)    //this
	{
    	System.out.println(map.toString());
		if ("everyoneGallery".equals(map.get("id")))
		{
		        
		        
		        try{
					Map<String, Object> mapKoma = new HashMap<String, Object>();
					JSONArray jsonArray = new JSONArray((String)map.get("koma"));
					System.out.println("jsonArray: " + jsonArray.toString());
					for(int i = 0; i < jsonArray.length(); i++)
					{
						JSONObject jsonObject = jsonArray.getJSONObject(i);
						System.out.println("jsonObject: " + jsonObject.toString());
						
						Map<String, Object> m = new HashMap<String, Object>();
						Iterator keys = jsonObject.keys();
			    	    while (keys.hasNext()) {
			    	        String key = (String) keys.next();
			    	        m.put(key, jsonObject.getString(key));
			    	    }
			    	    
			    	    info4koma.add(m);
			    	    
			    	    System.out.println("fname: " + m.get("fname"));
			    	    
			    	    ImageView iv = new ImageView(this);
			    	    AbsListView.LayoutParams params = new AbsListView.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			    	    iv.setLayoutParams(params);
			    	    //iv.setScaleType(ScaleType.FIT_CENTER);
			    	    iv.setAdjustViewBounds(true);
			    		AsyncHttpDownload asyncHttpDownload = new AsyncHttpDownload((String)m.get("fname"),iv, null);
			    		asyncHttpDownload.send();
			    		
			    		img4koma[i] = iv;
			    	    
					}
					
					GridView gridview = (GridView) findViewById(R.id.gridview);
					
					//test_iv = (ImageView) findViewById(R.id.textViewNext);
					
					gridview.setAdapter(new ImageAdapter(this));

					
					//ll.addView(gridview);
					
					//top_tv = new TextView(this);
					//top_tv.setText("縺ｩ縺ｮ邯壹″繧呈緒縺�");
					//top_tv = new TextView(this);
					//top_tv.setText("続きを書きたいコマを選択してください");
					
					//ll.addView(top_tv);
					
					
					//ll.addView(new_bt);
				
					
					final Context c;
					c = this;
					gridview.setOnItemClickListener(new OnItemClickListener() {
						public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

							HashMap<String, Object> data = new HashMap<String, Object>();		//koko
							data.put("id","manga");
							data.put("manga_id", (String)info4koma.get(position).get("manga_id"));					
							AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data, activity);
							asyncHttpPost.send();
							
							
							intent = new Intent(PreviousKomaActivity.this, Show4KomaActivity.class );
							intent.putExtra("title",(String)info4koma.get(position).get("title"));
							
							
						}
					});

					
				} catch (JSONException e) {
		    	    e.printStackTrace();
		    	}

		}
	    	
		else if ("manga".equals(map.get("id")))
			{
				System.out.println(map.toString());
			        
			        
			        try{
						Map<String, Object> mapKoma = new HashMap<String, Object>();
						JSONArray jsonArray = new JSONArray((String)map.get("koma"));
						System.out.println("jsonArray: " + jsonArray.toString());
						for(int i = 0; i < jsonArray.length(); i++)
						{
							String fname = jsonArray.getString(i);
							System.out.println("fname: " + fname);
							

				    	    ImageView iv = new ImageView(this);
				    		AsyncHttpDownload asyncHttpDownload = new AsyncHttpDownload(fname,iv, null);
				    		asyncHttpDownload.send();
				    		
				    		MyGalleryActivity.images[i] = iv;
					        
						}
						
						startActivity( intent );

						
					} catch (JSONException e) {
			    	    e.printStackTrace();
			    	}

			}
		else
		{

		}

	}
    
    public class ImageAdapter extends BaseAdapter {
		private Context mContext;

		public ImageAdapter(Context c) {
			mContext = c; 
		}

		public int getCount() {
			return img4koma.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		// create a new ImageView for each item referenced by the Adapter
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {  // if it's not recycled, initialize some attributes
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}
			
			//imageView.setImageResource(mThumbIds[position]);
			if (img4koma[position] != null) imageView = img4koma[position];
			return imageView;
		}
		
		// references to our images

	}
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_gallery);
		ll = (LinearLayout) findViewById(R.id.drow_mode_ll);
      
        HashMap<String, Object> data = new HashMap<String, Object>();		//koko
		data.put("id","everyoneGallery");					
		AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data, this);
		asyncHttpPost.send();

        

    }

  
}


		
		
	
	
	
	


