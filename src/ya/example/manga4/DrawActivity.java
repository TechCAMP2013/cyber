package ya.example.manga4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DrawActivity extends Activity {
	DrawView dv;
	ImageView[] iv = new ImageView[4];
	TextView tv;
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
		LinearLayout ll = new LinearLayout(this);
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
		
		iv[0] = new ImageView(this);
		iv[0].setImageBitmap(color_bmp);
		iv[1] = new ImageView(this);
		iv[1].setImageBitmap(brush_bmp);
		iv[2] = new ImageView(this);
		iv[2].setImageBitmap(eraser_bmp);
		iv[3] = new ImageView(this);
		iv[3].setImageBitmap(stamp_bmp);
		
		setting_tr[0] = new TableRow(this);
		
		setting_tr[0].addView(iv[0]);
		setting_tr[0].addView(iv[1]);
		setting_tr[0].addView(iv[2]);
		setting_tr[0].addView(iv[3]);
		

		setting_tl.addView(setting_tr[0]);
		ll.addView(setting_tl);
		
		
		iv[0].setOnClickListener(new ColorClickListener());
		iv[1].setOnClickListener(new BrushClickListener());
		iv[2].setOnClickListener(new EraserClickListener());
		iv[3].setOnClickListener(new StampClickListener());
		
		//デバッグ
		tv = new TextView(this);
		tv.setText("ここ");
		ll.addView(tv);
		
		

		//setContentView(new DrawView(this));
	}
	private LinearLayout.LayoutParams createParam(int w, int h){
        return new LinearLayout.LayoutParams(w, h);
    }
	
	class ColorClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			tv.setText("color");
		}

	}
	class BrushClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			tv.setText("brush");
			
		}

	}
	class EraserClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			tv.setText("eraser");
		}

	}
	class StampClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			tv.setText("stamp");
			dv.haba = 20;
		}

	}
}
