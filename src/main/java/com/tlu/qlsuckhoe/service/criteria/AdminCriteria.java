/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:53 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service.criteria;

/**
 * Criteria bean used for Admin search.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
public class AdminCriteria {

    private String tendangnhap; 
    private String matkhau; 
	// Constructor
	public AdminCriteria() {
		// Needed empty constructor for serialization
	}

	public void setTendangnhap(String tendangnhap) {this.tendangnhap = tendangnhap;}
	public String getTendangnhap() {return this.tendangnhap;}
	public void setMatkhau(String matkhau) {this.matkhau = matkhau;}
	public String getMatkhau() {return this.matkhau;}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(tendangnhap); 
		sb.append("|"); 
		sb.append(matkhau); 
        return sb.toString();
	}
}