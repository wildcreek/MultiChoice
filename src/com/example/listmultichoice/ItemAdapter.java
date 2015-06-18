package com.example.listmultichoice;

import java.util.ArrayList;
import java.util.List;

import com.example.listmultichoise.bean.QuestionBean;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

/**
 * @Description: ViewPager的数据适配器
 * @author hzc
 */
public class ItemAdapter extends FragmentStatePagerAdapter {
	Context context;
	public ItemAdapter(FragmentManager fm) {
		super(fm);
	}
	@Override
	public Fragment getItem(int arg0) {
		if(arg0 == MainActivity.questionlist.size()){
			return new ScantronItemFragment();
		}
		return new QuestionItemFragment(arg0);
	}
 

	@Override
	public int getCount() {
		 
		return MainActivity.questionlist.size()+1;
	}
  


}
