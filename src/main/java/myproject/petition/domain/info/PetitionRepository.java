package myproject.petition.domain.info;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PetitionRepository {
    private static final Map<Long, Petition> repo = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Petition save(Petition info){
        info.setId(++sequence);
        repo.put(info.getId(), info);
        return info;
    }

    public Petition findById(Long id){
        return repo.get(id);
    }

    public List<Petition> findAll(){
        return new ArrayList<>(repo.values());
    }

    public void updatePetition(Long petitionId, Petition updateParam){
        Petition findPetition = findById(petitionId);
        findPetition.setSubject(updateParam.getSubject());
        findPetition.setField(updateParam.getField());
        findPetition.setContent(updateParam.getContent());
    }

//    public void deletePetition(Long petitionId, Petition deleteParam){
//        repo.remove(petitionId, deleteParam);
//    }

    public void clearRepo(){
        repo.clear();
    }
}
