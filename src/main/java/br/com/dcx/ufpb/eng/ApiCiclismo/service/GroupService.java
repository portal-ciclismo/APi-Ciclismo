package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.GroupDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Group;

import java.util.List;

public interface GroupService {

    public List<Group> getGroups();

    public Group saveGroup(Group group);

    public Group getGroupByid(Long id);

    public void deleteGroup(Long id);

    public void updateGroup(Long id, GroupDTO groupDTO);

    public List<Group> getGroupsByLocation(String location);
}
