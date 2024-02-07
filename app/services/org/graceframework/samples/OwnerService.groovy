package org.graceframework.samples

import grails.gorm.services.Service

@Service(Owner)
interface OwnerService {

    Owner get(Serializable id)

    List<Owner> list(Map args)

    Long count()

    void delete(Serializable id)

    Owner save(Owner owner)

}