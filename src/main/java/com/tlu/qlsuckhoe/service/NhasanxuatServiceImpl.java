/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 09:24:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;



import java.util.List;

import javax.transaction.Transactional;

import com.tlu.qlsuckhoe.repository.NhasanxuatRepository;
import com.tlu.qlsuckhoe.entity.Nhasanxuat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NhasanxuatServiceImpl implements NhasanxuatService {

	@Autowired
	private NhasanxuatRepository nhasanxuatRepository;

	@Override
	public Nhasanxuat getOne(Integer idnhasanxuat) {
		return nhasanxuatRepository.getOne(idnhasanxuat);
	}

	@Override
	public Boolean delete(Integer idnhasanxuat) {
		if (nhasanxuatRepository.getOne(idnhasanxuat) != null) {
			nhasanxuatRepository.deleteById(idnhasanxuat);
			return true;
		}
		return false;
	}

	@Override
	public Nhasanxuat create(Nhasanxuat nhasanxuat) {
		return nhasanxuatRepository.save(nhasanxuat);
	}

	@Override
	public Nhasanxuat update(Nhasanxuat nhasanxuatToUpdate) {
						Nhasanxuat nhasanxuat = nhasanxuatRepository.getOne(nhasanxuatToUpdate.getIdnhasanxuat());
										
				if(nhasanxuatToUpdate.getTennhasanxuat() !=null) {
			
		}
				return nhasanxuatRepository.save(nhasanxuat);
	}

	@Override
	public Boolean exist(Nhasanxuat nhasanxuat) {
						return nhasanxuatRepository.existsById(nhasanxuat.getIdnhasanxuat());
									}

	@Override
	public List<Nhasanxuat> findAll() {
		return nhasanxuatRepository.findAll();
	}

}
