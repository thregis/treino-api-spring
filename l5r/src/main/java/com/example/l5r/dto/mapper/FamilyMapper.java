package com.example.l5r.dto.mapper;

import com.example.l5r.dto.FamilyDTO;
import com.example.l5r.model.Family;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FamilyMapper {

    @Mappings({
            @Mapping(source = "clanId", target = "clan.id"),
            @Mapping(source = "clanName", target = "clan.name")
    })
    Family toFamily(FamilyDTO familyDTO);

    @Mappings({
            @Mapping(source = "clan.id", target = "clanId"),
            @Mapping(source = "clan.name", target = "clanName")
    })
    FamilyDTO toFamilyDTO(Family family);
}
