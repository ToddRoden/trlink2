package trlinks2

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DocLinkController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DocLink.list(params), model:[docLinkCount: DocLink.count()]
    }

    def show(DocLink docLink) {
        respond docLink
    }

    def create() {
        respond new DocLink(params)
    }

    @Transactional
    def save(DocLink docLink) {
        if (docLink == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (docLink.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond docLink.errors, view:'create'
            return
        }

        docLink.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'docLink.label', default: 'DocLink'), docLink.id])
                redirect docLink
            }
            '*' { respond docLink, [status: CREATED] }
        }
    }

    def edit(DocLink docLink) {
        respond docLink
    }

    @Transactional
    def update(DocLink docLink) {
        if (docLink == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (docLink.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond docLink.errors, view:'edit'
            return
        }

        docLink.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'docLink.label', default: 'DocLink'), docLink.id])
                redirect docLink
            }
            '*'{ respond docLink, [status: OK] }
        }
    }

    @Transactional
    def delete(DocLink docLink) {

        if (docLink == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        docLink.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'docLink.label', default: 'DocLink'), docLink.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'docLink.label', default: 'DocLink'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
