/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 22:38:41 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;


import com.tlu.qlsuckhoe.entity.Hocki;
import com.tlu.qlsuckhoe.repository.HockiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HockiServiceImpl implements HockiService {

	@Autowired
	private HockiRepository hockiRepository;

	@Override
	public Hocki getOne(Integer idhocki) {
		return hockiRepository.findById(idhocki).get();
	}

	@Override
	public Boolean delete(Integer idhocki) {
		if (hockiRepository.getOne(idhocki) != null) {
			hockiRepository.deleteById(idhocki);
			return true;
		}
		return false;
	}

	@Override
	public Hocki create(Hocki hocki) {
		return hockiRepository.save(hocki);
	}

	@Override
	public Hocki update(Hocki hockiToUpdate) {
						Hocki hocki = hockiRepository.getOne(hockiToUpdate.getIdhocki());
										
				if(hockiToUpdate.getTenhocki() !=null) {
			
		}
				return hockiRepository.save(hocki);
	}

	@Override
	public Boolean exist(Hocki hocki) {
						return hockiRepository.existsById(hocki.getIdhocki());
									}

	@Override
	public List<Hocki> findAll() {
		return hockiRepository.findAll();
	}

}


