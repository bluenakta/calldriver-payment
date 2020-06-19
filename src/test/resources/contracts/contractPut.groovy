package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'PUT'
        url ('/pays/canceled/1')
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body(
                callId: 1,
                payStatus: "Canceled"
        )
        bodyMatchers {
            jsonPath('$.callId', byRegex(nonEmpty()).asLong())
            jsonPath('$.payStatus', byRegex(nonEmpty()).asString())
        }
        headers {
            contentType(applicationJson())
        }
    }
}