package org.openapitools.client.api;

import org.openapitools.client.ApiClient;

import org.openapitools.client.model.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;


public class FakeClassnameTags123Api {
    private ApiClient apiClient;

    public FakeClassnameTags123Api() {
        this(new ApiClient());
    }

    @Autowired
    public FakeClassnameTags123Api(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * To test class name in snake case
     * To test class name in snake case
     * <p><b>200</b> - successful operation
     * @param body client model
     * @return Client
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Client> testClassname(Client body) throws WebClientResponseException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new WebClientResponseException("Missing the required parameter 'body' when calling testClassname", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "api_key_query" };

        ParameterizedTypeReference<Client> localVarReturnType = new ParameterizedTypeReference<Client>() {};
        return apiClient.invokeAPI("/fake_classname_test", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
