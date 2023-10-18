package br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.GroupDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Group;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.GroupNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.LocationNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.repositories.GroupRepository;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceIMPL implements GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceIMPL(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getGroups() {return groupRepository.findAll();}

    @Override
    public Group saveGroup(Group group){return groupRepository.save(group);}

    @Override
    public Optional<Group> getGroupByid(Long id) throws GroupNotFoundException {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if(optionalGroup.isEmpty()){
            throw new GroupNotFoundException( "Group not found" );
        }
        return optionalGroup;
    }

    @Override
    public void deleteGroup(Long id) throws GroupNotFoundException{
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if(optionalGroup.isEmpty()){
            throw new GroupNotFoundException( "Group not found" );
        }
        groupRepository.deleteById(id);
    }

    @Override
    public void updateGroup(Long id, GroupDTO groupDTO) throws GroupNotFoundException{
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if(optionalGroup.isEmpty()){
            throw new GroupNotFoundException( "Group not found" );
        }
        Group group = optionalGroup.get();
        group.setDescription(groupDTO.getDescription());
        group.setLocation(groupDTO.getLocation());
        groupRepository.save(group);
    }

    @Override
    public List<Group> getGroupsByLocation(String location) throws LocationNotFoundException {
        try{
            return groupRepository.findByLocation(location);
        } catch (Exception e){
            throw new LocationNotFoundException("Location not Found");
        }
    }

}
