/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service.criteria;

/**
 * Criteria bean used for Loaithuoc search.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
public class LoaithuocCriteria {

    private String tenloai; 
	// Constructor
	public LoaithuocCriteria() {
		// Needed empty constructor for serialization
	}

	public void setTenloai(String tenloai) {this.tenloai = tenloai;}
	public String getTenloai() {return this.tenloai;}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(tenloai); 
        return sb.toString();
	}
}
