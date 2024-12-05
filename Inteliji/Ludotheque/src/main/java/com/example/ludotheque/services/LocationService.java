package com.example.ludotheque.services;

import com.example.ludotheque.bo.Location;
import com.example.ludotheque.dal.ILocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements ILocationService {

    private final ILocationRepository locationRepository;

    public LocationService(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void add(Location location) {
    locationRepository.add(location);
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.getAll();
    }

    @Override
    public Optional<Location> getById(int id) {
        return locationRepository.getById(id);
    }

    @Override
    public void update(Location location) {
        locationRepository.update(location);
    }

    @Override
    public void delete(int id) {
        locationRepository.delete(id);
    }
}
