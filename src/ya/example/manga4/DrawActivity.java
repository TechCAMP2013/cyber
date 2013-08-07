package ya.example.manga4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;

public class DrawActivity extends Activity {
	DrawView dv;
	ImageView[] iv = new ImageView[4];
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//逕ｻ髱｢繧ｵ繧､繧ｺ縺ｮ蜿門ｾ�		
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		 
		//逕ｻ髱｢繧ｵ繧､繧ｺ縺ｮ4蛻��1繧歎iew縺ｮ繧ｵ繧､繧ｺ縺ｨ縺励※險ｭ螳壹☆繧�		
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
		ll.addView(setting_tl,createParam(4*w,w*4));
		

		//setContentView(new DrawView(this));
	}
	private LinearLayout.LayoutParams createParam(int w, int h){
        return new LinearLayout.LayoutParams(w, h);
    }
}
