package com.example.ludotheque.services;

import com.example.ludotheque.bo.DetailLocation;
import com.example.ludotheque.dal.IDetailLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailLocationService implements IDetailLocationService {

    private final IDetailLocationRepository detailLocationService;

    public DetailLocationService(IDetailLocationRepository detailLocationService) {
        this.detailLocationService = detailLocationService;
    }

    @Override
    public void add(DetailLocation detailDetailLocation) { detailLocationService.add(detailDetailLocation);
    }

    @Override
    public List<DetailLocation> getAll() {
        return detailLocationService.getAll();
    }

    @Override
    public Optional<DetailLocation> getById(int id) {
        return detailLocationService.getById(id);
    }

    @Override
    public void update(DetailLocation detailDetailLocation) { detailLocationService.update(detailDetailLocation);
    }

    @Override
    public void delete(int id) { detailLocationService.delete(id);
    }
}
