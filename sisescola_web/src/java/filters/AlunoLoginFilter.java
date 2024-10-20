package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author con_c
 */
public class AlunoLoginFilter implements Filter {
    
    private static final boolean debug = true;
    private FilterConfig filterConfig = null;
    
    public AlunoLoginFilter() {
    }
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AlunoFilter:DoBeforeProcessing");
        }
    }
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AlunoFilter:DoAfterProcessing");
        }
    }

    /**
     * 
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     * 
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain)
        throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Checar se o aluno está logado
        boolean alunoLogado = (session != null && session.getAttribute("alunoLogado") != null);
        boolean respLogado = (session != null && session.getAttribute("respLogado") != null);
        boolean profLogado = (session != null && session.getAttribute("profLogado") != null);
        
        String path = httpRequest.getRequestURI();

        // FILTRO ALUNO ----------------------
        if (alunoLogado && path.endsWith("/login_aluno.jsp")) {
            // Se o aluno está logado e tentando acessar o login, redirecionar para o ambiente
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/ambiente_aluno.jsp");
        } else if (!alunoLogado && (
                    path.endsWith("/ambiente_aluno.jsp") || // Lista de páginas bloqueadas.
                    path.endsWith("/ambiente_aluno_boletim.jsp") ||
                    path.endsWith("/ambiente_aluno_chat.jsp") ||
                    path.endsWith("/ambiente_aluno_config.jsp") ||
                    path.endsWith("/ambiente_aluno_horarios.jsp") ||
                    path.endsWith("/ambiente_aluno_materias.jsp") ||
                    path.endsWith("/ambiente_aluno_professores.jsp") ||
                    path.endsWith("/ambiente_aluno_turma.jsp")
                    
                )) {
            // Se o aluno não está logado e tentando acessar o ambiente, redirecionar para o login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login_aluno.jsp");
            
            
        // FILTRO RESPONSÁVEL ----------------------
        } else if (respLogado && path.endsWith("/login_resp.jsp")) {
            // Se o responsável está logado e tentando acessar o login, redirecionar para o ambiente
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/ambiente_resp.jsp");
        } else if (!respLogado && (
                    path.endsWith("/ambiente_resp.jsp") || // Lista de páginas bloqueadas.
                    path.endsWith("/ambiente_resp_aluno.jsp") ||
                    path.endsWith("/ambiente_resp_boletim.jsp") ||
                    path.endsWith("/ambiente_resp_chat.jsp") ||
                    path.endsWith("/ambiente_resp_config.jsp") ||
                    path.endsWith("/ambiente_resp_horarios.jsp") ||
                    path.endsWith("/ambiente_resp_materias.jsp") ||
                    path.endsWith("/ambiente_resp_professores.jsp") ||
                    path.endsWith("/ambiente_resp_turma.jsp")
                )) {
            // Se o responsável não está logado e tentando acessar o ambiente, redirecionar para o login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login_resp.jsp");
            
        // FILTRO PROFESSOR ----------------------
        } else if (profLogado && path.endsWith("/login_prof.jsp")) {
            // Se o professor está logado e tentando acessar o login, redirecionar para o ambiente
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/ambiente_prof.jsp");
        } else if (!profLogado && (
                    path.endsWith("/ambiente_prof.jsp") || // Lista de páginas bloqueadas.
                    path.endsWith("/ambiente_prof_aluno.jsp") ||
                    path.endsWith("/ambiente_prof_chat.jsp") ||
                    path.endsWith("/ambiente_prof_config.jsp") ||
                    path.endsWith("/ambiente_prof_horarios.jsp") ||
                    path.endsWith("/ambiente_prof_materias.jsp") ||
                    path.endsWith("/ambiente_prof_notas.jsp") ||
                    path.endsWith("/ambiente_prof_outros.jsp") ||
                    path.endsWith("/ambiente_prof_turmas.jsp")
                )) {
            // Se o professor não está logado e tentando acessar o ambiente, redirecionar para o login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login_prof.jsp");
            
            
        } else {
            // Se a requisição não combinar com as condições acima, continuar processando 
            chain.doFilter(request, response);
        }

        if (debug) {
            log("AlunoFilter:doFilter()");
        }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AlunoFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AlunoFilter()");
        }
        StringBuffer sb = new StringBuffer("AlunoFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
