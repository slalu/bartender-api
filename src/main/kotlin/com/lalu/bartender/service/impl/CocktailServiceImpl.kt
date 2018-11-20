package com.lalu.bartender.service.impl

import com.lalu.bartender.domain.Cocktail
import com.lalu.bartender.repository.Repository
import com.lalu.bartender.repository.specification.CocktailsByIdSpecification
import com.lalu.bartender.service.CocktailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CocktailServiceImpl() : CocktailService {

    @Autowired
    private lateinit var cocktailRepository: Repository<Cocktail>
    
    override fun findById(id: Int): Cocktail {
        return cocktailRepository.query(CocktailsByIdSpecification(id)).toList().single()
    }
}
