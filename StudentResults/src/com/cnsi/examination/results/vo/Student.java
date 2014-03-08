package com.cnsi.examination.results.vo;

import java.io.Serializable;

public class Student implements Serializable {
      
    private String studentname;
    private Integer std;
	private Integer studentregno;
	private Integer tamil;
	private Integer english;
	private Integer maths;
	private Integer science;
	private Integer social;
	private Integer totalmarks;

    public Student() {
    }

    public Student(Integer std, String studentname, Integer studentregno, Integer english, Integer tamil,Integer maths, Integer science,Integer social,Integer totalmarks) {
        this.std = std;
        this.studentname = studentname;
        this.studentregno = studentregno;
        this.english = english;
        this.tamil = tamil;
        this.maths = maths;
        this.science = science;
        this.social = social;
        this.totalmarks = totalmarks;       
    }

    /**
	 * @return the std
	 */
	public Integer getStd() {
		return std;
	}

	/**
	 * @param std the std to set
	 */
	public void setStd(Integer std) {
		this.std = std;
	}

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
	 * @return the english
	 */
	public Integer getEnglish() {
		return english;
	}

	/**
	 * @param english the english to set
	 */
	public void setEnglish(Integer english) {
		this.english = english;
	}

	/**
	 * @return the studentregno
	 */
	public Integer getStudentregno() {
		return studentregno;
	}

	/**
	 * @param studentregno the studentregno to set
	 */
	public void setStudentregno(Integer studentregno) {
		this.studentregno = studentregno;
	}

	/**
	 * @return the tamil
	 */
	public Integer getTamil() {
		return tamil;
	}

	/**
	 * @param tamil the tamil to set
	 */
	public void setTamil(Integer tamil) {
		this.tamil = tamil;
	}

	/**
	 * @return the maths
	 */
	public Integer getMaths() {
		return maths;
	}

	/**
	 * @param maths the maths to set
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	/**
	 * @return the science
	 */
	public Integer getScience() {
		return science;
	}

	/**
	 * @param science the science to set
	 */
	public void setScience(Integer science) {
		this.science = science;
	}

	/**
	 * @return the social
	 */
	public Integer getSocial() {
		return social;
	}

	/**
	 * @param social the social to set
	 */
	public void setSocial(Integer social) {
		this.social = social;
	}

	/**
	 * @return the totalmarks
	 */
	public Integer getTotalmarks() {
		return totalmarks;
	}

	/**
	 * @param totalmarks the totalmarks to set
	 */
	public void setTotalmarks(Integer totalmarks) {
		this.totalmarks = totalmarks;
	}

	
}
