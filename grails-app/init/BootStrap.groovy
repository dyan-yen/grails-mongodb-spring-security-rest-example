import com.dyan.auth.Role
import com.dyan.auth.User
import com.dyan.auth.UserRole
import com.dyan.ex.Address
import com.dyan.ex.Person

class BootStrap {

    def init = { servletContext ->
        new CustomMarshallerRegistrar().registerMarshallers()

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

                // spring security Users & Roles
                Role userRole = new Role(authority: "ROLE_USER").save(flush: true)
                Role adminRole = new Role(authority: "ROLE_ADMIN").save(flush: true)

                User user = new User(username: "user", password: "password").save(flush: true)
                User admin = new User(username: "admin", password: "password").save(flush: true)

                UserRole.create(user, userRole, true)
                UserRole.create(admin, adminRole, true)
            }
        }
    }
    def destroy = {
    }
}
