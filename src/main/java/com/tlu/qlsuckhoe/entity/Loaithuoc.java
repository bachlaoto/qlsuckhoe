/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for Loaithuoc entity stored in table loaithuoc.
 * This class is a "record entity" without JPA links.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
@Entity
@Table(name="loaithuoc", catalog="qlsuckhoe" )
public class Loaithuoc implements Serializable {

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idloaithuoc", nullable=false)
    private Integer idloaithuoc ; 
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="tenloai", length=45)
    private String tenloai ; 

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Loaithuoc() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
	public void setIdloaithuoc(Integer idloaithuoc) {
        this.idloaithuoc = idloaithuoc ;
    }
	public Integer getIdloaithuoc() {
        return this.idloaithuoc;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	//--- DATABASE MAPPING : tenloai (VARCHAR) 
	public void setTenloai(String tenloai) {this.tenloai = tenloai;}
	public String getTenloai() {return this.tenloai;}


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(idloaithuoc); 
		sb.append(tenloai); 
        return sb.toString();
    }
}