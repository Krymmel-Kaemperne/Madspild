package com.example.madspild.Service;

import com.example.madspild.Model.CompanyUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CompanyUserService {

    //OPRET EN AUTOWIRE TIL REPO
    private List<CompanyUser> companyUsers = new ArrayList<>();
    private int nextId = 1;

    public List<CompanyUser> getAllCompanyUsers() {
        return null;
    }

    public void addCompanyUser(CompanyUser user) {
        user.setCompanyId(nextId++);
        companyUsers.add(user);
    }

    public CompanyUser findCompanyUserById(int id) {
        for(CompanyUser user: companyUsers) {
            if(user.getCompanyId() == id) {
                return user;
            }
        }
        return null;
    }

    public CompanyUser findCompanyUserByEmailAndPassword(String email, String password) {
        for(CompanyUser user: companyUsers) {
            if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public CompanyUser findCompanyUserByEmail(String email) {
        for(CompanyUser user: companyUsers) {
            if(user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public void deleteCompanyUser(int id) {
        companyUsers.removeIf(user -> user.getCompanyId() == id);
    }

    public void updateCompanyUser(CompanyUser cp) {
        deleteCompanyUser(cp.getCompanyId());
        companyUsers.add(cp);
    }

}
