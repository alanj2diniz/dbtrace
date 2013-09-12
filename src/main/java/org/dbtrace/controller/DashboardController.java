package org.dbtrace.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class DashboardController extends AbstractController {
    
    private static final long serialVersionUID = 1L;
    
    int i = 0;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
    
}