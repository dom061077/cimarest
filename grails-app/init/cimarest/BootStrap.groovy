package cimarest

import com.cima.auth.Role
import com.cima.auth.User
import com.cima.auth.UserRole

class BootStrap {

    def init = { servletContext ->
        User.withTransaction {
            
            /*Role role = new Role(authority: "ROLE_USER").save(failOnError:true)
            User user = new User(username: "me", password: "password").save(failOnError:true)
            UserRole.create(user, role)*/
        }         
    }
    def destroy = {
    }
}
