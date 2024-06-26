package com.seonhui.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

	@Autowired
	private LocationDAO locationDAO;

	public List<LocationDTO> getList() throws Exception {
		return locationDAO.getList();
	}

	public LocationDTO getDetail(int num) throws Exception {
		return locationDAO.getDetail(num);
	}

	public int add(LocationDTO locationDTO) throws Exception {
		return locationDAO.add(locationDTO);
	}
}
