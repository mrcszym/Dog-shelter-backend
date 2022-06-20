package com.mrc.dogspring.service;

import com.mrc.dogspring.domain.ApplicationForm;
import com.mrc.dogspring.repo.AppFormRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AppFormServiceImpl implements AppFormService {

    private final AppFormRepo appFormRepo;

    @Override
    public ApplicationForm saveForm(ApplicationForm applicationForm) {
        return appFormRepo.save(applicationForm);
    }

    @Override
    public ApplicationForm getForm(int id) {
        return appFormRepo.findById(id);
    }

    @Override
    public List<ApplicationForm> getForms() {
        return appFormRepo.findAll();
    }

    @Override
    public void deleteForm(Long id) {
        appFormRepo.deleteById(id);
    }

    @Override
    public void acceptForm(Long id) {
        System.out.println("acceptForm in progress");
    }

    @Override
    public void updatedecline(Long id) {
        System.out.println("updateDecline in progress");
    }
}
