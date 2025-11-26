package com.project.visioncare.services;

import com.project.visioncare.dtos.UniversityRecordDto;
import com.project.visioncare.dtos.UniversityResponseDto;
import com.project.visioncare.exceptions.NotFoundException;
import com.project.visioncare.models.UniversityModel;
import com.project.visioncare.repositories.UniversityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    private final String notFoundMessage = "University not found";

    public List<UniversityModel> listAll() {
        return universityRepository.findAll();
    }

    public UniversityModel getById(UUID id) {
        return universityRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));
    }

    public UUID create(UniversityRecordDto dto) {
        var m = new UniversityModel();
        BeanUtils.copyProperties(dto, m);
        return universityRepository.save(m).getId();
    }

    public UUID update(UUID id, UniversityRecordDto dto) {
        var m = universityRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(notFoundMessage));

        BeanUtils.copyProperties(dto, m);
        return universityRepository.save(m).getId();
    }

    public void delete(UUID id) {
        var found = universityRepository.findById(id);

        if (found.isEmpty()) throw new NotFoundException(notFoundMessage);

        universityRepository.delete(found.get());
    }

    public List<UniversityResponseDto> listAllForFront() {
        List<UniversityModel> universities = this.listAll();

        return universities.stream().map(u ->
                new UniversityResponseDto(
                        u.getId(),
                        u.getDescription(),
                        u.getAcronym(),
                        u.getImage(),
                        u.getTotalStudents(),
                        u.getCity(),
                        u.getActivePartnership(),
                        u.getDiscountPercent(),
                        u.getRating(),
                        this.mapColor(u.getAcronym()),
                        this.mapLogo(u.getAcronym())
                )
        ).toList();
    }

    private String mapColor(String acronym) {
        return switch (acronym) {
            case "USP" -> "from-blue-500 to-blue-600";
            case "UFRJ" -> "from-green-500 to-green-600";
            case "UNICAMP" -> "from-purple-500 to-purple-600";
            default -> "from-gray-500 to-gray-600";
        };
    }

    private String mapLogo(String acronym) {
        return switch (acronym) {
            case "USP" -> "🎓";
            case "UFRJ" -> "🏛️";
            case "UNICAMP" -> "🔬";
            default -> "📚";
        };
    }
}
