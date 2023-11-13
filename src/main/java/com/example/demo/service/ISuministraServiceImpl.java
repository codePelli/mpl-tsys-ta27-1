package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SuministraDAO;
import com.example.demo.dto.Suministra;


@Service
public class ISuministraServiceImpl implements ISuministraService{

	@Autowired
	SuministraDAO iSumServ;
	
	@Override
	public List<Suministra> listSuministra() {
		// TODO Auto-generated method stub
		return iSumServ.findAll();
	}

	@Override
	public Suministra sumPorId(int id) {
		// TODO Auto-generated method stub
		return iSumServ.findById(id).get();
	}

	@Override
	public Suministra saveSuministra(Suministra suministra) {
		// TODO Auto-generated method stub
		return iSumServ.save(suministra);
	}

	@Override
	public Suministra updateSuministra(Suministra suministra) {
		// TODO Auto-generated method stub
		return iSumServ.save(suministra);
	}

	@Override
	public void deleteSuministra(int id) {
		// TODO Auto-generated method stub
		iSumServ.deleteById(id);
	}

}
