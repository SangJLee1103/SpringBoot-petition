package myproject.petition.domain.info;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PetitionRepository {
    private static final Map<Long, Info> repo = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Info save(Info info){
        info.setId(++sequence);
        repo.put(info.getId(), info);
        return info;
    }

    public Info findById(Long id){
        return repo.get(id);
    }

    public List<Info> findAll(){
        return new ArrayList<>(repo.values());
    }

    public void updateInfo(Long infoId, Info updateParam){
        Info findInfo = findById(infoId);
        findInfo.setSubject(updateParam.getSubject());
        findInfo.setField(updateParam.getField());
        findInfo.setContent(updateParam.getContent());
    }

    public void deleteInfo(Long infoId, Info deleteParam){
        Info findInfo = findById(infoId);
        repo.remove(findInfo);
    }
}
