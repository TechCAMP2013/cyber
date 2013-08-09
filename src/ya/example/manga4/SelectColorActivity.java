package ya.example.manga4;

import ya.example.manga4.Complete4Activity.ButtonClickListener;
import ya.example.manga4.Complete4Activity.ImageAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SelectColorActivity extends Activity {

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
				R.drawable.red, R.drawable.yellow,
				R.drawable.lime, R.drawable.aqua,
				R.drawable.blue, R.drawable.pink,
				R.drawable.maroon, R.drawable.olive,
				R.drawable.green, R.drawable.teal,
				R.drawable.navy, R.drawable.purple,
		};
	}

	protected static final Intent Intent = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_color);
		//setContentView(R.layout.main);
		Button button = (Button) findViewById(R.id.button1);
		// ボタンオブジェクトにクリックリスナー設定
		//button.setOnClickListener(new ButtonClickListener());

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Toast.makeText(SelectColorActivity.this, "" + position, Toast.LENGTH_SHORT).show();
				Intent data = new Intent();
				String colorArray[] = {"0","0","0"};
				switch(position){
				case 0:
					colorArray = new String[3];
					colorArray[0] = "0";
					colorArray[1] = "0";
					colorArray[2] = "0";
					data.putExtra("color", colorArray);
					break;
				case 1:
					colorArray = new String[3];
					colorArray[0] = "128";
					colorArray[1] = "128";
					colorArray[2] = "128";
					data.putExtra("color", colorArray);
					break;
				case 2:
					colorArray = new String[3];
					colorArray[0] = "192";
					colorArray[1] = "192";
					colorArray[2] = "192";
					data.putExtra("color", colorArray);
					break;
				case 3:
					colorArray = new String[3];
					colorArray[0] = "255";
					colorArray[1] = "255";
					colorArray[2] = "255";
					data.putExtra("color", colorArray);
					break;
				case 4:
					colorArray = new String[3];
					colorArray[0] = "255";
					colorArray[1] = "0";
					colorArray[2] = "0";
					data.putExtra("color", colorArray);
					break;
				case 5:
					colorArray = new String[3];
					colorArray[0] = "255";
					colorArray[1] = "255";
					colorArray[2] = "0";
					data.putExtra("color", colorArray);
					break;
				case 6:
					colorArray = new String[3];
					colorArray[0] = "0";
					colorArray[1] = "255";
					colorArray[2] = "0";
					data.putExtra("color", colorArray);
					break;
				case 7:
					colorArray = new String[3];
					colorArray[0] = "0";
					colorArray[1] = "255";
					colorArray[2] = "255";
					data.putExtra("color", colorArray);
					break;
				case 8:
					colorArray = new String[3];
					colorArray[0] = "0";
					colorArray[1] = "0";
					colorArray[2] = "255";
					data.putExtra("color", colorArray);
					break;
				case 9:
					colorArray = new String[3];
					colorArray[0] = "255";
					colorArray[1] = "0";
					colorArray[2] = "255";
					data.putExtra("color", colorArray);
					break;
				case 10:
					colorArray = new String[3];
					colorArray[0] = "128";
					colorArray[1] = "0";
					colorArray[2] = "0";
					data.putExtra("color", colorArray);
					break;
				case 11:
					colorArray = new String[3];
					colorArray[0] = "128";
					colorArray[1] = "128";
					colorArray[2] = "0";
					data.putExtra("color", colorArray);
					break;
				case 12:
					colorArray = new String[3];
					colorArray[0] = "0";
					colorArray[1] = "128";
					colorArray[2] = "0";
					data.putExtra("color", colorArray);
					break;
				case 13:
					colorArray = new String[3];
					colorArray[0] = "0";
					colorArray[1] = "128";
					colorArray[2] = "128";
					data.putExtra("color", colorArray);

					break;
				case 14:
					colorArray = new String[3];
					colorArray[0] = "0";
					colorArray[1] = "0";
					colorArray[2] = "128";
					data.putExtra("color", colorArray);
					break;
				case 15:
					colorArray = new String[3];
					colorArray[0] = "128";
					colorArray[1] = "0";
					colorArray[2] = "128";
					data.putExtra("color", colorArray);
					break;
				}
				System.out.println("selectのほう"+colorArray);
				setResult(RESULT_OK, data);
				finish();
			}
		});
	}

	class ButtonClickListener implements OnClickListener{
		public void onClick(View v){
			Intent intent =new Intent(SelectColorActivity.this,TopActivity.class);
			startActivity(intent);

		}




	}

}



