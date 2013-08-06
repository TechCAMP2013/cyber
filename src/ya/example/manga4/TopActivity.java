package ya.example.manga4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class TopActivity extends Activity {

  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top);
		

		// ボタンオブジェクト取得
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		Button button3 = (Button) findViewById(R.id.button3);
		
		// ボタンオブジェクトにクリックリスナー設定
		button1.setOnClickListener(new Button1ClickListener());
		button2.setOnClickListener(new Button2ClickListener());
		button3.setOnClickListener(new Button3ClickListener());
	}
	class Button1ClickListener implements OnClickListener{
		public void onClick(View v){
			Intent intent =new Intent(TopActivity.this,My4.class);
			startActivity(intent);
		}
	}
	class Button2ClickListener implements OnClickListener{
		public void onClick(View v){
			Intent intent =new Intent(TopActivity.this,Complete4Activity.class);
			startActivity(intent);
		}
	}
	class Button3ClickListener implements OnClickListener{
		public void onClick(View v){
			Intent intent =new Intent(TopActivity.this,DrawModeActivity.class);
			startActivity(intent);
		}
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.top, menu);
		return true;
	}
	
	

}
