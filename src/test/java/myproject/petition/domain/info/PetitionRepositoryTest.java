package myproject.petition.domain.info;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class PetitionRepositoryTest {
    PetitionRepository petitionRepository = new PetitionRepository();

    @AfterEach
    void after(){
        petitionRepository.clearRepo();
    }

    @Test
    void save(){
        Petition petition = new Petition("국민청원", "국방", "1사단 GOP 철책 뚫림");
        Petition savePetition = petitionRepository.save(petition);

        Petition findPetition = petitionRepository.findById(savePetition.getId());
        assertThat(findPetition).isEqualTo(savePetition);
    }

    @Test
    void findAll(){
        Petition petition1 = new Petition("국민청원", "국방", "1사단 GOP 철책 뚫림");
        Petition petition2 = new Petition("국민청원", "보건/복지", "백신패스 폐지");
        petitionRepository.save(petition1);
        petitionRepository.save(petition2);

        List<Petition> petitionList = petitionRepository.findAll();
        petitionList.add(petition1);
        petitionList.add(petition2);

        assertThat(petitionList).contains(petition1, petition2);
    }

    @Test
    void updatePetition(){
        Petition petition1 = new Petition("국민청원", "국방", "1사단 GOP 철책 뚫림");
        Petition savePetition = petitionRepository.save(petition1);
        Long id = savePetition.getId();

        Petition updateParam = new Petition("국민청원", "보건/복지", "백신패스 폐지");
        petitionRepository.updatePetition(id, updateParam);

        Petition findPetition = petitionRepository.findById(id);
        assertThat(findPetition.getSubject()).isEqualTo(updateParam.getSubject());
        assertThat(findPetition.getField()).isEqualTo(updateParam.getField());
        assertThat(findPetition.getContent()).isEqualTo(updateParam.getContent());
    }

    @Test
    void deletePetition(){
        Petition petition = new Petition("국민청원", "국방", "1사단 GOP 철책 뚫림");



    }
}