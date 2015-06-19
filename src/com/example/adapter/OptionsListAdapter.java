package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.QuestionBean;
import com.example.bean.QuestionOptionBean;
import com.example.listmultichoise.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

public class OptionsListAdapter extends BaseAdapter {
	private Context mContext;
	ListView lv ;
	int index;
	public List<QuestionOptionBean> options ;
	
	public OptionsListAdapter(Context context, List<QuestionOptionBean> options,ListView lv,int index) {
		this.mContext = context;
		this.options = options;
		this.lv = lv;
		 
	}

	public int getCount() {
		return options.size();
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	@Override
	public boolean isEnabled(int position) {
		 
		return true;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
	 
			View view = LayoutInflater.from(mContext).inflate(
					R.layout.list_item_option, null);
			CheckedTextView ctv = (CheckedTextView) view.findViewById(R.id.ctv_name);
			TextView option = (TextView) view.findViewById(R.id.tv_option);
			
			ctv.setText(options.get(position).getName());
			option.setText(options.get(position).getDescription());
			updateBackground(position, ctv);
			return view;
	 
	}

	public void updateBackground(int position, View view) {
		int backgroundId;
		if (lv.isItemChecked(position )) {
			backgroundId = R.drawable.option_btn_single_checked;
		} else {
			backgroundId = R.drawable.option_btn_single_normal;
		}
		Drawable background = mContext.getResources().getDrawable(backgroundId);
		view.setBackgroundDrawable(background) ;
	}

}
