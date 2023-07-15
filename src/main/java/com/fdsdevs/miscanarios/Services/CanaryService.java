package com.fdsdevs.miscanarios.Services;

import com.fdsdevs.miscanarios.Interface.ICanaryService;
import com.fdsdevs.miscanarios.Models.Canary;
import com.fdsdevs.miscanarios.Repository.CanaryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class CanaryService implements ICanaryService {

    private CanaryRepository canaryRepository;

    public List<Canary> findCanariesByUserId(Long userId){
        return canaryRepository.findCanariesByUserId(userId);
    }
    @Override
    public Canary createCanary(Canary canary) {
        return canaryRepository.save(canary);
    }

    @Override
    public Canary getCanaryById(Long canaryId) {
       Optional<Canary> optionalCanary = canaryRepository.findById(canaryId);
        return optionalCanary.get();
    }

    @Override
    public List<Canary> getAllCanary() {
        return canaryRepository.findAll();
    }

    @Override
    public Canary updateCanary(Canary canary) {
        Canary existingCanary = canaryRepository.findById(canary.getId()).get();
        existingCanary.setOrigin(canary.getOrigin());
        existingCanary.setRingNumber(canary.getRingNumber());
        existingCanary.setGender(canary.getGender());
        existingCanary.setNomenclature(canary.getNomenclature());
        existingCanary.setRingColor(canary.getRingColor());
        existingCanary.setStatus(canary.getStatus());
        existingCanary.setStatusNotes(canary.getStatusNotes());
        existingCanary.setIdFather(canary.getIdFather());
        existingCanary.setIdMother(canary.getIdMother());
        existingCanary.setNotes(canary.getNotes());
        existingCanary.setYear(canary.getYear());
        existingCanary.setStance(canary.getStance());
        existingCanary.setDateCreation(canary.getDateCreation());
        existingCanary.setDateUpdate(new Date());
        canaryRepository.save(existingCanary);
        return existingCanary;
    }

    @Override
    public void deleteCanary(Long canaryId) {
        canaryRepository.deleteById(canaryId);
    }
}
