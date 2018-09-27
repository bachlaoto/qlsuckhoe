/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service.criteria;

/**
 * Criteria bean used for Sinhvien search.
 * @author Telosys (http://www.telosys.org/) version 3.0.0
 */
public class SinhvienCriteria {

    private String hoten; 
    private String gioitinh; 
    private String namsinh; 
    private String socmt; 
    private String diachi; 
    private String chuyennganh; 
    private String khoa; 
    private String masv; 
    private String matkhau; 
	// Constructor
	public SinhvienCriteria() {
		// Needed empty constructor for serialization
	}

	public void setHoten(String hoten) {this.hoten = hoten;}
	public String getHoten() {return this.hoten;}
	public void setGioitinh(String gioitinh) {this.gioitinh = gioitinh;}
	public String getGioitinh() {return this.gioitinh;}
	public void setNamsinh(String namsinh) {this.namsinh = namsinh;}
	public String getNamsinh() {return this.namsinh;}
	public void setSocmt(String socmt) {this.socmt = socmt;}
	public String getSocmt() {return this.socmt;}
	public void setDiachi(String diachi) {this.diachi = diachi;}
	public String getDiachi() {return this.diachi;}
	public void setChuyennganh(String chuyennganh) {this.chuyennganh = chuyennganh;}
	public String getChuyennganh() {return this.chuyennganh;}
	public void setKhoa(String khoa) {this.khoa = khoa;}
	public String getKhoa() {return this.khoa;}
	public void setMasv(String masv) {this.masv = masv;}
	public String getMasv() {return this.masv;}
	public void setMatkhau(String matkhau) {this.matkhau = matkhau;}
	public String getMatkhau() {return this.matkhau;}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(hoten); 
		sb.append("|"); 
		sb.append(gioitinh); 
		sb.append("|"); 
		sb.append(namsinh); 
		sb.append("|"); 
		sb.append(socmt); 
		sb.append("|"); 
		sb.append(diachi); 
		sb.append("|"); 
		sb.append(chuyennganh); 
		sb.append("|"); 
		sb.append(khoa); 
		sb.append("|"); 
		sb.append(masv); 
		sb.append("|"); 
		sb.append(matkhau); 
        return sb.toString();
	}
}