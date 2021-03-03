package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
