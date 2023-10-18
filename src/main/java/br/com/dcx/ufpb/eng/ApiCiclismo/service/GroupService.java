package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.GroupDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Group;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.GroupNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.LocationNotFoundException;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    public List<Group> getGroups();

    public Group saveGroup(Group group);

    public Optional<Group> getGroupByid(Long id) throws GroupNotFoundException;

    public void deleteGroup(Long id) throws GroupNotFoundException;

    public void updateGroup(Long id, GroupDTO groupDTO) throws GroupNotFoundException;

    public List<Group> getGroupsByLocation(String location) throws LocationNotFoundException;
}
