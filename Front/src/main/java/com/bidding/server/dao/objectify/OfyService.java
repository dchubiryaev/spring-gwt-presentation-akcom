package com.bidding.server.dao.objectify;

import com.bidding.server.domain.AppUser;
import com.google.appengine.api.datastore.ReadPolicy.Consistency;
import com.google.inject.Inject;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {

    static {
        ObjectifyService.register(AppUser.class);
        // TODO: register your classes which are used at datastore operations
    }

    @Inject
    public static void setObjectifyFactory(OfyFactory factory) {
        ObjectifyService.setFactory(factory);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy().consistency(Consistency.STRONG);
    }

    public static OfyFactory factory() {
        return (OfyFactory) ObjectifyService.factory();
    }
}
