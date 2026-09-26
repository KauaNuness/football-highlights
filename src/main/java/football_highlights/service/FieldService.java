package football_highlights.service;

import football_highlights.dto.FieldRequest;
import football_highlights.entity.Field;
import football_highlights.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldService {

    private final FieldRepository fieldRepository;

    private Field create(FieldRequest request){

        Field field = Field.builder()
                .name(request.name())
                .address(request.address())
                .build();

        return fieldRepository.save(field);

    }

    public List<Field> findAll(){
        return fieldRepository.findAll();
    }

    public Field findById(Long id){
        return fieldRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Campo não encontrado"));
    }


}
