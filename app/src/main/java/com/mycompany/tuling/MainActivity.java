package com.mycompany.tuling;

import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.*;
import org.json.*;
import android.view.View.*;
import android.view.*;

public class MainActivity extends Activity implements HttpGetDataListener,OnClickListener
{

	
	List<ListData> list;
	
	HttpData httpData;
	//TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		//tv=(TextView) findViewById(R.id.mainTextView1);
		
		httpData=(HttpData) new HttpData(Config.serverUrl+"天气",this).execute();
		
    }

	@Override
	public void getUrlData(String data)
	{
		//System.out.println(data);
		//tv.setText(data);
		parse(data);
		// TODO: Implement this method
	}
	public void initView(){
		
		list=new ArrayList<ListData>();
		
		
	}
	public void parse(String text){
		
		
		try
		{
			JSONObject jsonObject=new JSONObject(text);
			
			//StringBuilder buil=new StringBuilder();
//			buil.append(jsonObject.getString("code"));
//			buil.append(jsonObject.getString("text"));
//			tv.setText(buil.toString());
			
//			
			ListData listData=new ListData(jsonObject.getString("text"));
			list.add(listData);
		}
		catch (JSONException e)
		{}

		
	}

	@Override
	public void onClick(View p1)
	{
		// TODO: Implement this method
	}

	
	
	}
