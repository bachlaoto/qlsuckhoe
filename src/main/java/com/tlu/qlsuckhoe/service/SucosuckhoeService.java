/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 22:38:42 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;

import com.tlu.qlsuckhoe.entity.Sucosuckhoe;

import java.util.List;

public interface SucosuckhoeService {

	public Sucosuckhoe getOne(Integer idsucosuckhoe);

	public List<Sucosuckhoe> findAll();

	public Boolean delete(Integer idsucosuckhoe);

	public Sucosuckhoe create(Sucosuckhoe sucosuckhoe);

	public Sucosuckhoe update(Sucosuckhoe sucosuckhoe);

	public Boolean exist(Sucosuckhoe sucosuckhoe);
}
