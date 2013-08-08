package ya.example.manga4;

import ya.example.manga4.LoginActivity.HowtoClickListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class DrawActivity extends Activity {
	DrawView dv;
	AlertHelper al;
	ImageView[] setting_iv = new ImageView[4], 
				brush_iv = new ImageView[6],
				previous_iv = new ImageView[1];
	TextView tv,title_tv;
	Button bt,pre_bt;

	TableLayout brush_tl1;
	TableRow[] brush_tr1;

	LinearLayout ll;
	
	Bitmap precolor_bmp1;
	
	ImageView prevImg;

	private static final int SELECTCOLOR_ACTIVITY = 1001;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//騾包ｽｻ鬮ｱ�｢郢ｧ�ｵ郢ｧ�､郢ｧ�ｺ邵ｺ�ｮ陷ｿ髢�ｽｾ�ｽ		
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		
		Intent title_it = getIntent();
		String fname = title_it.getStringExtra("fname");
		if (fname != null)
		{
			prevImg = new ImageView(c);
			AsyncHttpDownload asyncHttpDownload = new AsyncHttpDownload(fname,prevImg, null);
			asyncHttpDownload.send();
		}

		//騾包ｽｻ鬮ｱ�｢郢ｧ�ｵ郢ｧ�､郢ｧ�ｺ邵ｺ�ｮ4陋ｻ�ｽ�ｽ1郢ｧ豁司ew邵ｺ�ｮ郢ｧ�ｵ郢ｧ�､郢ｧ�ｺ邵ｺ�ｨ邵ｺ蜉ｱ窶ｻ髫ｪ�ｭ陞ｳ螢ｹ笘�ｹｧ�ｽ		
		int w = display.getWidth();
		int h = display.getHeight();
		int width =w;
		int height = width * 3/4;
		LayoutParams params = new LinearLayout.LayoutParams(width, height);
		ll = new LinearLayout(this);
		
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		
		// title
		String title = title_it.getStringExtra("title");
		title_tv = new TextView(this);
		title_tv.setText(title);
		ll.addView(title_tv);
		

		dv = new DrawView(this);

		ll.addView(dv,params);		

		// 縺薙％縺九ｉ蜷�ｨｭ螳壹�隧ｳ邏ｰ縺ｸ






		Bitmap precolor_bmp = BitmapFactory.decodeResource(getResources(), R.drawable.color);
		Bitmap prebrush_bmp = BitmapFactory.decodeResource(getResources(), R.drawable.brush);
		Bitmap preeraser_bmp = BitmapFactory.decodeResource(getResources(), R.drawable.eraser);
		Bitmap prestamp_bmp = BitmapFactory.decodeResource(getResources(), R.drawable.stamp);

		Bitmap color_bmp = Bitmap.createScaledBitmap(precolor_bmp, w/4, w/4, false);
		Bitmap brush_bmp = Bitmap.createScaledBitmap(prebrush_bmp, w/4, w/4, false);
		Bitmap eraser_bmp = Bitmap.createScaledBitmap(preeraser_bmp, w/4, w/4, false);
		Bitmap stamp_bmp = Bitmap.createScaledBitmap(prestamp_bmp, w/4, w/4, false);

		TableLayout setting_tl = new TableLayout(this);
		TableRow[] setting_tr = new TableRow[1];

		setting_iv[0] = new ImageView(this);
		setting_iv[0].setImageBitmap(color_bmp);
		setting_iv[1] = new ImageView(this);
		setting_iv[1].setImageBitmap(brush_bmp);
		setting_iv[2] = new ImageView(this);
		setting_iv[2].setImageBitmap(eraser_bmp);
		setting_iv[3] = new ImageView(this);
		setting_iv[3].setImageBitmap(stamp_bmp);

		setting_tr[0] = new TableRow(this);

		setting_tr[0].addView(setting_iv[0]);
		setting_tr[0].addView(setting_iv[1]);
		setting_tr[0].addView(setting_iv[2]);
		setting_tr[0].addView(setting_iv[3]);


		setting_tl.addView(setting_tr[0]);
		ll.addView(setting_tl);






		Bitmap b_2 = BitmapFactory.decodeResource(getResources(), R.drawable.b_2);
		Bitmap b_22 = BitmapFactory.decodeResource(getResources(), R.drawable.b_22);
		Bitmap b_42 = BitmapFactory.decodeResource(getResources(), R.drawable.b_42);
		Bitmap b_62 = BitmapFactory.decodeResource(getResources(), R.drawable.b_62);
		Bitmap b_82 = BitmapFactory.decodeResource(getResources(), R.drawable.b_82);
		Bitmap b_100 = BitmapFactory.decodeResource(getResources(), R.drawable.b_100);

		Bitmap b_2_bmp = Bitmap.createScaledBitmap(b_2, w/6, w/6, false);
		Bitmap b_22_bmp = Bitmap.createScaledBitmap(b_22, w/6, w/6, false);
		Bitmap b_42_bmp = Bitmap.createScaledBitmap(b_42, w/6, w/6, false);
		Bitmap b_62_bmp = Bitmap.createScaledBitmap(b_62, w/6, w/6, false);
		Bitmap b_82_bmp = Bitmap.createScaledBitmap(b_82, w/6, w/6, false);
		Bitmap b_100_bmp = Bitmap.createScaledBitmap(b_100, w/6, w/6, false);

		brush_tl1 = new TableLayout(this);
		brush_tr1 = new TableRow[1];

		brush_iv[0] = new ImageView(this);
		brush_iv[0].setImageBitmap(b_2_bmp);
		brush_iv[1] = new ImageView(this);
		brush_iv[1].setImageBitmap(b_22_bmp);
		brush_iv[2] = new ImageView(this);
		brush_iv[2].setImageBitmap(b_42_bmp);
		brush_iv[3] = new ImageView(this);
		brush_iv[3].setImageBitmap(b_62_bmp);
		brush_iv[4] = new ImageView(this);
		brush_iv[4].setImageBitmap(b_82_bmp);
		brush_iv[5] = new ImageView(this);
		brush_iv[5].setImageBitmap(b_100_bmp);

		brush_tr1[0] = new TableRow(this);

		brush_tr1[0].addView(brush_iv[0]);
		brush_tr1[0].addView(brush_iv[1]);
		brush_tr1[0].addView(brush_iv[2]);
		brush_tr1[0].addView(brush_iv[3]);
		brush_tr1[0].addView(brush_iv[4]);
		brush_tr1[0].addView(brush_iv[5]);


		brush_tl1.addView(brush_tr1[0]);
		ll.addView(brush_tl1);
		brush_tl1.setVisibility(View.GONE);



		//tv = new TextView(this);
		//tv.setText("縺薙％");
		//ll.addView(tv);

		bt = new Button(this);
		bt.setText("決定");
		ll.addView(bt);
		
		pre_bt = new Button(this);
		pre_bt.setText("前の画像を見る");
		ll.addView(pre_bt);
		
		
		bt.setOnClickListener(new BtClickListener());
		pre_bt.setOnClickListener(new PrebtClickListener());
		
		setting_iv[0].setOnClickListener(new ColorClickListener());
		setting_iv[1].setOnClickListener(new BrushClickListener());
		setting_iv[2].setOnClickListener(new EraserClickListener());
		setting_iv[3].setOnClickListener(new StampClickListener());

		brush_iv[0].setOnClickListener(new B_2ClickListener());
		brush_iv[1].setOnClickListener(new B_22ClickListener());
		brush_iv[2].setOnClickListener(new B_42ClickListener());
		brush_iv[3].setOnClickListener(new B_62ClickListener());
		brush_iv[4].setOnClickListener(new B_82ClickListener());
		brush_iv[5].setOnClickListener(new B_100ClickListener());

		brush_tl1.setOnClickListener(new TlClickListener());


		//setContentView(new DrawView(this));
	}
	private LinearLayout.LayoutParams createParam(int w, int h){
		return new LinearLayout.LayoutParams(w, h);
	}
	
	/** 繝｡繝九Η繝ｼ縺ｮ逕滓�繧､繝吶Φ繝�*/
	 @Override
	 public boolean onCreateOptionsMenu(Menu menu) {
	 super.onCreateOptionsMenu(menu);
	 getMenuInflater().inflate(R.menu.menu,menu);  
	 return true;
	 }
	 /** 繝｡繝九Η繝ｼ縺後け繝ｪ繝�け縺輔ｌ縺滓凾縺ｮ繧､繝吶Φ繝�*/
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {
	 switch ( item.getItemId() ) {
	 case R.id.item1:
	 dv.clearDrawList(); 
	 break;
	 case R.id.item2:
	 dv.saveToFile();
	 break;
	 case R.id.item3:
	 finish();
	 break;
	 }
	 return true;
	 }

	class ColorClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			//tv.setText("color");
			Intent intent = new Intent(DrawActivity.this, SelectColorActivity.class);
			// 繧ｵ繝也判髱｢縺ｮ蜻ｼ縺ｳ蜃ｺ縺�			
			startActivityForResult(intent, SELECTCOLOR_ACTIVITY);
		}

	}
	class BrushClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			//tv.setText("brush");
			if(brush_tl1.getVisibility() == 0){
				brush_tl1.setVisibility(View.GONE);
			}else{
				brush_tl1.setVisibility(View.VISIBLE);
			}

			//ll.addView(brush_tl1);

		}

	}
	class EraserClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			//tv.setText("eraser");
		}

	}
	class StampClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			//tv.setText("stamp");
		}

	}

	class BtClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			dv.saveToFile();
			Intent intent2;
			intent2 = new Intent(DrawActivity.this, TopActivity.class );
			// 驕ｷ遘ｻ蜈医�繧｢繧ｯ繝�ぅ繝薙ユ繧｣繧定ｵｷ蜍輔＆縺帙ｋ
			startActivity( intent2 );

		}
	}
	Context c = this;
	class PrebtClickListener implements OnClickListener{
		DialogInterface.OnClickListener listenerYes = new DialogInterface.OnClickListener(){  
				public void onClick(DialogInterface dialog, int which) {  
					 //TODO 自動生成されたメソッド・スタブ
					Toast.makeText(DrawActivity.this, "Yes", Toast.LENGTH_LONG).show();
					}

			};

			@Override
			public void onClick(View v) {
				if (prevImg != null)
				{
		    		//precolor_bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.color);
					AlertHelper.showPreImg(c, "", listenerYes, ((BitmapDrawable)prevImg.getDrawable()).getBitmap());
				}

				
				
			}
			
	}
	

	class TlClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			System.out.println("v縺ｯ��+v");
			System.out.println(v.getId());
		}

	}

	class B_2ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			dv.haba = 2;
		}

	}

	class B_22ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			dv.haba = 22;
		}

	}
	class B_42ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			dv.haba = 42;
		}

	}
	class B_62ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			dv.haba = 62;
		}

	}
	class B_82ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			dv.haba = 82;
		}

	}
	class B_100ClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			dv.haba = 100;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == SELECTCOLOR_ACTIVITY) {
	if(resultCode == RESULT_OK){
		//dv.color_array = data.getStringArrayExtra("color");
		//System.out.println(data.getStringArray("color"));
		//Object[] obj = (Object[])data.getSerializableExtra("color");
		//String[] obj;
		//obj = data.getStringArrayExtra("color");
		// Object[]として取り出す
		Object[] obj = (Object[])data.getSerializableExtra("color");

		// データの配列を生成する
		String[] data_a = new String[obj.length];

		// 配列に詰めなおす
		for(int i=0; i<obj.length; i++)
		{
		  data_a[i] = (String)obj[i];
		}
		//dv.color_array[0] = (String) obj[0];
		//dv.color_array[1] = (String) obj[1];
		//dv.color_array[2] = (String) obj[2];
		dv.color_array[0] = data_a[0];
		dv.color_array[1] = data_a[1];
		dv.color_array[2] = data_a[2];
		
		System.out.println("0="+dv.color_array[0]+",1="+dv.color_array[1]+",2="+dv.color_array[2]);
		System.out.println("0="+data_a[0]+",1="+data_a[1]+",2="+data_a[2]);
		
	}
		}
	}
}
