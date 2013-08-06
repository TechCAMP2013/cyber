package ya.example.manga4;

import ya.example.manga4.LoginActivity.HowtoClickListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DrawActivity extends Activity {
	DrawView dv;
	ImageView[] setting_iv = new ImageView[4], 
			brush_iv = new ImageView[6];
	TextView tv;
	Button bt;
	
	TableLayout brush_tl1;
	TableRow[] brush_tr1;
	
	LinearLayout ll;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//画面サイズの取得
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		 
		//画面サイズの4分の1をViewのサイズとして設定する
		int w = display.getWidth();
		int h = display.getHeight();
		int width =w;
		int height = width * 3/4;
		LayoutParams params = new LinearLayout.LayoutParams(width, height);
		ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		
		dv = new DrawView(this);
		
		ll.addView(dv,params);		
		
		// ここから各設定の詳細へ
		
		
		

		
		
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
		Bitmap b_6 = BitmapFactory.decodeResource(getResources(), R.drawable.b_6);
		Bitmap b_10 = BitmapFactory.decodeResource(getResources(), R.drawable.b_10);
		Bitmap b_14 = BitmapFactory.decodeResource(getResources(), R.drawable.b_14);
		Bitmap b_18 = BitmapFactory.decodeResource(getResources(), R.drawable.b_18);
		Bitmap b_22 = BitmapFactory.decodeResource(getResources(), R.drawable.b_22);
		
		Bitmap b_2_bmp = Bitmap.createScaledBitmap(b_2, w/6, w/6, false);
		Bitmap b_6_bmp = Bitmap.createScaledBitmap(b_6, w/6, w/6, false);
		Bitmap b_10_bmp = Bitmap.createScaledBitmap(b_10, w/6, w/6, false);
		Bitmap b_14_bmp = Bitmap.createScaledBitmap(b_14, w/6, w/6, false);
		Bitmap b_18_bmp = Bitmap.createScaledBitmap(b_18, w/6, w/6, false);
		Bitmap b_22_bmp = Bitmap.createScaledBitmap(b_22, w/6, w/6, false);
		
		brush_tl1 = new TableLayout(this);
		brush_tr1 = new TableRow[1];
		
		brush_iv[0] = new ImageView(this);
		brush_iv[0].setImageBitmap(b_2_bmp);
		brush_iv[1] = new ImageView(this);
		brush_iv[1].setImageBitmap(b_6_bmp);
		brush_iv[2] = new ImageView(this);
		brush_iv[2].setImageBitmap(b_10_bmp);
		brush_iv[3] = new ImageView(this);
		brush_iv[3].setImageBitmap(b_14_bmp);
		brush_iv[4] = new ImageView(this);
		brush_iv[4].setImageBitmap(b_18_bmp);
		brush_iv[5] = new ImageView(this);
		brush_iv[5].setImageBitmap(b_22_bmp);
		
		brush_tr1[0] = new TableRow(this);
		
		brush_tr1[0].addView(brush_iv[0]);
		brush_tr1[0].addView(brush_iv[1]);
		brush_tr1[0].addView(brush_iv[2]);
		brush_tr1[0].addView(brush_iv[3]);
		brush_tr1[0].addView(brush_iv[4]);
		brush_tr1[0].addView(brush_iv[5]);
		

		brush_tl1.addView(brush_tr1[0]);
		//ll.addView(brush_tl1);
		
		
		
		
		//tv = new TextView(this);
		//tv.setText("ここ");
		//ll.addView(tv);
		
		bt = new Button(this);
		bt.setText("送信");
		ll.addView(bt);
		
		bt.setOnClickListener(new BtClickListener());
		setting_iv[0].setOnClickListener(new ColorClickListener());
		setting_iv[1].setOnClickListener(new BrushClickListener());
		setting_iv[2].setOnClickListener(new EraserClickListener());
		setting_iv[3].setOnClickListener(new StampClickListener());
		
		
		

		//setContentView(new DrawView(this));
	}
	private LinearLayout.LayoutParams createParam(int w, int h){
        return new LinearLayout.LayoutParams(w, h);
    }
	
	class ColorClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			//tv.setText("color");
		}

	}
	class BrushClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			//tv.setText("brush");
			ll.addView(brush_tl1);
			
		}

	}
	class EraserClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			//tv.setText("eraser");
		}

	}
	class StampClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			//tv.setText("stamp");
		}

	}
	
	class BtClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			Intent intent2;
			intent2 = new Intent(DrawActivity.this, TopActivity.class );
			// 遷移先のアクティビティを起動させる
			startActivity( intent2 );
			
		}
		
	}
}
