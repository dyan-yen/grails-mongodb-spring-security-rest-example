// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.dyan.auth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.dyan.auth.UserRole'
grails.plugin.springsecurity.authority.className = 'com.dyan.auth.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain, http://alvarosanchez.github.io/grails-spring-security-rest/latest/docs/#_plugin_configuration
        [pattern: '/api/**', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter']
]

