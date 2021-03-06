package com.tlu.qlsuckhoe.entity;
// Generated Oct 1, 2018 10:37:59 PM by Hibernate Tools 5.2.11.Final

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Nhasanxuat generated by hbm2java
 */
@Entity
@Table(name = "nhasanxuat", catalog = "qlsuckhoe")
public class Nhasanxuat implements java.io.Serializable {

	private Integer idnhasanxuat;
	private String tennhasanxuat;
	private Set<Thuoc> thuocs = new HashSet<Thuoc>(0);
	private Set<Thietbiyte> thietbiytes = new HashSet<Thietbiyte>(0);

	public Nhasanxuat() {
	}

	public Nhasanxuat(String tennhasanxuat, Set<Thuoc> thuocs, Set<Thietbiyte> thietbiytes) {
		this.tennhasanxuat = tennhasanxuat;
		this.thuocs = thuocs;
		this.thietbiytes = thietbiytes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idnhasanxuat", unique = true, nullable = false)
	public Integer getIdnhasanxuat() {
		return this.idnhasanxuat;
	}

	public void setIdnhasanxuat(Integer idnhasanxuat) {
		this.idnhasanxuat = idnhasanxuat;
	}

	@Column(name = "tennhasanxuat", length = 45)
	public String getTennhasanxuat() {
		return this.tennhasanxuat;
	}

	public void setTennhasanxuat(String tennhasanxuat) {
		this.tennhasanxuat = tennhasanxuat;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhasanxuat")
	public Set<Thuoc> getThuocs() {
		return this.thuocs;
	}

	public void setThuocs(Set<Thuoc> thuocs) {
		this.thuocs = thuocs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhasanxuat")
	public Set<Thietbiyte> getThietbiytes() {
		return this.thietbiytes;
	}

	public void setThietbiytes(Set<Thietbiyte> thietbiytes) {
		this.thietbiytes = thietbiytes;
	}

}
