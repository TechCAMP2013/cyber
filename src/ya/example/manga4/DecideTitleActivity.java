package ya.example.manga4;import java.util.HashMap;import java.util.Map;import ya.example.manga4.DrawModeActivity.NewClickListener;import android.app.Activity;import android.content.Intent;import android.os.Bundle;import android.view.View;import android.view.View.OnClickListener;import android.widget.Button;import android.widget.EditText;import android.widget.LinearLayout;import android.widget.TextView;public class DecideTitleActivity extends HttpActivity {TextView title_tv;EditText title_et;Button decide_bt;HttpActivity activity = this;Intent intent;public void receiveMessage(Map<String, Object> map) //this{if ("drawStartNew".equals(map.get("id"))){startActivity( intent );}else{}//test_tv.setText("result: " + map.toString());}protected void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);super.onCreate(savedInstanceState);LinearLayout ll = new LinearLayout(this);ll.setOrientation(LinearLayout.VERTICAL);setContentView(ll);title_tv = new TextView(this);title_tv.setText("タイトルを決定してください");title_et = new EditText(this);decide_bt = new Button(this);decide_bt.setText("決定");ll.addView(title_tv);ll.addView(title_et);ll.addView(decide_bt);decide_bt.setOnClickListener(new DecideClickListener());}class DecideClickListener implements OnClickListener{@Overridepublic void onClick(View v) {// TODO �ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽintent = new Intent(DecideTitleActivity.this, DrawActivity.class );intent.putExtra("title",title_et.getText().toString());HashMap<String, Object> data = new HashMap<String, Object>();	//kokodata.put("id","drawStartNew");data.put("title", title_et.getText().toString());	AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data, activity);asyncHttpPost.send();}}}