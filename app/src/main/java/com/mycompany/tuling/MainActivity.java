package com.mycompany.tuling;

import android.app.*;
import android.os.*;
import android.widget.*;

public class MainActivity extends Activity implements HttpGetDataListener
{

	
	
	
	HttpData httpData;
	TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		tv=(TextView) findViewById(R.id.mainTextView1);
		
		httpData=(HttpData) new HttpData("http://www.baidu.com",this).execute();
		
    }

	@Override
	public void getUrlData(String data)
	{
		System.out.println(data);
		tv.setText(data);
		// TODO: Implement this method
	}
}
