package com.pid.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pid.main.model.MasterList;

public interface MasterListRepository extends JpaRepository<MasterList, Integer> {

	@Query("SELECT m FROM MasterList m Where m.pidDevice.id=?1")
	public List<MasterList> getAlltemplatesByDeviceId(Integer id);
}
