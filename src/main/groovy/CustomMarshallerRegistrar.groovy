import grails.converters.JSON

class CustomMarshallerRegistrar {
    @javax.annotation.PostConstruct
    void registerMarshallers() {
        JSON.registerObjectMarshaller(org.bson.types.ObjectId) {
            return [uuid: it as String, date: it.date]
        }
    }
}
