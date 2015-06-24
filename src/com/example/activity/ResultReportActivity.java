package com.example.activity;



import com.example.listmultichoise.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ResultReportActivity extends FragmentActivity  {
	LocalBroadcastManager mLocalBroadcastManager;
	int count = MainActivity.questionlist.size();
	int[] mIds = new int[count];


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_report);
		
		initData();
		 mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
		GridView gv = (GridView) findViewById(R.id.report_gv);
		TextView tv_report_total_question = (TextView) findViewById(R.id.tv_report_total_question);
		TextView tv_report_exam_type = (TextView) findViewById(R.id.tv_report_exam_type);
		RelativeLayout rl_result_panel = (RelativeLayout) findViewById(R.id.rl_result_panel);
		//设置scrollview 自动置顶
		rl_result_panel.setFocusable(true);
		rl_result_panel.setFocusableInTouchMode(true);
		rl_result_panel.requestFocus();
		
		tv_report_total_question.setText("道/"+count+"道");
		MyAdapter adapter = new MyAdapter(this);
		gv.setAdapter(adapter);
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO跳转到相应的viewpager 页面
				  Intent intent = new Intent("com.leyikao.jumptopage");
                 intent.putExtra("index", position);
                 mLocalBroadcastManager.sendBroadcast(intent);
			}
		});
	}
	private void initData() {
		for (int i = 0; i < count; i++) {
			mIds[i] = i + 1;
		}
	}
	
	private class MyAdapter extends BaseAdapter {
		private Context mContext;

		public MyAdapter(Context context) {
			this.mContext = context;
		}

		@Override
		public int getCount() {
			return mIds.length;
		}

		@Override
		public Object getItem(int position) {
			return mIds[position];
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = new TextView(mContext);
			tv.setGravity(Gravity.CENTER);
			tv.setLayoutParams(new GridView.LayoutParams(70, 70));
			tv.setPadding(8, 8, 8, 8);

			tv.setText(mIds[position] + "");
			tv.setBackgroundResource(R.drawable.option_btn_single_normal);
			return tv;
		}

	}
 
}
