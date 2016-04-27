package com.dyan.ex

import org.bson.types.ObjectId

class Person {

    ObjectId id
    String name
    Address address

    static embedded = ['address']

    static constraints = {
        address nullable: true
    }
}

