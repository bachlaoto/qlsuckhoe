/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;

import com.tlu.qlsuckhoe.entity.Thietbiyte;
import java.util.List;

public interface ThietbiyteService {

	public Thietbiyte getOne(Integer idthietbiyte);

	public List<Thietbiyte> findAll();

	public Boolean delete(Integer idthietbiyte);

	public Thietbiyte create(Thietbiyte thietbiyte);

	public Thietbiyte update(Thietbiyte thietbiyte);

	public Boolean exist(Thietbiyte thietbiyte);
}
