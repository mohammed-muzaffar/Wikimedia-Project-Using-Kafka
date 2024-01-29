package com.vff.kafkaconsumerdatabase.repository;

import com.vff.kafkaconsumerdatabase.Entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
