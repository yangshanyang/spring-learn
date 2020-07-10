package com.ysy.Dao;

import org.springframework.stereotype.Repository;

/**
 * @author shanyangyang
 * @date 2020/5/22
 */
@Repository
public class BookDao {
	private String label = "1";

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override public String toString() {
		return "BookDao{" + "label='" + label + '\'' + '}';
	}
}
