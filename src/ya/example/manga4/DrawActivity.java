package ya.example.manga4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class DrawActivity extends Activity {
	DrawView dv;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//画面サイズの取得
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		 
		//画面サイズの4分の1をViewのサイズとして設定する
		int width =display.getWidth();
		int height = width * 3/4;
		LayoutParams params = new LinearLayout.LayoutParams(width, height);
		LinearLayout ll = new LinearLayout(this);
		setContentView(ll);
		
		dv = new DrawView(this);
		
		ll.addView(dv,params);
		

		//setContentView(new DrawView(this));
	}
}
