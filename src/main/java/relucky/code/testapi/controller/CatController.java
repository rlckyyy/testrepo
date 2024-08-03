package relucky.code.testapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import relucky.code.testapi.model.dto.CatDTO;
import relucky.code.testapi.service.CatService;

import java.util.List;

/**
 * @author yernuromirzak
 * 03.08.2024
 */
@RestController
@RequestMapping("/api/v1/cat")
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;

    @GetMapping
    public List<CatDTO> getAll() {
        return catService.findAll();
    }

    @GetMapping("/{id}")
    public CatDTO getById(@PathVariable("id") Long id) {
        return catService.findById(id);
    }

    @PostMapping
    public CatDTO create(@RequestBody CatDTO catDTO) {
        return catService.save(catDTO);
    }

    @PutMapping("/{id}")
    public CatDTO update(@PathVariable Long id, @RequestBody CatDTO catDTO) {
        return catService.update(catDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        catService.delete(id);
    }
}
