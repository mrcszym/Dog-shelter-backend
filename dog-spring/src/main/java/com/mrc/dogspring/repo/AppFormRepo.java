package com.mrc.dogspring.repo;

import com.mrc.dogspring.domain.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppFormRepo extends JpaRepository<ApplicationForm, Long> {
    ApplicationForm findById(int id);

}
