package relucky.code.testapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import relucky.code.testapi.exception.EntityNotFoundException;
import relucky.code.testapi.model.dto.CatDTO;
import relucky.code.testapi.model.entity.Cat;
import relucky.code.testapi.repository.CatRepository;
import relucky.code.testapi.service.CatService;

import java.util.List;

/**
 * @author yernuromirzak
 * 03.08.2024
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CatServiceImpl implements CatService {
    private final CatRepository catRepository;

    @Override
    public CatDTO save(CatDTO catDTO) {
        log.info("Save cat: {}", catDTO);
        return toDTO(catRepository.save(toCat(catDTO)));
    }

    @Override
    public CatDTO findById(Long id) {
        log.info("Find cat by id: {}", id);
        return toDTO(catRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found")));
    }

    @Override
    public List<CatDTO> findAll() {
        log.info("Find all cats");
        return catRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public void delete(Long id) {
        catRepository.deleteById(id);
        log.info("Deleted Cat: {}", id);
    }

    @Override
    public CatDTO update(CatDTO catDTO, Long id) {
        log.info("Update cat: {}", catDTO);
        Cat cat = catRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
        Cat catV2 = Cat.builder()
                .id(cat.getId())
                .name(catDTO.name() != null ? catDTO.name() : cat.getName())
                .age(catDTO.age() != null ? catDTO.age() : cat.getAge())
                .gender(catDTO.gender() != null ? catDTO.gender() : cat.getGender())
                .build();

        return toDTO(catRepository.save(catV2));
    }

    private CatDTO toDTO(Cat cat) {
        return CatDTO.builder()
                .id(cat.getId())
                .age(cat.getAge())
                .gender(cat.getGender())
                .name(cat.getName())
                .build();
    }

    private Cat toCat(CatDTO catDTO) {
        return Cat.builder()
                .name(catDTO.name())
                .age(catDTO.age())
                .gender(catDTO.gender())
                .build();
    }
}
