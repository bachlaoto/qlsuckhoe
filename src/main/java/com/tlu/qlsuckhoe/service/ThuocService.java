/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;

import com.tlu.qlsuckhoe.entity.Thuoc;
import java.util.List;

public interface ThuocService {

	public Thuoc getOne(Integer idthuoc);

	public List<Thuoc> findAll();

	public Boolean delete(Integer idthuoc);

	public Thuoc create(Thuoc thuoc);

	public Thuoc update(Thuoc thuoc);

	public Boolean exist(Thuoc thuoc);
}
