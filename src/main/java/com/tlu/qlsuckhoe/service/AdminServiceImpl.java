/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 22:38:40 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package com.tlu.qlsuckhoe.service;


import com.tlu.qlsuckhoe.entity.Admin;
import com.tlu.qlsuckhoe.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin getOne(Integer idadmin) {
		return adminRepository.findById(idadmin).get();
	}

	@Override
	public Boolean delete(Integer idadmin) {
		if (adminRepository.getOne(idadmin) != null) {
			adminRepository.deleteById(idadmin);
			return true;
		}
		return false;
	}

	@Override
	public Admin create(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin update(Admin adminToUpdate) {
						Admin admin = adminRepository.getOne(adminToUpdate.getIdadmin());
																		
				if(adminToUpdate.getTendangnhap() !=null) {
			
		}
				if(adminToUpdate.getMatkhau() !=null) {
			
		}
		if (adminToUpdate.getRole() != null) {
			
		}
				return adminRepository.save(admin);
	}

	@Override
	public Boolean exist(Admin admin) {
						return adminRepository.existsById(admin.getIdadmin());
																	}

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

}


