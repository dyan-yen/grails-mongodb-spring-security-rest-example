package com.dyan.ex

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured(['ROLE_USER'])
class PersonController extends RestfulController {

    static responseFormats = ['json']

    PersonController() {
        super(Person)
    }
}
