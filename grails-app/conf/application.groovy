
// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.active = true
grails.plugin.springsecurity.rest.token.validation.useBearerToken = false

grails.plugin.springsecurity.securityConfigType = "Annotation"


grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.example.auth.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.example.auth.UserRole'
grails.plugin.springsecurity.rest.token.storage.jwt.secret =	'qrD6h8K6S9503Q06Y6Rfk21TErImPYqa'
grails.plugin.springsecurity.authority.className = 'com.example.auth.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	
        [
		pattern: '/api/**',
		filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
	],
        [pattern: '/**',             filters: 'JOINED_FILTERS']
]


     //grails.plugin.auditLog.verbose = true // verbosely log all changed values to db
     //grails.plugin.auditLog.logIds = true  // log db-ids of associated objects.
     //grails.plugin.auditLog.truncateLength = 1000
     //grails.plugin.auditLog.cacheDisabled = true  // only for 1.x. Disable caching of AuditDomainClass.
     //grails.plugin.auditLog.replacementPatterns = ["local.example.xyz.":""] // replace with empty string.
     grails.plugin.auditLog.actorClosure = { request, session ->
			session.user?.username	
        }
	 grails.plugin.auditLog.transactional = true	
		
     //grails.plugin.auditLog.stampEnabled = true
     //grails.plugin.auditLog.stampAlways = true




// Added by the Audit-Logging plugin:
//grails.plugin.auditLog.auditDomainClassName = 'com.example.Remito'



// Added by the Audit-Logging plugin:
grails.plugin.auditLog.auditDomainClassName = 'com.example.AuditDomain'



