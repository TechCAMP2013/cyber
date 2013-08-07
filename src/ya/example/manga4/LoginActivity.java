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
		name_tv.setText("ユーザ名を入力してください");
		name_et = new EditText(this);
		
		pass_tv = new TextView(this);
		pass_tv.setText("パスワードを入力してください");
		pass_et = new EditText(this);
		
		decide_bt = new Button(this);
		decide_bt.setText("決定");
		
		howto_bt = new Button(this);
		howto_bt.setText("使い方");
		
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
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			test_tv.setText("豎ｺ螳壽款縺励◆蠕後�蜃ｦ逅�％縺�");
			Intent intent;
			intent = new Intent(LoginActivity.this, DrawModeActivity.class );
			// 驕ｷ遘ｻ蜈医�繧｢繧ｯ繝�ぅ繝薙ユ繧｣繧定ｵｷ蜍輔＆縺帙ｋ
			startActivity( intent );
		}
	}
	
	class HowtoClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			test_tv.setText("隱ｬ譏取款縺励◆蠕後�蜃ｦ逅�％縺�");
			Intent intent2;
			intent2 = new Intent(LoginActivity.this, DrawModeActivity.class );
			// 驕ｷ遘ｻ蜈医�繧｢繧ｯ繝�ぅ繝薙ユ繧｣繧定ｵｷ蜍輔＆縺帙ｋ
			startActivity( intent2 );
		}
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
