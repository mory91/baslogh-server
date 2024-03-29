package com.baslogh.baslogh.service;

import com.baslogh.baslogh.model.Case;
import com.baslogh.baslogh.model.User;
import com.baslogh.baslogh.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Service
public class CaseService {
    @Autowired
    private CaseRepository caseRepository;
    public Case submitCase (Case newCase){
        caseRepository.save(newCase);
        return newCase;
    }
    public Case setAuthor(Case case_, User author) {
        case_.setAuthor(author);
        return caseRepository.save(case_);
    }
    public List<Case> findByAuthor(User user){
        return caseRepository.findAllByAuthor(user);
    }
    public List<Case> findByReceiver(User user){
        return caseRepository.findAllByReceiver(user);
    }
    public Set<Case> filterBetweenDates (Date from, Date to) {
        return caseRepository.findByCreatedAtGreaterThanAndCreatedAtLessThan(from, to);
    }
    public Case findById(UUID id) {
        return caseRepository.findById(id).get();
    }
}
