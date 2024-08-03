package relucky.code.testapi.model.dto;

import lombok.Builder;
import relucky.code.testapi.model.enums.Gender;

/**
 * @author yernuromirzak
 * 03.08.2024
 */
@Builder(toBuilder = true)
public record CatDTO(
        Long id,
        String name,
        Integer age,
        Gender gender
) {
}
