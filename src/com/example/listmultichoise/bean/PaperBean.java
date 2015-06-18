package com.example.listmultichoise.bean;

import java.util.List;

/**
 * @Description:试卷实体�?
 * @author：hzc
 */
public class PaperBean extends BaseBean {

	// 试卷名称：testPaperName
	// 试卷ID：testPaperId
	// 试卷类型：testPagerType (1- 真题 2- 模拟考试)
	// 总题数：totalQuestionNumber
	// 每个知识点的情况（真题试卷才有知识点相关信息�? knowledgePoints

	public String testPaperName;//试卷名称
	public String testPaperId;// 试卷ID
	public int testPagerType; // 试卷类型
	public int totalQuestionNumber; // 总题�?
	public List<KnowledgePointBean> knowledgePoints;//每个知识点的情况

	public PaperBean() {
		super();
	}

	public PaperBean(String testPaperName, String testPaperId,
			int testPagerType, int totalQuestionNumber,
			List<KnowledgePointBean> knowledgePoints) {
		super();
		this.testPaperName = testPaperName;
		this.testPaperId = testPaperId;
		this.testPagerType = testPagerType;
		this.totalQuestionNumber = totalQuestionNumber;
		this.knowledgePoints = knowledgePoints;
	}

	public String getTestPaperName() {
		return testPaperName;
	}

	public void setTestPaperName(String testPaperName) {
		this.testPaperName = testPaperName;
	}

	public String getTestPaperId() {
		return testPaperId;
	}

	public void setTestPaperId(String testPaperId) {
		this.testPaperId = testPaperId;
	}

	public int getTestPagerType() {
		return testPagerType;
	}

	public void setTestPagerType(int testPagerType) {
		this.testPagerType = testPagerType;
	}

	public int getTotalQuestionNumber() {
		return totalQuestionNumber;
	}

	public void setTotalQuestionNumber(int totalQuestionNumber) {
		this.totalQuestionNumber = totalQuestionNumber;
	}

	public List<KnowledgePointBean> getKnowledgePoints() {
		return knowledgePoints;
	}

	public void setKnowledgePoints(List<KnowledgePointBean> knowledgePoints) {
		this.knowledgePoints = knowledgePoints;
	}

	@Override
	public String toString() {
		return "PaperBean [testPaperName=" + testPaperName + ", testPaperId="
				+ testPaperId + ", testPagerType=" + testPagerType
				+ ", totalQuestionNumber=" + totalQuestionNumber
				+ ", knowledgePoints=" + knowledgePoints + "]";
	}

}
