package com.mrc.dogspring.service;

import com.mrc.dogspring.domain.ApplicationForm;

import java.util.List;

public interface AppFormService {

    ApplicationForm saveForm(ApplicationForm applicationForm);
    ApplicationForm getForm(int id);
    List<ApplicationForm> getForms();
    void deleteForm(Long id);
    void acceptForm(Long id);
    void updatedecline(Long id);
}
