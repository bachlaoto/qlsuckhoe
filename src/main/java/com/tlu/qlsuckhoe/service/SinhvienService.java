/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;

import com.tlu.qlsuckhoe.entity.Sinhvien;
import java.util.List;

public interface SinhvienService {

	public Sinhvien getOne(Integer idsinhvien);

	public List<Sinhvien> findAll();

	public Boolean delete(Integer idsinhvien);

	public Sinhvien create(Sinhvien sinhvien);

	public Sinhvien update(Sinhvien sinhvien);

	public Boolean exist(Sinhvien sinhvien);
}