package ya.example.manga4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ya.example.manga4.SelectColorActivity.ImageAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DrawModeActivity extends HttpActivity {
TextView top_tv;
Button new_bt;
ImageView[] img4koma = new ImageView[3];
LinearLayout ll;

List<Map<String,Object>> info4koma = new ArrayList<Map<String,Object>>();

HttpActivity activity = this;
Intent intent2;


public void receiveMessage(Map<String, Object> map) //this
{
System.out.println("1");
if ("draw".equals(map.get("id")))
{
System.out.println("2");
System.out.println("map: " + map.toString());

try{
Map<String, Object> mapKoma = new HashMap<String, Object>();
JSONArray jsonArray = new JSONArray((String)map.get("koma"));
System.out.println("jsonArray: " + jsonArray.toString());
for(int i = 0; i < jsonArray.length(); i++)
{
JSONObject jsonObject = jsonArray.getJSONObject(i);
System.out.println("jsonObject: " + jsonObject.toString());

Map<String, Object> m = new HashMap<String, Object>();
Iterator keys = jsonObject.keys();
while (keys.hasNext()) {
String key = (String) keys.next();
m.put(key, jsonObject.getString(key));
}

System.out.println("TITLE: " + m.get("title"));

info4koma.add(m);

TextView tv = new TextView(this);
tv.setText((String)m.get("title") + " (" + (String)m.get("number") + ")");
ll.addView(tv);

ImageView iv = new ImageView(this);
AsyncHttpDownload asyncHttpDownload = new AsyncHttpDownload((String)m.get("fname"),iv, null);
asyncHttpDownload.send();

img4koma[i] = iv;


}




GridView gridview = (GridView) findViewById(R.id.gridview);

//test_iv = (ImageView) findViewById(R.id.textViewNext);

gridview.setAdapter(new ImageAdapter(this));
Button new_bt = (Button) findViewById(R.id.new_button);

//ll.addView(gridview);

//top_tv = new TextView(this);
//top_tv.setText("縺ｩ縺ｮ邯壹″繧呈緒縺�");
//top_tv = new TextView(this);
//top_tv.setText("続きを書きたいコマを選択してください");

//ll.addView(top_tv);


//ll.addView(new_bt);

new_bt.setOnClickListener(new NewClickListener());

final Context c;
c = this;
gridview.setOnItemClickListener(new OnItemClickListener() {
public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


HashMap<String, Object> data = new HashMap<String, Object>();	//koko
data.put("id","drawStart");
data.put("manga_id", (String)info4koma.get(position).get("manga_id"));
data.put("number", (String)info4koma.get(position).get("number"));	
AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data, activity);
asyncHttpPost.send();


intent2 = new Intent(DrawModeActivity.this, DrawActivity.class );
intent2.putExtra("manga_id",(String)info4koma.get(position).get("manga_id"));
intent2.putExtra("number",(String)info4koma.get(position).get("number"));
intent2.putExtra("title",(String)info4koma.get(position).get("title"));
intent2.putExtra("fname",(String)info4koma.get(position).get("fname"));





}
});



} catch (JSONException e) {
e.printStackTrace();
}

}
else if ("drawStart".equals(map.get("id")))
{
startActivity( intent2 );
}
else
{
System.out.println("3");
}

//test_tv.setText("result: " + map.toString());
}	

public class ImageAdapter extends BaseAdapter {
private Context mContext;

public ImageAdapter(Context c) {
mContext = c;
}

public int getCount() {
return img4koma.length;
}

public Object getItem(int position) {
return null;
}

public long getItemId(int position) {
return 0;
}

// create a new ImageView for each item referenced by the Adapter
public View getView(int position, View convertView, ViewGroup parent) {
ImageView imageView;
if (convertView == null) { // if it's not recycled, initialize some attributes
imageView = new ImageView(mContext);
imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
imageView.setPadding(8, 8, 8, 8);
} else {
imageView = (ImageView) convertView;
}

//imageView.setImageResource(mThumbIds[position]);
if (img4koma[position] != null) imageView = img4koma[position];
return imageView;
}

// references to our images

}

protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
//LinearLayout ll = new LinearLayout(this);
//ll.setOrientation(LinearLayout.VERTICAL);

info4koma.clear();

System.out.println("KOKO");
HashMap<String,Object> data = new HashMap<String,Object>();	//koko
data.put("id","draw");

AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data, this);
asyncHttpPost.send();

setContentView(R.layout.activity_draw_mode);
ll = (LinearLayout) findViewById(R.id.drow_mode_ll);

TextView text_view_next = (TextView) findViewById(R.id.textViewNext);



}

class NewClickListener implements OnClickListener{

@Override
public void onClick(View v) {	
Intent intent;
intent = new Intent(DrawModeActivity.this, DecideTitleActivity.class );
// 鬩包ｽｷ驕假ｽｻ陷亥現�ｽ郢ｧ�｢郢ｧ�ｯ郢晢ｿｽ縺�ｹ晁侭繝ｦ郢ｧ�｣郢ｧ螳夲ｽｵ�ｷ陷崎ｼ費ｼ�ｸｺ蟶呻ｽ�
startActivity( intent );
}
}



}