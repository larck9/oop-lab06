/**
 *
 */

package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 *
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     *
     * think of what type of keys and values would best suit the requirements
     */
    private final static int DEF_AGE=-1;
     Map<String,Set<U>> userMap =new HashMap<>();    //mappa -> , mappa di nomegruppo e set utenti
    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */

     public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, DEF_AGE);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    
    public boolean addFollowedUser(final String group, final U user) {
    if (group == null || user == null) {
        return false; // Null values are not allowed
    }
    
    // Create the group if it does not exist
    userMap.putIfAbsent(group, new HashSet<>());
   
    // Try to add the user to the group
    return userMap.get(group).add(user); // Returns true only if user was not already present
}

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        if (!userMap.containsKey(groupName) || groupName ==null){
            return Collections.emptyList();
        }
        else{
            return new HashSet<>(userMap.get(groupName));
        }
        
    }

    @Override
    public List<U> getFollowedUsers() {
        Set<U> res = new HashSet<>();
        for (Set<U> group:userMap.values()){
            res.addAll(group);
        }
        return List.copyOf(res);
    }
}
