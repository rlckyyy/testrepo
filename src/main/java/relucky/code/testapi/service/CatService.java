package relucky.code.testapi.service;

import relucky.code.testapi.model.dto.CatDTO;

import java.util.List;

public interface CatService {
    CatDTO save(CatDTO catDTO);

    CatDTO findById(Long id);

    List<CatDTO> findAll();

    void delete(Long id);

    CatDTO update(CatDTO catDTO, Long id);
}
