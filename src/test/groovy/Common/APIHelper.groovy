package Common

import groovyx.net.http.RESTClient


class APIHelper {

    static getAPIResponse(ourPath){
        RESTClient restClient = new RESTClient("http://jsonplaceholder.typicode.com")
        def response = restClient.get(headers:[contentType: 'application/json',path:ourPath])
        return response.status
    }

}
