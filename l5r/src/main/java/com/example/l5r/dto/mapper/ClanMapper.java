package com.example.l5r.dto.mapper;

import com.example.l5r.dto.ClanDTO;
import com.example.l5r.model.Clan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClanMapper {

    @Mappings({
            @Mapping(source = "families", target = "families")})
    Clan toClan(ClanDTO clanDTO);

    @Mappings({
            @Mapping(source = "families", target = "families")})
    ClanDTO toClanDTO(Clan clan);
}
