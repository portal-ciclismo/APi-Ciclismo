package br.com.dcx.ufpb.eng.ApiCiclismo.controller;

import br.com.dcx.ufpb.eng.ApiCiclismo.dto.GroupDTO;
import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Group;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.GroupNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.exception.LocationNotFoundException;
import br.com.dcx.ufpb.eng.ApiCiclismo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GroupController {

    @Autowired
    GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Group saveGroup(@RequestBody Group group){
        return groupService.saveGroup(group);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Group> getGroupById(@PathVariable Long id) throws GroupNotFoundException {
        return groupService.getGroupByid(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGroup(@PathVariable Long id) throws GroupNotFoundException {
        groupService.deleteGroup(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGroup(@PathVariable Long id, @RequestBody GroupDTO group) throws GroupNotFoundException {
        groupService.updateGroup(id, group);
    }

    @GetMapping("/groups/{location}")
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getGroupsByLocation(@PathVariable String location) throws LocationNotFoundException {
        return groupService.getGroupsByLocation(location);
    }
}
