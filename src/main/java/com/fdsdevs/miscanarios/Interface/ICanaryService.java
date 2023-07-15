package com.fdsdevs.miscanarios.Interface;

import com.fdsdevs.miscanarios.Models.Canary;

import java.util.List;

public interface ICanaryService {

    Canary createCanary(Canary canary);
    Canary getCanaryById(Long canaryId);
    List<Canary> getAllCanary();
    Canary updateCanary(Canary canary);
    void deleteCanary(Long canaryId);
}
