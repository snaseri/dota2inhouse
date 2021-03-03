package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociatedSkillServiceImpl implements AssociatedSkillService {

    private AssociatedSkillRepository associatedSkillRepository;

    public AssociatedSkillServiceImpl(AssociatedSkillRepository repository){associatedSkillRepository = repository;}

    @Override
    public Optional<AssociatedSkill> findByASIndex(long id){return associatedSkillRepository.findById(id);}

    @Override
    public List<AssociatedSkill> findBySkillName(String searchTerm) {
        return associatedSkillRepository.findABySkillName(searchTerm);
    }

    @Override
    public void deleteAssociatedSkillsByUserId(long id) {
        associatedSkillRepository.deleteAssociatedSkillsByUserId(id);
    }


    @Override
    public List<AssociatedSkill> findByuser_id(long id) {

        return associatedSkillRepository.findByuser_id(id);
    }


}

