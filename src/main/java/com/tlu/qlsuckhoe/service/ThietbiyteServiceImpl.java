/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:56 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;



import java.util.List;

import javax.transaction.Transactional;

import com.tlu.qlsuckhoe.repository.ThietbiyteRepository;
import com.tlu.qlsuckhoe.entity.Thietbiyte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ThietbiyteServiceImpl implements ThietbiyteService {

	@Autowired
	private ThietbiyteRepository thietbiyteRepository;

	@Override
	public Thietbiyte getOne(Integer idthietbiyte) {
		return thietbiyteRepository.getOne(idthietbiyte);
	}

	@Override
	public Boolean delete(Integer idthietbiyte) {
		if (thietbiyteRepository.getOne(idthietbiyte) != null) {
			thietbiyteRepository.deleteById(idthietbiyte);
			return true;
		}
		return false;
	}

	@Override
	public Thietbiyte create(Thietbiyte thietbiyte) {
		return thietbiyteRepository.save(thietbiyte);
	}

	@Override
	public Thietbiyte update(Thietbiyte thietbiyteToUpdate) {
						Thietbiyte thietbiyte = thietbiyteRepository.getOne(thietbiyteToUpdate.getIdthietbiyte());
																						
				if(thietbiyteToUpdate.getIdnhasanxuat() !=null) {
			
		}
				if(thietbiyteToUpdate.getTenthietbi() !=null) {
			
		}
				if(thietbiyteToUpdate.getSoluong() !=null) {
			
		}
				if(thietbiyteToUpdate.getCachdung() !=null) {
			
		}
				return thietbiyteRepository.save(thietbiyte);
	}

	@Override
	public Boolean exist(Thietbiyte thietbiyte) {
						return thietbiyteRepository.existsById(thietbiyte.getIdthietbiyte());
																					}

	@Override
	public List<Thietbiyte> findAll() {
		return thietbiyteRepository.findAll();
	}

}

