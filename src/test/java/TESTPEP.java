import org.kevoree.accesscontrol.*;
import org.kevoree.accesscontrol.pep.PEPMain;
import org.kevoree.accesscontrol.impl.DefaultAccessControlFactory;

/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 7/10/13
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class TESTPEP {

    public void main(String[] args) {
    //TODO
    AccessControlFactory factory = new DefaultAccessControlFactory();
    AccessControlPolicy modelAC = factory.createAccessControlPolicy();
    Domain myDomain = factory.createDomain();
    myDomain.setName("IaaSDomain");
    modelAC.addDomains(myDomain);
    PEPMain pep=new PEPMain();

    Resource node0= null;
    Resource node1= null;
    String access= null ;
    String rule1= null ;
    Subject bob= null;
    Subject alice= null;
    Condition alwaysapplicable= null;

    pep.createrule(rule1, bob, alwaysapplicable, node1, node0,modelAC);
    pep.createrule(rule1, alice, alwaysapplicable, node1, node0,modelAC);



    //boolean decision =pep.PDP(bob, access, node1, node0, myDomain, modelAC);
    //System.out.println(decision);


    }




}
