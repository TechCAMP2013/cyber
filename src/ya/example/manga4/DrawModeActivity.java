package ya.example.manga4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DrawModeActivity extends Activity {
	TextView top_tv;
	Button new_bt;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		
		top_tv = new TextView(this);
		top_tv.setText("どの続きを描く");
		
		ll.addView(top_tv);
		
		new_bt = new Button(this);
		new_bt.setText("新規作成");
		
		ll.addView(new_bt);
		
		new_bt.setOnClickListener(new NewClickListener());
		
	}
	
	class NewClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			Intent intent;
			intent = new Intent(DrawModeActivity.this, DecideTitleActivity.class );
			// 遷移先のアクティビティを起動させる
			startActivity( intent );
		}
	}
	

}
