package ya.example.manga4;

import ya.example.manga4.SelectColorActivity.ImageAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawModeActivity extends Activity {
	TextView top_tv;
	Button new_bt;
	
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
				R.drawable.black, R.drawable.gray,
				R.drawable.silver, R.drawable.white,
		};
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(R.layout.activity_draw_mode);
		
		TextView text_view_next = (TextView) findViewById(R.id.textViewNext);
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		
		gridview.setAdapter(new ImageAdapter(this));
		Button new_bt = (Button) findViewById(R.id.new_button);
		
		//ll.addView(gridview);
		
		//top_tv = new TextView(this);
		//top_tv.setText("縺ｩ縺ｮ邯壹″繧呈緒縺�");
		//top_tv = new TextView(this);
		//top_tv.setText("続きを書きたいコマを選択してください");
		
		//ll.addView(top_tv);
		
		
		//ll.addView(new_bt);
		
		new_bt.setOnClickListener(new NewClickListener());
		
	}
	
	class NewClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 髢ｾ�ｪ陷肴�蜃ｽ隰瑚���ｹｧ蠕娯螺郢晢ｽ｡郢ｧ�ｽ郢晢ｿｽ繝ｩ郢晢ｽｻ郢ｧ�ｹ郢ｧ�ｿ郢晢ｿｽ			
			Intent intent;
			intent = new Intent(DrawModeActivity.this, DecideTitleActivity.class );
			// 鬩包ｽｷ驕假ｽｻ陷亥現�ｽ郢ｧ�｢郢ｧ�ｯ郢晢ｿｽ縺�ｹ晁侭繝ｦ郢ｧ�｣郢ｧ螳夲ｽｵ�ｷ陷崎ｼ費ｼ�ｸｺ蟶呻ｽ�			
			startActivity( intent );
		}
	}
	

}
