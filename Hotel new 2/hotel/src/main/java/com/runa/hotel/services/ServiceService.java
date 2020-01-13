package com.runa.hotel.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.runa.hotel.api.dao.IServiceDao;
import com.runa.hotel.api.dto.ServiceDto;
import com.runa.hotel.api.service.IServiceService;

@Service
@Transactional
public class ServiceService implements IServiceService {

	@Autowired
	private IServiceDao serviceDao;

	public List<ServiceDto> getAllServices() {
		return ServiceDto.convertList(serviceDao.getAll());
	}

	public com.runa.hotel.entities.Service addService(ServiceDto serviceDto) {
		com.runa.hotel.entities.Service service = new com.runa.hotel.entities.Service();
		service.setName(serviceDto.getName());
		service.setDailyPrice(serviceDto.getDailyPrice());
		service.setStatus(serviceDto.getStatus());
		return serviceDao.create(service);
	}

	public com.runa.hotel.entities.Service getServiceById(Long id) {
		return serviceDao.get(id);
	}

	public void updateService(Long id, ServiceDto serviceDto) {
		com.runa.hotel.entities.Service service = getServiceById(id);

		if (!StringUtils.isEmpty(serviceDto.getStatus())) {
			service.setStatus(serviceDto.getStatus());
		}
		if (service.getName() != null) {
			service.setName(serviceDto.getName());
		}
		if (service.getDailyPrice() != null) {
			service.setDailyPrice(serviceDto.getDailyPrice());
		}
		serviceDao.update(service);
	}

	public void deleteServiceById(Long id) {
		serviceDao.delete(getServiceById(id));
	}
}