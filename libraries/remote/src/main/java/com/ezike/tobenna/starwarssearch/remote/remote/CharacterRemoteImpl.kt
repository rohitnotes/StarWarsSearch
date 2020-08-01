package com.ezike.tobenna.starwarssearch.remote.remote

import com.ezike.tobenna.starwarssearch.data.contract.CharacterRemote
import com.ezike.tobenna.starwarssearch.data.model.CharacterEntity
import com.ezike.tobenna.starwarssearch.remote.ApiService
import com.ezike.tobenna.starwarssearch.remote.mapper.CharacterRemoteModelMapper
import com.ezike.tobenna.starwarssearch.remote.model.CharacterSearchResponse
import javax.inject.Inject

class CharacterRemoteImpl @Inject constructor(
    private val apiService: ApiService,
    private val characterRemoteModelMapper: CharacterRemoteModelMapper
) : CharacterRemote {

    override suspend fun searchCharacters(characterName: String): List<CharacterEntity> {
        val characters: CharacterSearchResponse = apiService.searchCharacters(characterName)
        return characterRemoteModelMapper.mapModelList(characters.results)
    }
}