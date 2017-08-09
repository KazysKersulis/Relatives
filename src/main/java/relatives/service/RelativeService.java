package relatives.service;

import org.springframework.stereotype.Service;
import relatives.dao.RelativeRepository;
import relatives.model.Relative;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RelativeService {

    private final RelativeRepository relativeRepository;

    public RelativeService(RelativeRepository relativeRepository) {
        this.relativeRepository = relativeRepository;
    }

    public List<Relative> findAll() {
        List<Relative> relatives = new ArrayList<Relative>();
        for (Relative relative : relativeRepository.findAll()){
            relatives.add(relative);
        }
        return relatives;
    }

    public void save(Relative relative) {
        relativeRepository.save(relative);
    }

    public void delete(int id) {
        relativeRepository.delete(id);
    }
}
