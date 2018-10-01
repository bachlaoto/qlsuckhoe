/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 22:38:43 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;


import com.tlu.qlsuckhoe.entity.Thuoc;
import com.tlu.qlsuckhoe.repository.ThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ThuocServiceImpl implements ThuocService {

	@Autowired
	private ThuocRepository thuocRepository;

	@Override
	public Thuoc getOne(Integer idthuoc) {
		return thuocRepository.findById(idthuoc).get();
	}

	@Override
	public Boolean delete(Integer idthuoc) {
		if (thuocRepository.getOne(idthuoc) != null) {
			thuocRepository.deleteById(idthuoc);
			return true;
		}
		return false;
	}

	@Override
	public Thuoc create(Thuoc thuoc) {
		return thuocRepository.save(thuoc);
	}

	@Override
	public Thuoc update(Thuoc thuocToUpdate) {
						Thuoc thuoc = thuocRepository.getOne(thuocToUpdate.getIdthuoc());

		if (thuocToUpdate.getLoaithuoc() != null) {
			
		}
		if (thuocToUpdate.getNhasanxuat() != null) {
			
		}
				if(thuocToUpdate.getTenthuoc() !=null) {
			
		}
				if(thuocToUpdate.getTacdung() !=null) {
			
		}
				if(thuocToUpdate.getCachdung() !=null) {
			
		}
				if(thuocToUpdate.getNgaynhap() !=null) {
			
		}
				if(thuocToUpdate.getSoluong() !=null) {
			
		}
				return thuocRepository.save(thuoc);
	}

	@Override
	public Boolean exist(Thuoc thuoc) {
						return thuocRepository.existsById(thuoc.getIdthuoc());
																																	}

	@Override
	public List<Thuoc> findAll() {
		return thuocRepository.findAll();
	}

}


