/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.nadajp.myapplication.backend;

import com.example.JokeTeller;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.nadajp.example.com",
    ownerName = "backend.myapplication.nadajp.example.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyJoke sayHi(@Named("name") String name) {
        MyJoke response = new MyJoke();
        response.setData("Hi, " + name);

        return response;
    }

    /** An endpoint method that takes jokes from joketeller lib and returns them to client */
    @ApiMethod(name = "getJoke")
    public MyJoke getJokes() {
        MyJoke response = new MyJoke();
        JokeTeller jokeTeller = new JokeTeller();
        response.setData(jokeTeller.getJoke());
        return response;
    }


}
