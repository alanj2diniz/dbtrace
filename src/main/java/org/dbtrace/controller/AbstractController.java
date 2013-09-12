package org.dbtrace.controller;

import org.dbtrace.entity.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.Serializable;

public class AbstractController implements Serializable {

    private static final long serialVersionUID = 1L;

    protected void setMessage(String message) {
        setMessage(null, message);
    }

    protected void setMessageGrowl(Severity severity, String message) {
        setMessage(severity, null, message);
    }

    protected void setMessage(Severity severity, String clientId, String message) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(severity, message, message));
    }

    protected void setMessage(String clientId, String message) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(message));
    }

    public void putSession(String key, Object object) {
        getExternalContext().getSessionMap().put(key, object);
    }

    public Object getSession(String key) {
        return getExternalContext().getSessionMap().get(key);
    }

    public void removeSession(String key) {
        getExternalContext().getSessionMap().remove(key);
    }

    public void clearSession() {
        getExternalContext().getSessionMap().clear();
    }

    protected void getMessageCadastroSucesso() {
        setMessage(FacesMessage.SEVERITY_INFO, null, "Cadastro Salvo com Sucesso!");
    }

    protected void getMessageInstabilidade() {
        setMessage(FacesMessage.SEVERITY_ERROR, null, "Instabilidades ao Salvar!");
    }

    protected String getParametro(String parametro) {
        return getExternalContext().getRequestParameterMap().get(parametro);
    }

    protected void redirect(String fullUrl) {
        try {
            getExternalContext().redirect(fullUrl);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Usuario getUsuarioLogado() {
        return (Usuario) getSession("USUARIO");
    }

    protected ExternalContext getExternalContext() {
        return FacesContext.getCurrentInstance().getExternalContext();
    }

    public String getNomeUsuarioLogado() {
        if (getExternalContext().getUserPrincipal() != null) {
            return getExternalContext().getUserPrincipal().getName();
        } else {
            return "";
        }
    }

    public String getNome() {
        HttpServletRequest request = (HttpServletRequest) getExternalContext().getRequest();
        if (request.getUserPrincipal() != null && getSession("USUARIO") != null) {
            return ((Usuario) getSession("USUARIO")).getNome();
        } else {
            return null;
        }
    }

    protected void flashScope() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
    }

    protected void invalidadeSession() {
        try {
            HttpServletRequest request = (HttpServletRequest) getExternalContext().getRequest();
            request.getSession().invalidate();
        } catch (Exception e) {
        }
        redirect("/login.xhtml");
    }
}
