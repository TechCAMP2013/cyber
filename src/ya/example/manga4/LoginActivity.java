package ya.example.manga4;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends HttpActivity {
	TextView name_tv,pass_tv,test_tv;
	EditText name_et,pass_et;
	Button decide_bt, howto_bt;
	HttpActivity activity = this;
	ImageView iv;
	
	public void receiveMessage(Map<String, Object> map)
	{
		if ("login".equals(map.get("id")))
		{
			if (Integer.parseInt((String)map.get("status")) == 1)
			{
				test_tv.setText("");
				Intent intent;
				intent = new Intent(LoginActivity.this, DrawModeActivity.class );
				// 驕ｷ遘ｻ蜈医�繧｢繧ｯ繝�ぅ繝薙ユ繧｣繧定ｵｷ蜍輔＆縺帙ｋ
				startActivity( intent );
			}
			else
			{
				test_tv.setText("違うだろうが！");
			}
		}
		else
		{
			test_tv.setText("エラー");
		}
	
		//test_tv.setText("result: " + map.toString());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		setContentView(ll);
		
		name_tv = new TextView(this);
		name_tv.setText("蜷榊燕繧貞�蜉帙＠縺ｦ縺上□縺輔＞");
		name_et = new EditText(this);
		
		pass_tv = new TextView(this);
		pass_tv.setText("繝代せ繝ｯ繝ｼ繝峨ｒ蜈･蜉帙＠縺ｦ縺上□縺輔＞");
		pass_et = new EditText(this);
		
		decide_bt = new Button(this);
		decide_bt.setText("豎ｺ螳�");
		
		howto_bt = new Button(this);
		howto_bt.setText("隱ｬ譏�");
		
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
		
		iv = new ImageView(this);
		AsyncHttpDownload asyncHttpDownload = new AsyncHttpDownload("a.jpg",iv);
		asyncHttpDownload.send();
		ll.addView(iv);

		
		
		
		
		
		
		
	}
	
	class DecideClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO 閾ｪ蜍慕函謌舌＆繧後◆繝｡繧ｽ繝�ラ繝ｻ繧ｹ繧ｿ繝�			
			test_tv.setText("ログインしています・・・");
			
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("id","login");
			data.put("name", name_et.getText().toString());
			data.put("pass", pass_et.getText().toString());
			AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data, activity);
			asyncHttpPost.send();
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
