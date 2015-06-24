package com.example.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.adapter.ItemAdapter;
import com.example.bean.QuestionBean;
import com.example.bean.QuestionOptionBean;
import com.example.listmultichoise.R;
import com.example.view.ConfirmDialog;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @version 1.0
 * @author hzc
 * @date 2015-6-24
 */
public class MainActivity extends FragmentActivity implements OnClickListener {
	List<View> list = new ArrayList<View>();
	public static List<QuestionBean> questionlist = new ArrayList<QuestionBean>();
	public static QuestionBean question;
	public List<QuestionOptionBean> options1 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options2 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options3 = new ArrayList<QuestionOptionBean>();
	public List<QuestionOptionBean> options4 = new ArrayList<QuestionOptionBean>();
	public static QuestionOptionBean option;
	private ViewPager vp;
	private ItemAdapter pagerAdapter;
	View pager_item;
	public static int currentIndex = 0;
	private TextView tv_time;
	private TextView tv_share;
	private TextView tv_answercard;
	private TextView tv_back;
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
		loadData();
		

		Log.e("测试数据", questionlist.get(0).toString());
		Log.e("测试数据", questionlist.get(1).toString());
		
		tv_back = (TextView) findViewById(R.id.tv_back);
		tv_answercard = (TextView) findViewById(R.id.tv_answercard);
		tv_time = (TextView) findViewById(R.id.tv_time);
		tv_share = (TextView) findViewById(R.id.tv_share);
		startCounter();
		tv_back.setOnClickListener(this); 
		tv_answercard.setOnClickListener(this); 
		tv_time.setOnClickListener(this); 
		tv_share.setOnClickListener(this); 
		
		vp = (ViewPager) findViewById(R.id.vp);

