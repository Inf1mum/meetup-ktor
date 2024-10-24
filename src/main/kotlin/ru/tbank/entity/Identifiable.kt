package ru.tbank.entity

import org.bson.types.ObjectId

interface Identifiable {
    var id: ObjectId?
}
