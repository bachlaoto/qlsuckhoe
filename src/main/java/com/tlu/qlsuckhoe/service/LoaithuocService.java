/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 22:38:42 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;

import com.tlu.qlsuckhoe.entity.Loaithuoc;

import java.util.List;

public interface LoaithuocService {

	public Loaithuoc getOne(Integer idloaithuoc);

	public List<Loaithuoc> findAll();

	public Boolean delete(Integer idloaithuoc);

	public Loaithuoc create(Loaithuoc loaithuoc);

	public Loaithuoc update(Loaithuoc loaithuoc);

	public Boolean exist(Loaithuoc loaithuoc);
}
