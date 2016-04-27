import com.dyan.ex.Address
import com.dyan.ex.Person

class BootStrap {

    def init = { servletContext ->
        environments {
            production {

            }

            development {
                def db = "grails-ex-db"

                // drop DB
                Person.withDatabase(db) {
                    it.drop()
                }

                // create DB if it doesn't exist
                Person.withDatabase(db) {
                    new Person(
                            name: "SpongeBob",
                            address: new Address(
                                    city: "New York",
                                    state: "New York",
                                    line1: "100 Park Ave.")
                    ).save(flush: true)

                    def patrick = new Person(
                            name: "Patrick",
                            address: new Address(
                                    city: "Seattle",
                                    state: "Washington",
                                    line1: "200 Main St.")
                    ).save(flush: true)

                    patrick['aka'] = "Sea Star"
                    patrick.save(flush: true)
                }
            }
        }
    }
    def destroy = {
    }
}
