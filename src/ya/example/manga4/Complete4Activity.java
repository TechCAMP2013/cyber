package ya.example.manga4;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Complete4Activity extends Activity {

  public class ImageAdapter extends BaseAdapter {
	    private Context mContext;

	    public ImageAdapter(Context c) {
	        mContext = c; 
	    }

	    public int getCount() {
	        return mThumbIds.length;
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

	        imageView.setImageResource(mThumbIds[position]);
	        return imageView;
	    }

	    // references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	              R.drawable.sample1, R.drawable.sample2,
	               R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	              R.drawable.sample1, R.drawable.sample2,
	               R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	              R.drawable.sample1, R.drawable.sample2,
	               R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	              R.drawable.sample1, R.drawable.sample2,
	               R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	             R.drawable.sample1, R.drawable.sample2,
	              R.drawable.sample1, R.drawable.sample2,
	               R.drawable.sample1, R.drawable.sample2,
	            
	           
	           
	            
	    };
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_complete4);
	    Button button = (Button) findViewById(R.id.button1);
		// 繝懊ち繝ｳ繧ｪ繝悶ず繧ｧ繧ｯ繝医↓繧ｯ繝ｪ繝�け繝ｪ繧ｹ繝翫�險ｭ螳�	    button.setOnClickListener(new ButtonClickListener());
	    button.setOnClickListener(new ButtonClickListener());

	    GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(Complete4Activity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.complete4, menu);
		return true;
	}
	class ButtonClickListener implements OnClickListener{
		public void onClick(View v){
			Intent intent =new Intent(Complete4Activity.this,TopActivity.class);
			startActivity(intent);
		
	}
	
	
	
	
	}
}
