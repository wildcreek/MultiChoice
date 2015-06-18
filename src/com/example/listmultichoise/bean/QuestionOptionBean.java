package com.example.listmultichoise.bean;

/**
 * @Description:问题的�?�?
 * @author：hzc
 */
public class QuestionOptionBean extends BaseBean {
	// 题目选项
	// 1 选项名称：name
	// 2 选项描述：description
	
	private String name;// 选项名称
	private String description;// 选项描述

	public QuestionOptionBean() {
		super();
	}

	public QuestionOptionBean(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "QuestionOptionBean [name=" + name + ", description="
				+ description + "]";
	}

}
