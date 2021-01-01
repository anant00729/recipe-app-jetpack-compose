package com.an2t.moviereviewapp.util

interface DomainMapper <T, DomainModel>{
  fun mapToDomainModel(model: T): DomainModel
  fun mapFromDomainModel(domainModel: DomainModel): T
}