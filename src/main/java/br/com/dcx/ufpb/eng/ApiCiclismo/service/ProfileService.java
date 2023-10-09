package br.com.dcx.ufpb.eng.ApiCiclismo.service;

import br.com.dcx.ufpb.eng.ApiCiclismo.entity.Profile;
import br.com.dcx.ufpb.eng.ApiCiclismo.enums.CyclingCategory;
import org.hibernate.usertype.UserType;

import java.util.List;

public interface ProfileService {

        public ProfileService saveProfile(ProfileService profile);

        public Profile getProfileById(Long id);

        public void deleteProfile(Long id);

        public List<ProfileService> getProfilesByFullName(String fullName);

        public List<ProfileService> getProfilesByNickname(String nickname);

        public List<ProfileService> getProfilesByCyclingCategory(CyclingCategory cyclingCategory);

        public List<ProfileService> getProfilesByUserType(UserType userType);

        public List<ProfileService> getProfilesByLocation(String location);

        public ProfileService updateProfile(Long id, ProfileService updatedProfile);

    }

