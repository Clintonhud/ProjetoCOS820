package org.agilekip.tutorials.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.agilekip.tutorials.service.dto.SelecaoPescProcessDTO;
import org.agilekip.tutorials.domain.SelecaoPesc;

//import java.math.BigDecimal;

@Component
public class InformarHomologacaoDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        SelecaoPescProcessDTO pi = (SelecaoPescProcessDTO) delegateExecution.getVariable("pi");

        String nome = pi.getSelecaoPesc().getNomeCompleto();
        String opcaoNivel = pi.getSelecaoPesc().getMestradoDoutorado();
        String opcaoLinha = pi.getSelecaoPesc().getLinhaAreaInteresse();
        String email = pi.getSelecaoPesc().getEmailPrincipal();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=======================================================================================================");
        System.out.println("======================================  PESC INFORMA:  ================================================");
        System.out.println("=======================================================================================================");
        System.out.println();
        System.out.println("### Prezado(a) "+nome+", ###");
        System.out.println("### Sua inscrição para o "+opcaoNivel+ " na área de "+opcaoLinha+" foi homologada com sucesso. ###");
        System.out.println("### Favor ficar atento ao email cadastrado para orientações futuras: "+email+" ###");
        System.out.println();
        System.out.println("========================================================================================================");
        System.out.println("======================================  FIM DA COMUNICAÇÃO =============================================");
        System.out.println("========================================================================================================");
        System.out.println();
        System.out.println();
        System.out.println();

}
}