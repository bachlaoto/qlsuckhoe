/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent class for Nhasanxuat entity stored in table nhasanxuat.
 * This class is a "record entity" without JPA links.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
@Entity
@Table(name="nhasanxuat", catalog="qlsuckhoe" )
public class Nhasanxuat implements Serializable {

	private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idnhasanxuat", nullable=false)
    private Integer idnhasanxuat ; 
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="tennhasanxuat", length=45)
    private String tennhasanxuat ; 

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Nhasanxuat() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
	public void setIdnhasanxuat(Integer idnhasanxuat) {
        this.idnhasanxuat = idnhasanxuat ;
    }
	public Integer getIdnhasanxuat() {
        return this.idnhasanxuat;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	//--- DATABASE MAPPING : tennhasanxuat (VARCHAR) 
	public void setTennhasanxuat(String tennhasanxuat) {this.tennhasanxuat = tennhasanxuat;}
	public String getTennhasanxuat() {return this.tennhasanxuat;}


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(idnhasanxuat); 
		sb.append(tennhasanxuat); 
        return sb.toString();
    }
}