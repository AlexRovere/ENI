package com.example.ludotheque.services;

import com.example.ludotheque.bo.DetailLocation;
import com.example.ludotheque.bo.Location;
import com.example.ludotheque.dal.ILocationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

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

    public float calculateTotalPrice(Location location) {
        float result = 0;
        LocalDate startDate = location.getDateDebutLocation();
        if (startDate == null) return result;

        for (DetailLocation detail : location.getDetails()) {
            LocalDate endDate = detail.getDateRetour();
            if (endDate == null) continue;

            float tarif = detail.getTarifLocation();

            long days = DAYS.between(startDate, endDate) + 1;

            result += days * tarif;
        }
        return result;
    };

}