		vp.setCurrentItem(0);
		pagerAdapter = new ItemAdapter(getSupportFragmentManager());
		vp.setAdapter(pagerAdapter);
		vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int position) {
				currentIndex = position;
			}
		});
		
		LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
		 IntentFilter filter = new IntentFilter();
		 filter.addAction("com.leyikao.jumptonext");
		 filter.addAction("com.leyikao.jumptopage");
		lbm.registerReceiver(mMessageReceiver, filter);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_back://点击头部返回
			
			break;
		case R.id.tv_answercard://点击头部答题卡
			
			jumpToPage(questionlist.size());
			
			break;
		case R.id.tv_time://点击头部计时器
			//TODO计时器停止计时
			stopCounter();
			 final ConfirmDialog confirmDialog = new ConfirmDialog(this, "共4道题，还剩4道题未做");
			 confirmDialog.setCancelable(false);
			 confirmDialog.show();
			 confirmDialog.setClicklistener(new ConfirmDialog.ClickListenerInterface() {

				@Override
				public void doProceed() {
					//TODO计时器继续计时
					confirmDialog.dismiss();
					startCounter();
				}
			 
			 });
			break;
		case R.id.tv_share://点击头部分享
			
			break;			
		default:
			break;
		}
	}

	private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			 if (intent.getAction().equals("com.leyikao.jumptonext")) {
				 jumpToNext() ;
             } else if (intent.getAction().equals("com.leyikao.jumptopage")) {
            	 int index = intent.getIntExtra("index", 0);
            	 jumpToPage(index);
             }  
		}
	};
 
	public void jumpToNext() {
		int position = vp.getCurrentItem();
		vp.setCurrentItem(position + 1);
		 
	}
	public void jumpToPage(int index) {
		vp.setCurrentItem(index);
	}

	private void loadData() {
		// 初始化数据
		option = new QuestionOptionBean("A", "这个男的头有病");
		options1.add(option);
		option = new QuestionOptionBean("B", "这个男的头比较大");
		options1.add(option);
		option = new QuestionOptionBean("C", "这个男的看见的是鬼");
		options1.add(option);
		option = new QuestionOptionBean("D", "这个女的有点吃醋");
		options1.add(option);
		option = new QuestionOptionBean("E", "这个男的看见的是鬼");
		options1.add(option);
		question = new QuestionBean("0001", "男：看那个妹妹，好靓哦！\n女：看你个大头鬼！"
				+ "\n问：这个女的是什么意思？", 2, "常识判断", "001", options1);
		questionlist.add(question);

		// 初始化数据
		option = new QuestionOptionBean("A", "河北");
		options2.add(option);
		option = new QuestionOptionBean("B", "通州");
		options2.add(option);
		option = new QuestionOptionBean("C", "石家庄");
		options2.add(option);
		option = new QuestionOptionBean("D", "北京");
		options2.add(option);
		question = new QuestionBean("0002", "中国的首都在哪？", 1, "常识判断", "001",
				options2);
		questionlist.add(question);

		// 初始化数据
		option = new QuestionOptionBean("A",
				"中台办国台办宣布五项促进两岸交往新举措，大陆13省市居民可赴金门旅游。");
		options3.add(option);
		option = new QuestionOptionBean("B",
				"说起去年发生的那件事，两个人脸上依如往常，目光中带着幽怨和冷漠，相对许久许久。");
		options3.add(option);
		option = new QuestionOptionBean("C",
				"明年，他只打算完成一部电视剧本，其他的事不想做。关于电视剧本的详细情况，他说，不易过早泄密。");
		options3.add(option);
		option = new QuestionOptionBean("D",
				"她把海南的荔枝、芒果，新疆的哈蜜瓜、紫葡萄等珍果和自家产的黄橙橙的菠萝放在一起，装满了一篮子。");
		options3.add(option);
		question = new QuestionBean("0003", "下列语句中，没有错别字的一项是 ", 1, "常识判断",
				"001", options3);
		questionlist.add(question);

		// 初始化数据
		option = new QuestionOptionBean("A",
				"退休后他迷恋上了象棋，常常在街头的棋摊上为人“指点江山”，有时候也赤膊上阵杀他个风声鹤唳、天昏地暗。");
		options4.add(option);
		option = new QuestionOptionBean("B",
				"好不容易搞到一张多明戈亚洲巡回演唱会的门票，酷爱西洋音乐的他一直盼着赶快下班好跟朋友一起去听音乐会，满心期待，不可终日。");
		options4.add(option);
		option = new QuestionOptionBean("C",
				"陈水扁弊案缠身，为了转移公众视线，就会时不时提出一些似是而非的说法，挖空心思地为自己开脱罪责。");
		options4.add(option);
		option = new QuestionOptionBean("D",
				"来自陕西的“羊倌歌王”在原生态歌手比赛中，竟然指鹿为马，把英国． 澳大利亚国旗说成中国、日本国旗，引起一片哗然。");
		options4.add(option);
		question = new QuestionBean("0004", "下面各句中加点的词语，使用正确的一项是 ", 1, "常识判断",
				"001", options4);
		questionlist.add(question);

	}
	//计时器任务
	int time = 0;
	int second = 0;
	int minute = 0;
	String timeStr  ="00:00";
	int[] iTime = new int[]{0,0,0,0};
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				time++;
				second = time %60;
				minute = time /60;
				if(minute>99){
					break;
				}
				//Log.e("秒数", ""+second);
				//Log.e("分钟数", ""+minute);
				if(second < 10 && minute < 10){
					iTime[0]=0;
					iTime[1]=minute;
					iTime[2]=0;
					iTime[3]=second;
					
				}else if(second >= 10 && minute < 10){
					iTime[0]=0;
					iTime[1]=minute;
					iTime[2]=(second+"").charAt(0)-48;
					iTime[3]=(second+"").charAt(1)-48;
					
				}else if(second < 10 && minute >= 10){
					iTime[0]=(minute+"").charAt(0)-48;
					iTime[1]=(minute+"").charAt(1)-48;
					iTime[2]=0;
					iTime[3]=second;
					
				}else if(second >= 10 && minute >= 10){
					iTime[0]=(minute+"").charAt(0)-48;
					iTime[1]=(minute+"").charAt(1)-48;
					iTime[2]=(second+"").charAt(0)-48;
					iTime[3]=(second+"").charAt(1)-48;
					
				}
				tv_time.setText(""+iTime[0]+iTime[1]+":"+iTime[2]+iTime[3]);
				handler.sendEmptyMessageDelayed(1, 1000);
				break;

			default:
				break;
			}
			
		};
	};


	// 开始计时
	public void startCounter() {
		handler.sendEmptyMessageDelayed(1, 1000);
	}

	// 暂停计时
	public void stopCounter() {
		handler.removeCallbacksAndMessages(null);
	}
	
	protected void onDestroy() {
		LocalBroadcastManager.getInstance(this).unregisterReceiver(
				mMessageReceiver);
		super.onDestroy();
	}

 
}
