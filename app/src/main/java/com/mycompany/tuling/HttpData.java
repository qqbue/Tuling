package com.mycompany.tuling;
import android.os.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.*;
import org.apache.http.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;
import java.io.*;

public class HttpData extends AsyncTask<String,Void,String>
{
	HttpClient httpClient;
	HttpGet httpGet;
	HttpResponse httpResponse;
	HttpEntity httpEntity;
	HttpGetDataListener listener;

	private String url;
	public HttpData(String url,HttpGetDataListener listener){
		this.url=url;
		this.listener=listener;
		
	}
	
	@Override
	protected String doInBackground(String[] p1)
	{
		
		httpClient =new DefaultHttpClient();
		httpGet=new HttpGet(url);
		
		
		try{
		httpResponse=httpClient.execute(httpGet);
		if(httpResponse.getStatusLine().getStatusCode()==200){
			
			
			httpEntity=httpResponse.getEntity();
			String line="";
			StringBuilder builder=new StringBuilder();
		
			BufferedReader reader=new BufferedReader(new InputStreamReader(httpEntity.getContent()));
			while((line=reader.readLine())!=null){
				builder.append(line);
				
			}
			return builder.toString();
		}
		
		}catch(Exception e){}
		return null;
	}

	@Override
	protected void onPostExecute(String result)
	{
		
		listener.getUrlData(result);
		// TODO: Implement this method
		super.onPostExecute(result);
	}
	
	
	
	
	
}

	
	
	
	

