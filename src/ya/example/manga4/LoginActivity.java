package ya.example.manga4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends Activity {
	TextView name_tv,pass_tv,test_tv;
	EditText name_et,pass_et;
	Button decide_bt, howto_bt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		
		name_tv = new TextView(this);
		name_tv.setText("名前を入力してください");
		name_et = new EditText(this);
		
		pass_tv = new TextView(this);
		pass_tv.setText("パスワードを入力してください");
		pass_et = new EditText(this);
		
		decide_bt = new Button(this);
		decide_bt.setText("決定");
		
		howto_bt = new Button(this);
		howto_bt.setText("説明");
		
		test_tv = new TextView(this);
		test_tv.setText("");
		
		ll.addView(name_tv);
		ll.addView(name_et);
		
		ll.addView(pass_tv);
		ll.addView(pass_et);
		
		ll.addView(decide_bt);
		ll.addView(howto_bt);
		
		ll.addView(test_tv);
		
		decide_bt.setOnClickListener(new DecideClickListener());
		howto_bt.setOnClickListener(new HowtoClickListener());
		
	}
	
	class DecideClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			test_tv.setText("決定押した後の処理ここ");
			Intent intent;
			intent = new Intent(LoginActivity.this, DrawModeActivity.class );
			// 遷移先のアクティビティを起動させる
			startActivity( intent );
		}
	}
	
	class HowtoClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 自動生成されたメソッド・スタブ
			test_tv.setText("説明押した後の処理ここ");
			Intent intent2;
			intent2 = new Intent(LoginActivity.this, HowToActivity.class );
			// 遷移先のアクティビティを起動させる
			startActivity( intent2 );
		}
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
