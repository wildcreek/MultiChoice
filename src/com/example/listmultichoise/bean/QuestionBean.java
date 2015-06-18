package com.example.listmultichoise.bean;

import java.util.List;

/**
 * @Description:问题的实体类
 * @author：hzc
 */
public class QuestionBean extends BaseBean {

	// 1�?题目ID：questionId
	// 2�?题目描述：description
	// a) 填空题时：填空位置标记为：�?{1}”�?”{N}”，同时选项的名称为：�?{1}”�?”{N}”，
	// 对应选项的描述为：正确答案字节数的长度加4
	// b) 题目包含有图片时：图片的位置标识为：”{image1}”�?”{imageN}”，
	// 同时增加key”{image1}”�?”{image}”，它们的�?为：图片的二进制内容
	// 3�?题目类型：questionType�?-单�? 2-多�? 3-填空 4-问答�?
	// 4�?知识点名称：knowledgePointName
	// 5�?知识点ID：knowledgePointId
	// 6�?题目选项集合：questionOptions
	// a) 选项名称：name
	// b) 选项描述：description

	private String questionId;// 题目ID
	private String description;// 题目描述
	private int questionType;// 题目类型
	private String knowledgePointName; // 知识点名�?
	private String knowledgePointId; // 知识点id
	private List<QuestionOptionBean> questionOptions; // 选项集合

	public QuestionBean() {
		super();
	}

	public QuestionBean(String questionId, String description,
			int questionType, String knowledgePointName,
			String knowledgePointId, List<QuestionOptionBean> questionOptions) {
		super();
		this.questionId = questionId;
		this.description = description;
		this.questionType = questionType;
		this.knowledgePointName = knowledgePointName;
		this.knowledgePointId = knowledgePointId;
		this.questionOptions = questionOptions;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String getKnowledgePointName() {
		return knowledgePointName;
	}

	public void setKnowledgePointName(String knowledgePointName) {
		this.knowledgePointName = knowledgePointName;
	}

	public String getKnowledgePointId() {
		return knowledgePointId;
	}

	public void setKnowledgePointId(String knowledgePointId) {
		this.knowledgePointId = knowledgePointId;
	}

	public List<QuestionOptionBean> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<QuestionOptionBean> questionOptions) {
		this.questionOptions = questionOptions;
	}

	@Override
	public String toString() {
		return "QuestionBean [questionId=" + questionId + ", description="
				+ description + ", questionType=" + questionType
				+ ", knowledgePointName=" + knowledgePointName
				+ ", knowledgePointId=" + knowledgePointId
				+ ", questionOptions=" + questionOptions + "]";
	}

}
