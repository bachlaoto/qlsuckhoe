package com.tlu.qlsuckhoe.entity;
// Generated Oct 1, 2018 10:37:59 PM by Hibernate Tools 5.2.11.Final

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name = "admin", catalog = "qlsuckhoe")
public class Admin implements java.io.Serializable {

	private Integer idadmin;
	private Role role;
	private String tendangnhap;
	private String matkhau;

	public Admin() {
	}

	public Admin(Role role, String tendangnhap, String matkhau) {
		this.role = role;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idadmin", unique = true, nullable = false)
	public Integer getIdadmin() {
		return this.idadmin;
	}

	public void setIdadmin(Integer idadmin) {
		this.idadmin = idadmin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idrole")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "tendangnhap", length = 45)
	public String getTendangnhap() {
		return this.tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	@Column(name = "matkhau", length = 45)
	public String getMatkhau() {
		return this.matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

}
