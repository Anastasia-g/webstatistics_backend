package com.webstat.backend.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteVisitEventRepository extends JpaRepository<SiteVisitEvent, Integer>, CustomRepository{

}
