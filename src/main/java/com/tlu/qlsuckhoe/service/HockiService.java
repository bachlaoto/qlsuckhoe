/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 22:38:41 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;

import com.tlu.qlsuckhoe.entity.Hocki;

import java.util.List;

public interface HockiService {

	public Hocki getOne(Integer idhocki);

	public List<Hocki> findAll();

	public Boolean delete(Integer idhocki);

	public Hocki create(Hocki hocki);

	public Hocki update(Hocki hocki);

	public Boolean exist(Hocki hocki);
}
