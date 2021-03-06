package com.tlu.qlsuckhoe.entity;
// Generated Oct 1, 2018 10:37:59 PM by Hibernate Tools 5.2.11.Final

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Loaithuoc generated by hbm2java
 */
@Entity
@Table(name = "loaithuoc", catalog = "qlsuckhoe")
public class Loaithuoc implements java.io.Serializable {

	private Integer idloaithuoc;
	private String tenloai;
	private Set<Thuoc> thuocs = new HashSet<Thuoc>(0);

	public Loaithuoc() {
	}

	public Loaithuoc(String tenloai, Set<Thuoc> thuocs) {
		this.tenloai = tenloai;
		this.thuocs = thuocs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idloaithuoc", unique = true, nullable = false)
	public Integer getIdloaithuoc() {
		return this.idloaithuoc;
	}

	public void setIdloaithuoc(Integer idloaithuoc) {
		this.idloaithuoc = idloaithuoc;
	}

	@Column(name = "tenloai", length = 45)
	public String getTenloai() {
		return this.tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaithuoc")
	public Set<Thuoc> getThuocs() {
		return this.thuocs;
	}

	public void setThuocs(Set<Thuoc> thuocs) {
		this.thuocs = thuocs;
	}

}
