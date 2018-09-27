/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for Thuoc entity stored in table thuoc.
 * This class is a "record entity" without JPA links.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
@Entity
@Table(name="thuoc", catalog="qlsuckhoe" )
public class Thuoc implements Serializable {

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idthuoc", nullable=false)
    private Integer idthuoc ; 
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="idloaithuoc")
    private Integer idloaithuoc ; // Foreign Key     @Column(name="idnhasanxuat")
    private Integer idnhasanxuat ; // Foreign Key     @Column(name="tenthuoc", length=45)
    private String tenthuoc ;     @Column(name="tacdung", length=45)
    private String tacdung ;     @Column(name="cachdung", length=45)
    private String cachdung ;     @Column(name="ngaynhap", length=45)
    private String ngaynhap ;     @Column(name="soluong")
    private Integer soluong ; 

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Thuoc() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
	public void setIdthuoc(Integer idthuoc) {
        this.idthuoc = idthuoc ;
    }
	public Integer getIdthuoc() {
        return this.idthuoc;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	//--- DATABASE MAPPING : idloaithuoc (INT) 
	public void setIdloaithuoc(Integer idloaithuoc) {this.idloaithuoc = idloaithuoc;}
	public Integer getIdloaithuoc() {return this.idloaithuoc;}

	//--- DATABASE MAPPING : idnhasanxuat (INT) 
	public void setIdnhasanxuat(Integer idnhasanxuat) {this.idnhasanxuat = idnhasanxuat;}
	public Integer getIdnhasanxuat() {return this.idnhasanxuat;}

	//--- DATABASE MAPPING : tenthuoc (VARCHAR) 
	public void setTenthuoc(String tenthuoc) {this.tenthuoc = tenthuoc;}
	public String getTenthuoc() {return this.tenthuoc;}

	//--- DATABASE MAPPING : tacdung (VARCHAR) 
	public void setTacdung(String tacdung) {this.tacdung = tacdung;}
	public String getTacdung() {return this.tacdung;}

	//--- DATABASE MAPPING : cachdung (VARCHAR) 
	public void setCachdung(String cachdung) {this.cachdung = cachdung;}
	public String getCachdung() {return this.cachdung;}

	//--- DATABASE MAPPING : ngaynhap (VARCHAR) 
	public void setNgaynhap(String ngaynhap) {this.ngaynhap = ngaynhap;}
	public String getNgaynhap() {return this.ngaynhap;}

	//--- DATABASE MAPPING : soluong (INT) 
	public void setSoluong(Integer soluong) {this.soluong = soluong;}
	public Integer getSoluong() {return this.soluong;}


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(idthuoc); 
		sb.append(idloaithuoc); 
		sb.append("|"); 
		sb.append(idnhasanxuat); 
		sb.append("|"); 
		sb.append(tenthuoc); 
		sb.append("|"); 
		sb.append(tacdung); 
		sb.append("|"); 
		sb.append(cachdung); 
		sb.append("|"); 
		sb.append(ngaynhap); 
		sb.append("|"); 
		sb.append(soluong); 
        return sb.toString();
    }
}