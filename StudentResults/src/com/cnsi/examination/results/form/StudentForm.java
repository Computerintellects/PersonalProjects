package com.cnsi.examination.results.form;

import org.apache.struts.action.ActionForm;

public class StudentForm extends ActionForm {
        
    private String studentname;
    private String std;
	private int studentregno;
	private int tamil;
	private int english;
	private int maths;
	private int science;
	private int social;
	private int totalmarks;
	/**
	 * @return the studentname
	 */
	public String getStudentname() {
		return studentname;
	}
	/**
	 * @param studentname the studentname to set
	 */
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	/**
	 * @return the std
	 */
	public String getStd() {
		return std;
	}
	/**
	 * @param std the std to set
	 */
	public void setStd(String std) {
		this.std = std;
	}
	/**
	 * @return the studentregno
	 */
	public int getStudentregno() {
		return studentregno;
	}
	/**
	 * @param studentregno the studentregno to set
	 */
	public void setStudentregno(int studentregno) {
		this.studentregno = studentregno;
	}
	/**
	 * @return the tamil
	 */
	public int getTamil() {
		return tamil;
	}
	/**
	 * @param tamil the tamil to set
	 */
	public void setTamil(int tamil) {
		this.tamil = tamil;
	}
	/**
	 * @return the english
	 */
	public int getEnglish() {
		return english;
	}
	/**
	 * @param english the english to set
	 */
	public void setEnglish(int english) {
		this.english = english;
	}
	/**
	 * @return the maths
	 */
	public int getMaths() {
		return maths;
	}
	/**
	 * @param maths the maths to set
	 */
	public void setMaths(int maths) {
		this.maths = maths;
	}
	/**
	 * @return the science
	 */
	public int getScience() {
		return science;
	}
	/**
	 * @param science the science to set
	 */
	public void setScience(int science) {
		this.science = science;
	}
	/**
	 * @return the social
	 */
	public int getSocial() {
		return social;
	}
	/**
	 * @param social the social to set
	 */
	public void setSocial(int social) {
		this.social = social;
	}
	/**
	 * @return the totalmarks
	 */
	public int getTotalmarks() {
		return totalmarks;
	}
	/**
	 * @param totalmarks the totalmarks to set
	 */
	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}
}
