/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for Thietbiyte entity stored in table thietbiyte.
 * This class is a "record entity" without JPA links.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
@Entity
@Table(name="thietbiyte", catalog="qlsuckhoe" )
public class Thietbiyte implements Serializable {

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idthietbiyte", nullable=false)
    private Integer idthietbiyte ; 
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="idnhasanxuat")
    private Integer idnhasanxuat ; // Foreign Key     @Column(name="tenthietbi", length=45)
    private String tenthietbi ;     @Column(name="soluong")
    private Integer soluong ;     @Column(name="cachdung", length=45)
    private String cachdung ; 

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Thietbiyte() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
	public void setIdthietbiyte(Integer idthietbiyte) {
        this.idthietbiyte = idthietbiyte ;
    }
	public Integer getIdthietbiyte() {
        return this.idthietbiyte;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	//--- DATABASE MAPPING : idnhasanxuat (INT) 
	public void setIdnhasanxuat(Integer idnhasanxuat) {this.idnhasanxuat = idnhasanxuat;}
	public Integer getIdnhasanxuat() {return this.idnhasanxuat;}

	//--- DATABASE MAPPING : tenthietbi (VARCHAR) 
	public void setTenthietbi(String tenthietbi) {this.tenthietbi = tenthietbi;}
	public String getTenthietbi() {return this.tenthietbi;}

	//--- DATABASE MAPPING : soluong (INT) 
	public void setSoluong(Integer soluong) {this.soluong = soluong;}
	public Integer getSoluong() {return this.soluong;}

	//--- DATABASE MAPPING : cachdung (VARCHAR) 
	public void setCachdung(String cachdung) {this.cachdung = cachdung;}
	public String getCachdung() {return this.cachdung;}


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(idthietbiyte); 
		sb.append(idnhasanxuat); 
		sb.append("|"); 
		sb.append(tenthietbi); 
		sb.append("|"); 
		sb.append(soluong); 
		sb.append("|"); 
		sb.append(cachdung); 
        return sb.toString();
    }
}