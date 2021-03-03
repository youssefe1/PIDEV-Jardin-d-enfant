package com.esprit.spring.service;

import java.util.List;

import com.esprit.spring.entities.JDF;

public interface IJDFService {
	public List<JDF> listjdf();
	public void deleteJdfById(Long ide);
	public Long ajouterjdf(JDF jdf);
	public void mettreAjourJDFById(JDF jdf, Long id);

}
