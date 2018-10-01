package com.tlu.qlsuckhoe.entity;
// Generated Oct 1, 2018 10:37:59 PM by Hibernate Tools 5.2.11.Final

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Danhmuc generated by hbm2java
 */
@Entity
@Table(name = "danhmuc", catalog = "qlsuckhoe")
public class Danhmuc implements java.io.Serializable {

	private Integer iddanhmuc;
	private String tendanhmuc;

	public Danhmuc() {
	}

	public Danhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iddanhmuc", unique = true, nullable = false)
	public Integer getIddanhmuc() {
		return this.iddanhmuc;
	}

	public void setIddanhmuc(Integer iddanhmuc) {
		this.iddanhmuc = iddanhmuc;
	}

	@Column(name = "tendanhmuc", length = 45)
	public String getTendanhmuc() {
		return this.tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

}
